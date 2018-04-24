package com.yuntian.adapterexample.list.viewholder;

import android.view.View;
import android.widget.TextView;

import com.yuntian.adapterexample.R;
import com.yuntian.adapterexample.list.typemode.RvItemType;
import com.yuntian.adapterlib.base.BaseViewHolder;


/**
 * @author guangleilei
 * @version 1.0 2018-03-22
 */
public class RvItemViewHolder extends BaseViewHolder<RvItemType> {


    public RvItemViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void onBindViewData(RvItemType item, int position) {
        TextView textView=getView(R.id.tv_item);
        textView.setText(item.getTitle());
    }
}
