package com.yuntian.adapterexample.list.good;

import android.view.View;
import android.widget.TextView;

import com.yuntian.adapterexample.R;
import com.yuntian.adapterlib.base.BaseViewHolder;


/**
 * @author guangleilei
 * @version 1.0 2018-03-22
 */
public class GoodViewHolder02 extends BaseViewHolder<GoodType> {


    public GoodViewHolder02(View itemView) {
        super(itemView);
    }

    @Override
    public void onBindViewData(GoodType item, int position) {
        TextView textView1=getView(R.id.tv_name);
        TextView textView2=getView(R.id.tv_auth);
        textView1.setText(item.getName());
        textView2.setText(item.getNum()+"");
    }



}
