package com.silent.fiveghost.tourist.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.silent.fiveghost.tourist.ui.BaseActivity;
import com.silent.fiveghost.tourist.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
*  欢迎界面   轮播图
* */
public class WelcomeActivity extends BaseActivity {

    @BindView(R.id.bu_welcome)
    Button buWelcome;
    @BindView(R.id.bu_invoice)
    Button buInvoice;

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
        buInvoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(InvoicingActivity.class);
            }
        });
    }
}
