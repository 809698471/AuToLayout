package com.example.administrator.autolayout.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.autolayout.R;

/**
 * A simple {@link Fragment} subclass.
 * 纸质发票
 */
public class Paper_invoiceFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.paper_invoice, null);
        return view;
    }

}
