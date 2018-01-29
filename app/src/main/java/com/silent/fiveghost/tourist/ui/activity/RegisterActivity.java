package com.silent.fiveghost.tourist.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.ui.BaseActivity;
import com.silent.fiveghost.tourist.ui.Join;

//注册页面
public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private ImageView register_mReturn;//返回
    private EditText register_phone;//手机号
    private EditText register_code;//验证码
    private EditText register_password_one;//密码
    private EditText register_password_two;//再次确认密码
    private Button register_btn;//获取验证码

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();

    }

    private void initView() {
        register_mReturn = (ImageView) findViewById(R.id.register_mReturn);
        register_phone = (EditText) findViewById(R.id.register_phone);
        register_code = (EditText) findViewById(R.id.register_code);
        register_password_one = (EditText) findViewById(R.id.register_password_one);
        register_password_two = (EditText) findViewById(R.id.register_password_two);
        register_btn = (Button) findViewById(R.id.register_btn);
        register_mReturn.setOnClickListener(this);
        register_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //返回
            case R.id.register_mReturn:

                break;
            //验证码(获取完验证码变更登录)
            case R.id.register_btn:
                submit();
                break;
        }
    }

    private void submit() {
        // validate
        String phone = register_phone.getText().toString().trim();
        String yzm = register_code.getText().toString().trim();
        String one = register_password_one.getText().toString().trim();
        String two = register_password_two.getText().toString().trim();
        if (phone == null || phone.equals("")) {
            Toast.makeText(this, "电话不能为空", Toast.LENGTH_SHORT).show();
            return;
        }else if (yzm == null || yzm.equals("")) {
            Toast.makeText(this, "验证码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }else if (one == null || one.equals("")) {
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }else if (two == null || two.equals("")) {
            Toast.makeText(this, "再次密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        if (Join.isMobile(phone) || Join.isPass(one)) {
            Toast.makeText(this, "成功", Toast.LENGTH_SHORT).show();
            startActivity(LoginActivity.class);
        } else {

            Toast.makeText(this, "失败", Toast.LENGTH_SHORT).show();
        }


    }
}
