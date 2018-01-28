package com.example.administrator.autolayout.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.autolayout.R;
import com.example.administrator.autolayout.ui.activity.HelpCenterActivity;
import com.example.administrator.autolayout.ui.activity.SettingActivity;

/**
 * Created by 韩学文 on 2018/1/28.
 * 愿我余生从心所欲任性妄为
 * 宁愿做灯红酒绿中张牙舞爪的鬼
 * 也不做平淡生活里委曲求全的谁
 */
/*
* 个人中心-----
* */
public class PersonalFragment extends Fragment {
    private ImageView isme_backbutton;//返回按钮
    private LinearLayout isme_settings_six;//设置
    private LinearLayout isme_help_seven;//帮助

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.isme, container, false);
        initView(view);
        initonClike();
        return view;
    }

    private void initonClike() {
        isme_settings_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), SettingActivity.class));
            }
        });
        isme_help_seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), HelpCenterActivity.class));
            }
        });
    }


    private void initView(View view) {
        isme_backbutton = (ImageView) view.findViewById(R.id.isme_backbutton);
        isme_settings_six = (LinearLayout) view.findViewById(R.id.isme_settings_six);
        isme_help_seven = (LinearLayout) view.findViewById(R.id.isme_helpzx_seven);
    }


}
