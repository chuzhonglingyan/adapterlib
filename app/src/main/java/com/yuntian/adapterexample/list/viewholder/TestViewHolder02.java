package com.yuntian.adapterexample.list.viewholder;

import android.view.View;
import android.widget.TextView;

import com.yuntian.adapterexample.R;
import com.yuntian.adapterexample.list.typemode.TestType02;
import com.yuntian.adapterlib.base.BaseViewHolder;


/**
 * @author guangleilei
 * @version 1.0 2018-03-22
 */
public class TestViewHolder02 extends BaseViewHolder<TestType02> {


    public TestViewHolder02(View itemView) {
        super(itemView);
    }

    @Override
    public void onBindViewData(TestType02 item, int position) {
        TextView textView1=getView(R.id.tv_name);
        TextView textView2=getView(R.id.tv_auth);
        textView1.setText(item.getTitle());
        textView2.setText(item.getContent());
    }


}
