package sysu.app.course_system_sysu.ui.choose_course;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;
import sysu.app.course_system_sysu.R;

public class ChooseCourseActivity extends AppCompatActivity {

    private FragmentPagerAdapter mAdapter;
    private List<Fragment> mFragments;
    ViewPager pager = null;
    PagerTabStrip tabStrip = null;
    ArrayList<String> titleContainer = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_course);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initPager();
    }



    private void initPager() {
        pager = (ViewPager) findViewById(R.id.choose_course_viewpager);
        tabStrip = (PagerTabStrip) findViewById(R.id.choose_course_tabstrip);
        tabStrip.setDrawFullUnderline(false);

        tabStrip.setTabIndicatorColor(Color.argb(255, 0x03, 0xA9, 0xF4));
        tabStrip.setTextSpacing(200);

        titleContainer.add("公选课");
        titleContainer.add("专选课");
        titleContainer.add("必修课");

        mFragments = new ArrayList<>();
        Fragment mTab01 = new PrerequsiteCourseFragment();
        Fragment mTab02 = new SpecifiedSelectiveCourseFragment();
        Fragment mTab03 = new PublicSelectiveCourseFragment();
        mFragments.add(mTab01);
        mFragments.add(mTab02);
        mFragments.add(mTab03);

        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager())
        {

            @Override
            public int getCount()
            {
                return mFragments.size();
            }

            @Override
            public Fragment getItem(int arg0)
            {
                return mFragments.get(arg0);
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titleContainer.get(position);
            }
        };
        pager.setAdapter(mAdapter);

    }

    // do nothing for avoiding activity exception
    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        //super.onSaveInstanceState(outState, outPersistentState);
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