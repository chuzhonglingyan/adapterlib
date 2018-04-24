package com.yuntian.adapterexample.list.typemode;

import com.yuntian.adapterexample.R;
import com.yuntian.adapterlib.imp.HeadType;


/**
 * @author guangleilei
 * @version 1.0 2018-03-22
 */
public class HeadType01 extends HeadType {


    private String title;

    public HeadType01() {
    }

    public HeadType01(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int getViewType() {
        return R.layout.item_head_01;
    }



}
