package com.example.administrator.autolayout.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.autolayout.R;
import com.recker.flybanner.FlyBanner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 韩学文 on 2018/1/28.
 * 愿我余生从心所欲任性妄为
 * 宁愿做灯红酒绿中张牙舞爪的鬼
 * 也不做平淡生活里委曲求全的谁
 */

public class RvSuggestAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<String> strings;
    private List<String> stringList;
    private List<String> stringList1;
    private List<String> stringList2;

    public RvSuggestAdapter(Context context, List<String> strings, List<String> stringList, List<String> stringList1, List<String> stringList2) {
        this.context = context;
        this.stringList = stringList;
        this.stringList1 = stringList1;
        this.stringList2 = stringList2;
        this.strings = strings;
    }

    @Override
    public int getItemViewType(int position) {
        if (strings.get(position).equals("one")) {
            return 0;
        } else if (strings.get(position).equals("two")) {
            return 1;
        } else if (strings.get(position).equals("three")) {
            return 2;
        } else if (strings.get(position).equals("for")) {
            return 3;
        } else {
            return 0;
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater from = LayoutInflater.from(context);
        RecyclerView.ViewHolder view1 = null;
        switch (viewType) {
            case 0:
                View v1 = from.inflate(R.layout.rvitemone, parent, false);
                view1 = new OneViewHolder(v1);
                break;
            case 1:
                View v2 = from.inflate(R.layout.rvitemtwo, parent, false);
                view1 = new TwoViewHolder(v2);
                break;
            case 2:
                View v3 = from.inflate(R.layout.rvitemthree, parent, false);
                view1 = new ThreeViewHolder(v3);
                break;
            case 3:
                View v4 = from.inflate(R.layout.rvitemfor, parent, false);
                view1 = new ForViewHolder(v4);
                break;

        }

        return view1;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof OneViewHolder) {
            List<Integer> integers = new ArrayList<Integer>();
            integers.add(R.mipmap.ic_launcher);
            integers.add(R.mipmap.ic_launcher);
            integers.add(R.mipmap.ic_launcher);
            ((OneViewHolder) holder).fl_banner_one.setImages(integers);
        } else if (holder instanceof TwoViewHolder) {
            ((TwoViewHolder) holder).tv_one.setText(stringList.get(0));
            ((TwoViewHolder) holder).tv_two.setText(stringList.get(1));
            ((TwoViewHolder) holder).tv_three.setText(stringList.get(2));
            ((TwoViewHolder) holder).tv_for.setText(stringList.get(3));
            ((TwoViewHolder) holder).tv_five.setText(stringList.get(4));
        } else if (holder instanceof ThreeViewHolder) {
            ((ThreeViewHolder) holder).tv_content.setText(stringList1.get(0));
            ((ThreeViewHolder) holder).tv_content_two.setText(stringList1.get(1));
            ((ThreeViewHolder) holder).tv_content_three.setText(stringList1.get(2));
            ((ThreeViewHolder) holder).tv_content_for.setText(stringList1.get(3));

        } else if (holder instanceof ForViewHolder) {
            ScrollDisabledListViewAdapter adapter = new ScrollDisabledListViewAdapter(stringList2);
            ((ForViewHolder) holder).viewById.setAdapter(adapter);
        }
    }

    @Override
    public int getItemCount() {
        return strings.size();
    }


    private class OneViewHolder extends RecyclerView.ViewHolder {

        private FlyBanner fl_banner_one;

        public OneViewHolder(View v1) {
            super(v1);
            fl_banner_one = v1.findViewById(R.id.fl_banner_one);
        }
    }

    private class TwoViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_one;
        private TextView tv_two;
        private TextView tv_three;
        private TextView tv_for;
        private TextView tv_five;

        public TwoViewHolder(View v2) {
            super(v2);
            tv_one = v2.findViewById(R.id.tv_one);
            tv_two = v2.findViewById(R.id.tv_two);
            tv_three = v2.findViewById(R.id.tv_three);
            tv_for = v2.findViewById(R.id.tv_for);
            tv_five = v2.findViewById(R.id.tv_five);
        }
    }

    private class ThreeViewHolder extends RecyclerView.ViewHolder {


        private TextView tv_content;
        private TextView tv_content_two;
        private TextView tv_content_three;
        private TextView tv_content_for;
        private LinearLayout lineOne;

        public ThreeViewHolder(View v3) {
            super(v3);
            tv_content = v3.findViewById(R.id.tv_content_card);
            tv_content_two = v3.findViewById(R.id.tv_content_two);
            tv_content_three = v3.findViewById(R.id.tv_content_three);
            tv_content_for = v3.findViewById(R.id.tv_content_for);
            lineOne = v3.findViewById(R.id.line_one_three);

        }
    }

    private class ForViewHolder extends RecyclerView.ViewHolder {


        private ListView viewById;
        private RelativeLayout guidestyle;

        public ForViewHolder(View v4) {
            super(v4);
            viewById = v4.findViewById(R.id.lv_suggect);
            guidestyle = v4.findViewById(R.id.rl_guidestyle_for);

        }
    }


    private class ScrollDisabledListViewAdapter extends BaseAdapter {
        private List<String> stringList2;

        public ScrollDisabledListViewAdapter(List<String> stringList2) {
            this.stringList2 = stringList2;
        }

        @Override
        public int getCount() {
            return stringList2.size();
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
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(context).inflate(R.layout.guideitem, parent, false);
                holder.tv_daoyou = convertView.findViewById(R.id.tv_content_card_for);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.tv_daoyou.setText(stringList2.get(position));
            return convertView;
        }

        class ViewHolder {
            TextView tv_daoyou;
        }
    }
}

