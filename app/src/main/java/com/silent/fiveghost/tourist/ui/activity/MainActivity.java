package com.silent.fiveghost.tourist.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.silent.fiveghost.tourist.ui.BaseActivity;
import com.silent.fiveghost.tourist.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
*  启动界面
* */
public class MainActivity extends BaseActivity {

    @BindView(R.id.bu_start)
    Button buStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        buStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(WelcomeActivity.class);
            }
        });
    }
}
