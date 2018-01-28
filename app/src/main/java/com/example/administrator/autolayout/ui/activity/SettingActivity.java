package com.example.administrator.autolayout.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.autolayout.R;
import com.example.administrator.autolayout.ui.BaseActivity;

//设置界面
public class SettingActivity extends BaseActivity {

    private ImageView back_settings;//返回按钮
    private LinearLayout setting_safety;//安全设置
    private LinearLayout helpcenter_settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initView();
        initonLister();
    }

    private void initonLister() {
        setting_safety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(SafetyActivity.class);
            }
        });
        helpcenter_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void initView() {
        back_settings = (ImageView) findViewById(R.id.back_settings);
        setting_safety = (LinearLayout) findViewById(R.id.setting_safety);
        helpcenter_settings = (LinearLayout) findViewById(R.id.helpcenter_settings);
    }
}
