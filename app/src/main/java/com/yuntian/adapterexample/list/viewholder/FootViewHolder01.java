package com.yuntian.adapterexample.list.viewholder;

import android.view.View;
import android.widget.TextView;

import com.yuntian.adapterexample.R;
import com.yuntian.adapterexample.list.typemode.FootType01;
import com.yuntian.adapterlib.base.BaseViewHolder;


/**
 * @author guangleilei
 * @version 1.0 2018-03-22
 */
public class FootViewHolder01 extends BaseViewHolder<FootType01> {


    public FootViewHolder01(View itemView) {
        super(itemView);
    }

    @Override
    public void onBindViewData(FootType01 item, int position) {
        TextView textView=getView(R.id.tv_foot);
        textView.setText(item.getTitle());
    }
}
