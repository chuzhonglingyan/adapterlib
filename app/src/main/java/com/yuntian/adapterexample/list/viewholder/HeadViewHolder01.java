package com.yuntian.adapterexample.list.viewholder;

import android.view.View;
import android.widget.TextView;

import com.yuntian.adapterexample.R;
import com.yuntian.adapterexample.list.typemode.HeadType01;
import com.yuntian.adapterlib.base.BaseViewHolder;


/**
 * @author guangleilei
 * @version 1.0 2018-03-22
 */
public class HeadViewHolder01 extends BaseViewHolder<HeadType01> {


    public HeadViewHolder01(View itemView) {
        super(itemView);
    }

    @Override
    public void onBindViewData(HeadType01 item, int position) {
        TextView textView=getView(R.id.tv_top);
        textView.setText(item.getTitle());
    }


}
