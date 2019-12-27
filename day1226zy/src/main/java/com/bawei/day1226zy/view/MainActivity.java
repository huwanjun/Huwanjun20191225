package com.bawei.day1226zy.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.RadioGroup;

import com.bawei.day1226zy.R;
import com.bawei.day1226zy.base.BaseActivity;
import com.bawei.day1226zy.base.BasePresenter;
import com.bawei.day1226zy.view.fragment.HomeFragment;
import com.bawei.day1226zy.view.fragment.OthersFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private ViewPager vp;
    private RadioGroup rg;
    private List<Fragment> list=new ArrayList<>();


    @Override
    protected void initData() {

        HomeFragment homeFragment = new HomeFragment();
        OthersFragment flFragment = new OthersFragment();
        OthersFragment myFragment = new OthersFragment();

        list.add(homeFragment);
        list.add(flFragment);
        list.add(myFragment);

        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

    }

    @Override
    protected void initView() {
        vp=findViewById(R.id.vp);
        rg=findViewById(R.id.rg);

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                rg.check(rg.getChildAt(i).getId());

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){

                    case R.id.btn1:
                        vp.setCurrentItem(0);
                        break;

                    case R.id.btn2:
                        vp.setCurrentItem(1);
                        break;

                    case R.id.btn3:
                        vp.setCurrentItem(2);
                        break;
                }
            }
        });



    }

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }
}
