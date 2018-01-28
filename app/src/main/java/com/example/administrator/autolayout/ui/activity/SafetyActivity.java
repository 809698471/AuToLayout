package com.example.administrator.autolayout.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.autolayout.R;
import com.example.administrator.autolayout.ui.BaseActivity;

//账号安全
public class SafetyActivity extends BaseActivity {

    private ImageView back_settings;
    private LinearLayout safety_phone;
    private LinearLayout safety_uppassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safety);
        initView();
        initonLister();
    }

    private void initonLister() {
        safety_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(PhoneActivity.class);
            }
        });
        safety_uppassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(PasswordActivity.class);
            }
        });

    }

    private void initView() {
        back_settings = (ImageView) findViewById(R.id.back_settings);
        safety_phone = (LinearLayout) findViewById(R.id.safety_phone);
        safety_uppassword = (LinearLayout) findViewById(R.id.safety_uppassword);
    }
}
