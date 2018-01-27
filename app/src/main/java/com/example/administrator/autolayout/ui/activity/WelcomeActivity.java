package com.example.administrator.autolayout.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.autolayout.R;
import com.example.administrator.autolayout.ui.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
*  欢迎界面   轮播图
* */
public class WelcomeActivity extends BaseActivity {

    @BindView(R.id.bu_welcome)
    Button buWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        buWelcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(LoginActivity.class);
            }
        });
    }
}
