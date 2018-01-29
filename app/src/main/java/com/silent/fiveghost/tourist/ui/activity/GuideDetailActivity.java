package com.silent.fiveghost.tourist.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.silent.fiveghost.tourist.ui.BaseActivity;
import com.silent.fiveghost.tourist.R;

import butterknife.BindView;
import butterknife.ButterKnife;
/*
*  导游详情
* */
public class GuideDetailActivity extends BaseActivity {

    @BindView(R.id.iv_back_all)
    ImageView ivBackAll;
    @BindView(R.id.tv_title_all)
    TextView tvTitleAll;
    @BindView(R.id.iv_message_all)
    ImageView ivMessageAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_details_01);
        ButterKnife.bind(this);
        ivMessageAll.setVisibility(View.GONE);
        tvTitleAll.setText("导游详情");
        ivBackAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(GuideStyleActivity.class);
            }
        });
    }
}
