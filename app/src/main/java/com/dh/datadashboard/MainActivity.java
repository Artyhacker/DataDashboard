package com.dh.datadashboard;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        ViewPager.OnPageChangeListener {

    private ViewPager mViewPager;
    private List<Fragment> mTabs = new ArrayList<Fragment>();
    private String[] mTitles = new String[]{"first fragment!","second fragment!",
                "third fragment!"};
    //private String[] mFragmentItems = new String[]{"0", "1", "2"};

    private FragmentPagerAdapter mAdapter;

    private List<TabView> mTabIndicators = new ArrayList<TabView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initDatas();

        mViewPager.setAdapter(mAdapter);

        initEvent();

    }

    //初始化所有事件
    private void initEvent() {

        mViewPager.setOnPageChangeListener(this);


    }

    private void initDatas() {
        for(String title: mTitles){
            TabFragment tabFragment = new TabFragment();
            Bundle bundle = new Bundle();

            bundle.putString(TabFragment.TITLE, title);
            tabFragment.setArguments(bundle);
            mTabs.add(tabFragment);
        }

        /*
        for(String i: mFragmentItems){
            TabFragment tabFragment = new TabFragment();
            Bundle bundle = new Bundle();
            bundle.putString(TabFragment.ITEM, i);
            tabFragment.setArguments(bundle);
            mTabs.add(tabFragment);
        }*/

        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public android.support.v4.app.Fragment getItem(int position) {
                return mTabs.get(position);
            }

            @Override
            public int getCount() {
                return mTabs.size();
            }
        };
    }

    private void initView() {

        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);

        TabView tabDashBoard = (TabView) findViewById(R.id.id_dashboard);
        mTabIndicators.add(tabDashBoard);
        TabView tabData = (TabView) findViewById(R.id.id_data);
        mTabIndicators.add(tabData);
        TabView tabSetting = (TabView) findViewById(R.id.id_setting);
        mTabIndicators.add(tabSetting);


        tabDashBoard.setOnClickListener(this);
        tabData.setOnClickListener(this);
        tabSetting.setOnClickListener(this);
        tabDashBoard.setIconAlpha(1.0f);
    }


    @Override
    public void onClick(View view) {

        resetOtherTabs(); //重置其他tab的颜色

        switch (view.getId()){
            case R.id.id_dashboard:
                mTabIndicators.get(0).setIconAlpha(1.0f);
                mViewPager.setCurrentItem(0,false);
                break;
            case R.id.id_data:
                mTabIndicators.get(1).setIconAlpha(1.0f);
                mViewPager.setCurrentItem(1,false);
                break;
            case R.id.id_setting:
                mTabIndicators.get(2).setIconAlpha(1.0f);
                mViewPager.setCurrentItem(2,false);
                break;
        }
        
    }

    private void resetOtherTabs() {
        for(int i = 0; i < mTabIndicators.size(); i++){
            mTabIndicators.get(i).setIconAlpha(0);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        //Log.e("TAG", "position = " + position + " , positionOffset = " + positionOffset);

        if(positionOffset > 0){
            TabView left = mTabIndicators.get(position);
            TabView right = mTabIndicators.get(position + 1);

            left.setIconAlpha(1 - positionOffset);
            right.setIconAlpha(positionOffset);
        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
