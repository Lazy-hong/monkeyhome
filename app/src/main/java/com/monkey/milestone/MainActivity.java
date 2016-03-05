package com.monkey.milestone;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.monkey.home.R;
import com.monkey.ui.view.ChangeColorIconWithText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements View.OnClickListener,ViewPager.OnPageChangeListener{
   private ViewPager mViewPager;
    private FragmentPagerAdapter mAapter;
    private List<Fragment> mTabs= new ArrayList<Fragment>();
    private List<ChangeColorIconWithText> mTabIndicators= new ArrayList<ChangeColorIconWithText>();
    private MonkeyFragment monkeyFragment;
    private NewsFragment newsFragment;
    private PersonFragment personFragment;
    private ContactFragment contactFragment;
    private String[] mTitles = new String[]
            { "First Fragment !", "Second Fragment !", "Third Fragment !",
                    "Fourth Fragment !" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initDatas();
        initEvent();
    }

    /**
     * 初始化所有事件
     */
    private void initEvent()
    {

        mViewPager.setOnPageChangeListener(this);

    }

    private void initDatas() {
        monkeyFragment=new MonkeyFragment();
        newsFragment=new NewsFragment();
        personFragment=new PersonFragment();
        contactFragment=new ContactFragment();
        for (String title : mTitles)
        {
            MonkeyFragment monkeyFragment=new MonkeyFragment();
            Bundle bundle = new Bundle();
            bundle.putString(monkeyFragment.TITLE, title);
            monkeyFragment.setArguments(bundle);
            mTabs.add(monkeyFragment);
        }
//        mTabs.add(monkeyFragment);
//        mTabs.add(newsFragment);
//        mTabs.add(personFragment);
//        mTabs.add(contactFragment);
        mAapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mTabs.get(position);
            }

            @Override
            public int getCount() {
                return mTabs.size();
            }
        };
        mViewPager.setAdapter(mAapter);
    }

    private void initView(){
        mViewPager= (ViewPager) findViewById(R.id.id_viewpager);
        ChangeColorIconWithText one = (ChangeColorIconWithText) findViewById(R.id.id_indicator_one);
        mTabIndicators.add(one);
        ChangeColorIconWithText two = (ChangeColorIconWithText) findViewById(R.id.id_indicator_two);
        mTabIndicators.add(two);
        ChangeColorIconWithText three = (ChangeColorIconWithText) findViewById(R.id.id_indicator_three);
        mTabIndicators.add(three);
        ChangeColorIconWithText four = (ChangeColorIconWithText) findViewById(R.id.id_indicator_four);
        mTabIndicators.add(four);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        one.setIconAlpha(1.0f);
    }

    @Override
    public void onClick(View v) {
        clickTab(v);
    }
    /**
     * 点击Tab按钮
     *
     * @param v
     */
    private void clickTab(View v)
    {
        resetOtherTabs();

        switch (v.getId())
        {
            case R.id.id_indicator_one:
                mTabIndicators.get(0).setIconAlpha(1.0f);
                mViewPager.setCurrentItem(0, false);
                break;
            case R.id.id_indicator_two:
                mTabIndicators.get(1).setIconAlpha(1.0f);
                mViewPager.setCurrentItem(1, false);
                break;
            case R.id.id_indicator_three:
                mTabIndicators.get(2).setIconAlpha(1.0f);
                mViewPager.setCurrentItem(2, false);
                break;
            case R.id.id_indicator_four:
                mTabIndicators.get(3).setIconAlpha(1.0f);
                mViewPager.setCurrentItem(3, false);
                break;
        }
    }
    /**
     * 重置其他的TabIndicator的颜色
     */
    private void resetOtherTabs()
    {
        for (int i = 0; i < mTabIndicators.size(); i++)
        {
            mTabIndicators.get(i).setIconAlpha(0);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if(positionOffset>0){
            mTabIndicators.get(position+1).setIconAlpha(positionOffset);
            mTabIndicators.get(position).setIconAlpha(1-positionOffset);
        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
