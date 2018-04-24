package com.yuntian.adapterexample.list.typemode;


import com.yuntian.adapterexample.R;
import com.yuntian.adapterlib.imp.FootType;


/**
 * @author guangleilei
 * @version 1.0 2018-03-22
 */
public class FootType01 extends FootType {


    private String title;

    public FootType01() {
    }

    public FootType01(String title) {
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
        return R.layout.item_foot_01;
    }


}
