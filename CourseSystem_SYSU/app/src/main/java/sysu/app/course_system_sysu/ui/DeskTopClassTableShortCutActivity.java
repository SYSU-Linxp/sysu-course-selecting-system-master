package sysu.app.course_system_sysu.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import org.json.JSONException;
import java.util.List;
import sysu.app.course_system_sysu.R;
import sysu.app.course_system_sysu.adapter.ClassTableAdapter;
import sysu.app.course_system_sysu.db.DBManager;
import sysu.app.course_system_sysu.model.ClassBean;
import sysu.app.course_system_sysu.model.ClassTableBean;
import sysu.app.course_system_sysu.utils.JsonParser;


public class DeskTopClassTableShortCutActivity extends AppCompatActivity {

    private String[] mDatas;
    RecyclerView recyclerView;
    ClassTableAdapter mAdapter;
    DBManager dbManager;
    List<ClassTableBean> tableBeans;
    String metaJsonData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desktop_shortcut_class_table);

        try {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }catch (Exception e){}

        dbManager = new DBManager(this);
        tableBeans = dbManager.getClassTables();
        System.out.println("size--->" + tableBeans.size());
        if (tableBeans.size() == 0){
            Toast.makeText(this, "你还没有添加一个课表",
                    Toast.LENGTH_LONG).show();

            finish();
        }
        try {
            metaJsonData = tableBeans.get(0).getMeta_json_data();
            initDatas();
            assignDatas();
            initViews();
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, "你还没有添加一个课表",
                    Toast.LENGTH_LONG).show();
            finish();
        }
    }



    private void assignDatas() {

        try {
            JsonParser parser = new JsonParser(metaJsonData);
            List<ClassBean> classes;
            classes = parser.getClassTableItems();
            handleClasses(classes);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.desktop_shortcut_class_table_recyclerview);
        mAdapter = new ClassTableAdapter(this, mDatas);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(8,
                StaggeredGridLayoutManager.HORIZONTAL));
    }

    private void initDatas(){

        mDatas = new String[58];
        String title[] = {"\\", "第一节", "第二节",
                "第三节",  "第四节", "第五节",
                "第六节", "未知时间课程", "星期一",  "星期二",
                "星期三",  "星期四",
                "星期五", "星期六", "星期日"};

        for(int i = 0; i < 15; i++){
            if (i < 9) {
                mDatas[i] = title[i];
            }else{
                mDatas[9 + (i - 8) * 7] = title[i];
            }
        }

    }

    private void handleClasses(List<ClassBean> classes){
        String classStrs[] = new String[42];
        String unkownClassStr = "";
        for(int i = 0; i < classStrs.length; i++ ){
            classStrs[i] = "";
        }
        for(ClassBean bean : classes){
            int where = bean.getWhere();
            if(where == -1){
                System.out.println("where == -1" + bean.getClassName());
                String classInfo = bean.getClassName()
                        + "("
                        + bean.getTeacher()
                        + ")";
                if(!unkownClassStr.isEmpty()){
                    unkownClassStr += "  、";
                }
                unkownClassStr += classInfo;
                continue;
            }

            String classInfo = bean.getClassName()
                    + "\n"
                    + bean.getTeacher()
                    + "\n("
                    + bean.getTime()
                    + "   "
                    + bean.getPosition()
                    + ")";
            if (classStrs[where].equals("")){
                classStrs[where] = classInfo;
            }else {
                classStrs[where] += "\n\n---------------------------------\n\n" + classInfo;
            }
            //change my datas
            mDatas[15] = unkownClassStr;

            for (int i = 0; i < 42; i++){
                int x = i / 6;
                //int y = i % 6;
                //System.out.println(i + "--->" + classStrs[i]);
                if (x == 0){
                    mDatas[i + 9] = classStrs[i];
                }else{
                    mDatas[i + (x + 10)] = classStrs[i];
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        for (ClassTableBean bean : tableBeans){
            menu.add(0, bean.getId(), 0,
                    bean.getUsername() + "-" + bean.getSemester()).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    setMetaJsonData(menuItem.getItemId());
                    return false;
                }
            });
        }
        return super.onCreateOptionsMenu(menu);
    }

    private void setMetaJsonData(int id){
        for(ClassTableBean bean : tableBeans){
            if (id == bean.getId()){
                metaJsonData = bean.getMeta_json_data();
                assignDatas();
                mAdapter.setDatas(mDatas);
            }
        }
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
}
