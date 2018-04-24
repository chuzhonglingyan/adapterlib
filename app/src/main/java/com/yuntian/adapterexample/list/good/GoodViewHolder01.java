package com.yuntian.adapterexample.list.good;

import android.view.View;
import android.widget.TextView;

import com.yuntian.adapterexample.R;
import com.yuntian.adapterlib.base.BaseViewHolder;


/**
 * @author guangleilei
 * @version 1.0 2018-03-22
 */
public class GoodViewHolder01 extends BaseViewHolder<GoodType> {


    public GoodViewHolder01(View itemView) {
        super(itemView);
    }

    @Override
    public void onBindViewData(GoodType item, int position) {
        TextView textView=getView(R.id.tv_top);
        textView.setText(item.getTitle());
    }
}
