package com.example.administrator.autolayout.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrator.autolayout.R;
import com.example.administrator.autolayout.ui.BaseActivity;

public class PhoneActivity extends BaseActivity {

    private ImageView back_settings;
    private EditText phone_id;
    private EditText verification_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        initView();
    }

    private void initView() {
        back_settings = (ImageView) findViewById(R.id.back_settings);
        phone_id = (EditText) findViewById(R.id.phone_id);
        verification_id = (EditText) findViewById(R.id.verification_id);
    }

    private void submit() {
        String phone = phone_id.getText().toString().trim();
        String verification = verification_id.getText().toString().trim();

        if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(verification)) {
            Toast.makeText(this, "您的输入有误,请仔细核对", Toast.LENGTH_SHORT).show();
            return;
        }

    }
}
