package com.example.administrator.autolayout.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.autolayout.R;
import com.example.administrator.autolayout.ui.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
* 订单内容——订单详情
* */
public class OrderContentActivity extends BaseActivity {

    @BindView(R.id.submit_orders_order)
    Button submitOrdersOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_content);
        ButterKnife.bind(this);
        submitOrdersOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(OrderDetailsActivity.class);
            }
        });
    }
}
