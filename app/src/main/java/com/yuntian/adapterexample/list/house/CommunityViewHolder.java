package com.yuntian.adapterexample.list.house;

import android.view.View;
import android.widget.TextView;

import com.yuntian.adapterexample.R;
import com.yuntian.adapterexample.list.house.enity.Community;
import com.yuntian.adapterlib.imp.BaseViewHolderImp;


/**
 * @author guangleilei
 * @version 1.0 2018-03-22
 */
public class CommunityViewHolder extends BaseViewHolderImp<Community> {


    public CommunityViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void onBindViewBeanData(Community item, int position) {
        TextView textView = getView(R.id.tv_name);
        textView.setText(item.getName());
    }


}
