package com.yuntian.adapterexample.list.viewholder;

import android.view.View;
import android.widget.TextView;

import com.yuntian.adapterexample.R;
import com.yuntian.adapterexample.list.typemode.TestType01;
import com.yuntian.adapterlib.base.BaseViewHolder;


/**
 * @author guangleilei
 * @version 1.0 2018-03-22
 */
public class TestViewHolder01 extends BaseViewHolder<TestType01> {


    public TestViewHolder01(View itemView) {
        super(itemView);
    }

    @Override
    public void onBindViewData(TestType01 item, int position) {
        TextView textView=getView(R.id.tv_top);
        textView.setText(item.getTitle());
    }

}
