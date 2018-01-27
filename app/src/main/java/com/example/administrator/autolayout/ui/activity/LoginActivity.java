package com.example.administrator.autolayout.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.autolayout.R;
import com.example.administrator.autolayout.ui.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
*  登录界面
* */
public class LoginActivity extends BaseActivity {

    @BindView(R.id.bu_register)
    Button buRegister;
    @BindView(R.id.bu_login)
    Button buLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        buRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        buLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(HomeActivity.class);
            }
        });
    }
}
