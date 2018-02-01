package com.silent.fiveghost.tourist.ui.activity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.ui.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
*  路线详情——定单内容
* */
public class RoadDetailsActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.sign_up_immediately_road)
    Button signUpImmediatelyRoad;
    @BindView(R.id.bu_time_start)
    Button buTimeStart;
    @BindView(R.id.bu_time_end)
    Button buTimeEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_road_details);
        ButterKnife.bind(this);
       signUpImmediatelyRoad.setOnClickListener(this);
        buTimeStart.setOnClickListener(this);
        buTimeEnd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_up_immediately_road:
                startActivity(OrderContentActivity.class);
                break;
            case R.id.bu_time_start:
                AlertDialog dialog = new AlertDialog.Builder(RoadDetailsActivity.this).create();
                dialog.show();
                DatePicker picker = new DatePicker(RoadDetailsActivity.this);

                ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.getWindow().setContentView(picker, params);
                dialog.getWindow().setGravity(Gravity.CENTER);
                break;
            case R.id.bu_time_end:
                break;
        }
    }
}
