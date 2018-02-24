package com.silent.fiveghost.tourist.ui.activity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RelativeLayout;

import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.ui.BaseActivity;
import com.silent.fiveghost.tourist.utils.ObservableScrollView;

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
    @BindView(R.id.osv)
    ObservableScrollView osv;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.spite_line)
    View spiteLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_road_details);
        ButterKnife.bind(this);
        signUpImmediatelyRoad.setOnClickListener(this);
        buTimeStart.setOnClickListener(this);
        buTimeEnd.setOnClickListener(this);
        //获取dimen属性中 标题和头部图片的高度
        final float title_height = 88;
        final float head_height = 128;

        //滑动事件回调监听（一次滑动的过程一般会连续触发多次）
        osv.setOnScrollListener(new ObservableScrollView.ScrollViewListener() {
            @Override
            public void onScroll(int oldy, int dy, boolean isUp) {
               /* DensityUtil Density = new DensityUtil();
                int mHeaderHeight_px = Density.dip2px(ScrollViewActivity.this, 200.0f);*/

                float move_distance = head_height - title_height;
                if (!isUp && dy <= move_distance) {//手指往上滑,距离未超过200dp
                    //标题栏逐渐从透明变成不透明
                    toolbar.setBackgroundColor(ContextCompat.getColor(RoadDetailsActivity.this, R.color.gray));
                    TitleAlphaChange(dy, move_distance);//标题栏渐变
                    HeaderTranslate(dy);//图片视差平移

                } else if (!isUp && dy > move_distance) {//手指往上滑,距离超过200dp
                    TitleAlphaChange(1, 1);//设置不透明百分比为100%，防止因滑动速度过快，导致距离超过200dp,而标题栏透明度却还没变成完全不透的情况。

                    HeaderTranslate(head_height);//这里也设置平移，是因为不设置的话，如果滑动速度过快，会导致图片没有完全隐藏。

//                    ivBack.setImageResource(R.mipmap.ic_back_dark);
//                    ivMore.setImageResource(R.mipmap.ic_more_dark);
//                    ivShoppingCart.setImageResource(R.mipmap.ic_shopping_dark);
                    spiteLine.setVisibility(View.VISIBLE);

                } else if (isUp && dy > move_distance) {//返回顶部，但距离头部位置大于200dp
                    //不做处理

                } else if (isUp && dy <= move_distance) {//返回顶部，但距离头部位置小于200dp
                    //标题栏逐渐从不透明变成透明
                    TitleAlphaChange(dy, move_distance);//标题栏渐变
                    HeaderTranslate(dy);//图片视差平移

//                    ivBack.setImageResource(R.mipmap.ic_back);
//                    ivMore.setImageResource(R.mipmap.ic_more);
//                    ivShoppingCart.setImageResource(R.mipmap.ic_shopping_cart);
                    spiteLine.setVisibility(View.GONE);
                }
            }
        });
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

    private void TitleAlphaChange(int dy, float mHeaderHeight_px) {//设置标题栏透明度变化
        float percent = (float) Math.abs(dy) / Math.abs(mHeaderHeight_px);
        //如果是设置背景透明度，则传入的参数是int类型，取值范围0-255
        //如果是设置控件透明度，传入的参数是float类型，取值范围0.0-1.0
        //这里我们是设置背景透明度就好，因为设置控件透明度的话，返回ICON等也会变成透明的。
        //alpha 值越小越透明
        int alpha = (int) (percent * 255);
        toolbar.getBackground().setAlpha(alpha);//设置控件背景的透明度，传入int类型的参数（范围0~255）

//        ivBack.getBackground().setAlpha(255 - alpha);
//        ivMore.getBackground().setAlpha(255 - alpha);
//        ivShoppingCart.getBackground().setAlpha(255 - alpha);
    }

    private void HeaderTranslate(float distance) {
//        lvHeader.setTranslationY(-distance);
//        ivHeader.setTranslationY(distance / 2);
    }

}
