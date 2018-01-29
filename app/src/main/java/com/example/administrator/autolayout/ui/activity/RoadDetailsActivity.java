package com.example.administrator.autolayout.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.autolayout.R;
import com.example.administrator.autolayout.ui.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
*  路线详情——定单内容
* */
public class RoadDetailsActivity extends BaseActivity {

    @BindView(R.id.sign_up_immediately_road)
    Button signUpImmediatelyRoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_road_details);
        ButterKnife.bind(this);
        signUpImmediatelyRoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 startActivity(OrderContentActivity.class);
            }
        });
    }
}
