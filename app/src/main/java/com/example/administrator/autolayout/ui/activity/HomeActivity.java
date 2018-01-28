package com.example.administrator.autolayout.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.administrator.autolayout.R;
import com.example.administrator.autolayout.adapter.HomeVpAdapter;
import com.example.administrator.autolayout.ui.BaseActivity;
import com.example.administrator.autolayout.ui.fragment.FeaturesFragment;
import com.example.administrator.autolayout.ui.fragment.OrderFragment;
import com.example.administrator.autolayout.ui.fragment.PersonalFragment;
import com.example.administrator.autolayout.ui.fragment.RecommendFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
*  主页
* */
public class HomeActivity extends BaseActivity {

    @BindView(R.id.vp_home)
    ViewPager vpHome;
    @BindView(R.id.tab_home)
    TabLayout tabHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        List<Fragment> fragmentList = new ArrayList<>();
        RecommendFragment recommendFragment = new RecommendFragment();
        FeaturesFragment featuresFragment = new FeaturesFragment();
        OrderFragment orderFragment = new OrderFragment();
        PersonalFragment personalFragment = new PersonalFragment();
        fragmentList.add(recommendFragment);
        fragmentList.add(featuresFragment);
        fragmentList.add(orderFragment);
        fragmentList.add(personalFragment);
        List<String> stringList = new ArrayList<>();
        stringList.add("推荐");
        stringList.add("特色");
        stringList.add("订单");
        stringList.add("个人");
        vpHome.setAdapter(new HomeVpAdapter(getSupportFragmentManager(),fragmentList,stringList));
        tabHome.setupWithViewPager(vpHome);
    }
}
