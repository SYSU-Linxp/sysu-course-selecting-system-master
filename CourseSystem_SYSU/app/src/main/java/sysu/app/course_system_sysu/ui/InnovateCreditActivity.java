package sysu.app.course_system_sysu.ui;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import sysu.app.course_system_sysu.R;
import sysu.app.course_system_sysu.adapter.InnovateCreditAdapter;
import sysu.app.course_system_sysu.model.ConstVal;
import sysu.app.course_system_sysu.model.InnovateCredit;
import sysu.app.course_system_sysu.model.UserInfo;
import sysu.app.course_system_sysu.utils.HtmlParser;
import sysu.app.course_system_sysu.utils.HttpUtils;

public class InnovateCreditActivity extends AppCompatActivity {

    private InnovateCreditAdapter mAdapter;
    private ListView mListView;
    private List<InnovateCredit> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_innovate_credit);
        try {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }catch (Exception e){}
        initListView();
        new GetInnovateCreditInfoAsyncTask().execute();
    }

    private void initListView() {
        mDatas = new ArrayList<>();
        //mDatas.add(new InnovateCredit("test", "test", "test"));
        mAdapter = new InnovateCreditAdapter(getApplicationContext()
                , mDatas);
        mListView = (ListView) findViewById(R.id.innovate_credit_lv);
        mListView.setAdapter(mAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    class GetInnovateCreditInfoAsyncTask extends AsyncTask<Void, Void, String> {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(InnovateCreditActivity.this,
                    "请等待...", "正在抓取数据...", true, false);
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                String data = HttpUtils.get(ConstVal.INNOVITATE_CREDIT_URL,
                        UserInfo.getInstance().getCookieStore());
                System.out.println(data);
                mDatas = HtmlParser.getInnovateCredits(data);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            return "";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressDialog.dismiss();
            if (s == null) {
                Toast.makeText(InnovateCreditActivity.this, "加载失败，请检查网络配置", Toast.LENGTH_SHORT).show();
                return;
            }
            mAdapter.setDatas(mDatas);
        }
    }
}
