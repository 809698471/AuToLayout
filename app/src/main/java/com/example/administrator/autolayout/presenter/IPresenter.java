package com.example.administrator.autolayout.presenter;

import com.example.administrator.autolayout.model.IModel;
import com.example.administrator.autolayout.model.IModelSon;
import com.example.administrator.autolayout.view.IView;

import java.util.Map;

/**
 * Created by 韩学文 on 2018/1/27.
 * 愿我余生从心所欲任性妄为
 * 宁愿做灯红酒绿中张牙舞爪的鬼
 * 也不做平淡生活里委曲求全的谁
 */

public class IPresenter {
    private IView view;
    private IModel model;

    public IPresenter(IView view) {
        this.view = view;
        model = new IModelSon();
    }


    public void DoRequest(String url, Map<String, String> map) {
        model.request(url, map, view);
    }
}
