package com.yuntian.adapterexample.list.main;

import android.view.View;
import android.widget.TextView;

import com.yuntian.adapterexample.R;
import com.yuntian.adapterlib.imp.BaseViewHolderImp;


/**
 * @author guangleilei
 * @version 1.0 2018-03-22
 */
public class MainTypeViewHolder extends BaseViewHolderImp<MainBean> {


    public MainTypeViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void onBindViewBeanData(MainBean item, int position) {
        TextView textView = getView(R.id.tv_item);
        textView.setText(item.getTitle());
    }


}
