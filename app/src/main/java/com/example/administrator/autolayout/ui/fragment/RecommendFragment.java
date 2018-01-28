package com.example.administrator.autolayout.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.autolayout.R;
import com.example.administrator.autolayout.adapter.RvSuggestAdapter;
import com.example.administrator.autolayout.ui.activity.MessageActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by 韩学文 on 2018/1/28.
 * 愿我余生从心所欲任性妄为
 * 宁愿做灯红酒绿中张牙舞爪的鬼
 * 也不做平淡生活里委曲求全的谁
 */
/*
*   推荐
* */
public class RecommendFragment extends Fragment {
    @BindView(R.id.rv_suggest)
    RecyclerView rvSuggest;
    Unbinder unbinder;
    @BindView(R.id.iv_message_recommend)
    ImageView ivMessageRecommend;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recommend, container, false);
        unbinder = ButterKnife.bind(this, view);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        rvSuggest.setLayoutManager(manager);
        List<String> strings = new ArrayList<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");
        strings.add("for");
        List<String> stringList = new ArrayList<>();
        stringList.add("周边游");
        stringList.add("摄影游");
        stringList.add("摄影游");
        stringList.add("摄影游");
        stringList.add("摄影游");
        List<String> stringList1 = new ArrayList<>();
        stringList1.add("线路一");
        stringList1.add("线路二");
        stringList1.add("线路三");
        stringList1.add("线路四");
        List<String> stringList2 = new ArrayList<>();
        stringList2.add("导游A");
        stringList2.add("导游B");
        stringList2.add("导游C");
        stringList2.add("导游D");
        RvSuggestAdapter adapter = new RvSuggestAdapter(getActivity(), strings, stringList, stringList1, stringList2);
        rvSuggest.setAdapter(adapter);
        ivMessageRecommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), MessageActivity.class));
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
