package sysu.app.course_system_sysu.ui.choose_course;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import sysu.app.course_system_sysu.R;
import sysu.app.course_system_sysu.adapter.PrerequisiteAndSpecifiedCourseAdapter;
import sysu.app.course_system_sysu.model.ClassBean;
import sysu.app.course_system_sysu.model.ConstVal;
import sysu.app.course_system_sysu.model.UserInfo;
import sysu.app.course_system_sysu.utils.HttpUtils;
import sysu.app.course_system_sysu.utils.JsonParser;

public class SpecifiedSelectiveCourseFragment extends Fragment
        implements AdapterView.OnItemClickListener{


    View view;
    ListView mLview;
    List<ClassBean> mDatas;
    PrerequisiteAndSpecifiedCourseAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_specified_selective_course, null);
        initListView();
        return view;

    }


    private void initListView() {
        mLview = (ListView) view.findViewById(R.id.specified_course_lv);
        mDatas = new ArrayList<>();
        mAdapter = new PrerequisiteAndSpecifiedCourseAdapter(getActivity(), mDatas);
        mLview.setAdapter(mAdapter);
        mLview.setOnItemClickListener(this);
        new GetDataAsyncTask().execute();

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        new ShowRequiredClassAsyncTask(mDatas.get(i).getKch()).execute();
    }

    class GetDataAsyncTask extends AsyncTask<Void, Void, Boolean> {
        ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(getActivity(),
                    "请等待...", "正在抓取数据...", true, false);
        }

        @Override
        protected Boolean doInBackground(Void... voids) {

            try {
                String reqUrl;
                if (UserInfo.getInstance().getChooseCourseType().equals(ConstVal.AfterChooseCourse)){
                    reqUrl = ConstVal.SEARCH_SPECIFIED_COURSE_URL;
                }else {
                    reqUrl = ConstVal.SEARCH_PRE_SPECIFIED_COURSE_URL;
                }
                String data = HttpUtils.get(reqUrl + UserInfo.getInstance().getUsername(),
                        UserInfo.getInstance().getCookieStore());
                JsonParser parser = new JsonParser(data);
                mDatas = parser.getPrerequisiteCourses();

            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }

            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            progressDialog.dismiss();
            if(aBoolean){
                mAdapter.setDatas(mDatas);
            }else {
                Toast.makeText(getActivity(), "加载失败，请检查网络配置", Toast.LENGTH_SHORT).show();
            }
        }
    }


    /**
     *
     */
    class ShowRequiredClassAsyncTask extends AsyncTask<Void, Void, List<ClassBean>> {
        String kch;
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(getActivity(),
                    "请等待...", "正在抓取数据...", true, false);
        }


        public ShowRequiredClassAsyncTask(String kch){
            this.kch = kch;
        }


        @Override
        protected List<ClassBean> doInBackground(Void... voids) {

            try {
                String reqUrl;
                if (UserInfo.getInstance().getChooseCourseType().equals(ConstVal.AfterChooseCourse)){
                    reqUrl = ConstVal.getSpecifiedCourseUrl(this.kch,
                                UserInfo.getInstance().getUsername())
                            + UserInfo.getInstance().getUsername();
                }else {
                    reqUrl = ConstVal.getPreSpecifiedCourseUrl(this.kch,
                                UserInfo.getInstance().getUsername())
                            + UserInfo.getInstance().getUsername();
                }
                String data = HttpUtils.get(reqUrl, UserInfo.getInstance().getCookieStore());
                JsonParser parser = new JsonParser(data);
                return parser.getAlternativeCourses();


            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(List<ClassBean> classes) {
            super.onPostExecute(classes);
            progressDialog.dismiss();
            if (classes != null){
                if (classes.size() == 0){
                    Toast.makeText(getActivity(), "本学期尚未开设此课程"
                            , Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("classes", (Serializable) classes);
                intent.putExtra("classType", "专业选修课");
                if (UserInfo.getInstance().getChooseCourseType()
                        .equals(ConstVal.AfterChooseCourse)){
                    intent.putExtra("addUrl", ConstVal.ADD_SPECIFIED_COURSE_URL);
                }else{
                    intent.putExtra("addUrl", ConstVal.ADD_PRE_SPECIFIED_COURSE_URL);
                }

                startActivity(intent);
            }else {
                Toast.makeText(getActivity(), "加载失败，请检查网络配置"
                        , Toast.LENGTH_SHORT).show();
            }
        }
    }

}
