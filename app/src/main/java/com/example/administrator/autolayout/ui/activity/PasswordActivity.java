package com.example.administrator.autolayout.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrator.autolayout.R;
import com.example.administrator.autolayout.ui.BaseActivity;

public class PasswordActivity extends BaseActivity {
//修改密码
    private ImageView back_settings;
    private EditText mFormer_password;
    private EditText mNew_password;
    private EditText makesNew_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        initView();
    }

    private void initView() {
        back_settings = (ImageView) findViewById(R.id.back_settings);
        mFormer_password = (EditText) findViewById(R.id.mFormer_password);
        mNew_password = (EditText) findViewById(R.id.mNew_password);
        makesNew_password = (EditText) findViewById(R.id.makesNew_password);
    }

    private void submit() {
        // validate
        String former = mFormer_password.getText().toString().trim();
        if (TextUtils.isEmpty(former)) {
            Toast.makeText(this, "请输入原密码", Toast.LENGTH_SHORT).show();
            return;
        }

        String newpass = mNew_password.getText().toString().trim();
        if (TextUtils.isEmpty(newpass)) {
            Toast.makeText(this, "请输入新密码", Toast.LENGTH_SHORT).show();
            return;
        }

        String makenew = makesNew_password.getText().toString().trim();
        if (TextUtils.isEmpty(makenew)) {
            Toast.makeText(this, "请输入新密码", Toast.LENGTH_SHORT).show();
            return;
        }


    }
}
