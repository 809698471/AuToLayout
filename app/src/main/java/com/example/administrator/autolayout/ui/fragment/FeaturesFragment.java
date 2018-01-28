package com.example.administrator.autolayout.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.administrator.autolayout.R;

/**
 * Created by 韩学文 on 2018/1/28.
 * 愿我余生从心所欲任性妄为
 * 宁愿做灯红酒绿中张牙舞爪的鬼
 * 也不做平淡生活里委曲求全的谁
 */
/*
*  特色
* */
public class FeaturesFragment extends Fragment {


    private ListView lv_shtick;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_orderform, container, false);
        initView(view);
        lv_shtick.setAdapter(new LvShtickAdapter());

        return view;
    }

    private void initView(View view) {
        lv_shtick = (ListView) view.findViewById(R.id.lv_shtick);
    }


    private class LvShtickAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.orderform_item, parent, false);

            return convertView;
        }


    }
}
