package com.yuntian.adapterexample.list.house;

import android.view.View;
import android.widget.TextView;

import com.yuntian.adapterexample.R;
import com.yuntian.adapterexample.list.house.enity.House;
import com.yuntian.adapterlib.imp.BaseViewHolderImp;


/**
 * @author guangleilei
 * @version 1.0 2018-03-22
 */
public class HouseHolder extends BaseViewHolderImp<House> {


    public HouseHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void onBindViewBeanData(House item, int position) {
        TextView textView1 = getView(R.id.tv_name);
        TextView textView2 = getView(R.id.tv_price);
        textView1.setText(item.getAddress());
        textView2.setText(item.getPrice());
    }


}
