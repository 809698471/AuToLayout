package com.example.administrator.autolayout.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.autolayout.R;
import com.example.administrator.autolayout.ui.BaseActivity;

/*
*  登录界面
* */
public class LoginActivity extends BaseActivity implements View.OnClickListener {


    private EditText login_edit_yhm;
    private EditText login_edit_mm;
    private Button login_btn;
    private TextView login_wangji;
    private TextView login_zhuce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        login_edit_yhm = (EditText) findViewById(R.id.login_edit_yhm);
        login_edit_mm = (EditText) findViewById(R.id.login_edit_mm);
        login_btn = (Button) findViewById(R.id.login_btn);
        login_wangji = (TextView) findViewById(R.id.login_wangji);
        login_zhuce = (TextView) findViewById(R.id.login_zhuce);
        login_zhuce.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);//下划线
        login_zhuce.getPaint().setAntiAlias(true);//抗锯齿
        login_zhuce.setText(Html.fromHtml("" + "新用户？立即注册" + ""));
        login_edit_yhm.setOnClickListener(this);
        login_edit_mm.setOnClickListener(this);
        login_btn.setOnClickListener(this);
        login_wangji.setOnClickListener(this);
        login_zhuce.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_btn:
startActivity(HomeActivity.class);
                break;
            case R.id.login_wangji:
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //自动弹出键盘
                        InputMethodManager inputManager = (InputMethodManager) LoginActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE);
                        inputManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
                        //制隐藏Android输入法窗口
                        // inputManager.hideSoftInputFromWindow(edit.getWindowToken(),0);
                    }
                },100);

                //创建一个pop 必须传递的三个字段view  宽，高  三个少了一个出不来
                View view = View.inflate(LoginActivity.this, R.layout.popupview, null);
                PopupWindow popupWindow = new PopupWindow(view, 900, 1400);
                //获取焦点
                popupWindow.setFocusable(true);
                //window设置背景，如果不设置背景
                popupWindow.setOutsideTouchable(true);
                popupWindow.setBackgroundDrawable(new ColorDrawable(0));
                //设置pop在btn的下面x方向偏移，y方向偏移，这里的show方法一定要放在所有的设置之后，否则消失会不起作用
                popupWindow.showAsDropDown(login_wangji, -50,0);
                //设置popwindow的消失的监听
                popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        Toast.makeText(LoginActivity.this, "", Toast.LENGTH_SHORT).show();
                    }
                });
//                //给popWindow设置动画
//                ObjectAnimator//
//                        .ofFloat(view, "rotationX", 0.0F, 360.0F)//
//                        .setDuration(500)//
//                        .start();
                break;
            case R.id.login_zhuce:
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void submit() {
        // validate
        String yhm = login_edit_yhm.getText().toString().trim();
        if (TextUtils.isEmpty(yhm)) {
            Toast.makeText(this, "用户名/手机号/邮箱", Toast.LENGTH_SHORT).show();
            return;
        }

        String mm = login_edit_mm.getText().toString().trim();
        if (TextUtils.isEmpty(mm)) {
            Toast.makeText(this, "6位数字或字母", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
