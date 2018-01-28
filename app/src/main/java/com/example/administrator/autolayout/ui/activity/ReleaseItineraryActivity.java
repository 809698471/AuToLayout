package com.example.administrator.autolayout.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.example.administrator.autolayout.R;
import com.example.administrator.autolayout.ui.fragment.One_stop_releaseFragment;
import com.example.administrator.autolayout.ui.fragment.Sub_station_releaseFragment;
//发布行程
public class ReleaseItineraryActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView releaseitinerary_return;
    private ImageView releaseitinerary_img;

    private FrameLayout releaseitinerary_fragment;

    private FragmentManager msg;
    private FragmentTransaction transaction;
    private One_stop_releaseFragment one_stop_releaseFragment;
    private RadioButton releaseitinerary_radio1;
    private RadioButton releaseitinerary_radio2;
    private Sub_station_releaseFragment sub_station_releaseFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_release_itinerary);
        initView();
        initData();
    }

    private void initData() {
        //动态添加Fragment ,获取Fragment 管理器
        msg = getSupportFragmentManager();
        //开启Fragment事物
        transaction = msg.beginTransaction();

        one_stop_releaseFragment = new One_stop_releaseFragment();
        transaction.add(R.id.releaseitinerary_fragment, one_stop_releaseFragment);
        transaction.commit();
    }

    private void initView() {
        releaseitinerary_return = (ImageView) findViewById(R.id.releaseitinerary_return);
        releaseitinerary_img = (ImageView) findViewById(R.id.releaseitinerary_img);

        releaseitinerary_radio1 = (RadioButton) findViewById(R.id.releaseitinerary_radio1);
        releaseitinerary_radio2 = (RadioButton) findViewById(R.id.releaseitinerary_radio2);
        releaseitinerary_fragment = (FrameLayout) findViewById(R.id.releaseitinerary_fragment);

//        //判断home_pager是否为null
        if (one_stop_releaseFragment == null) {
            one_stop_releaseFragment = new One_stop_releaseFragment();
//            //设置首页默认被选中
            releaseitinerary_radio1.setChecked(true);
        }
        releaseitinerary_return.setOnClickListener(this);
        releaseitinerary_img.setOnClickListener(this);
        releaseitinerary_radio1.setOnClickListener(this);
        releaseitinerary_radio2.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        //动态添加Fragment ,获取Fragment 管理器
        msg = getSupportFragmentManager();
        //开启Fragment事物
        transaction = msg.beginTransaction();
        //方法2隐藏所有的Fragment。
        hideAll(transaction);
        switch (v.getId()) {
            case R.id.releaseitinerary_return:

                break;
            case R.id.releaseitinerary_img:

                break;
            case R.id.releaseitinerary_radio1:
                if ( one_stop_releaseFragment== null) {
                one_stop_releaseFragment = new One_stop_releaseFragment();
                    transaction.add(R.id.releaseitinerary_fragment, this.one_stop_releaseFragment);
                } else {
                    transaction.show(one_stop_releaseFragment);
                }
                break;
            case R.id.releaseitinerary_radio2:
                if ( sub_station_releaseFragment== null) {

                    sub_station_releaseFragment = new Sub_station_releaseFragment();
                    transaction.add(R.id.releaseitinerary_fragment, this.sub_station_releaseFragment);
                } else {

                    transaction.show(sub_station_releaseFragment);
                }
                break;

        }
        transaction.commit();
    }

    private void hideAll(FragmentTransaction transaction) {
        if (one_stop_releaseFragment != null) {
            transaction.hide(one_stop_releaseFragment);
        }
        if (sub_station_releaseFragment != null) {
            transaction.hide(sub_station_releaseFragment);
        }
    }
}
