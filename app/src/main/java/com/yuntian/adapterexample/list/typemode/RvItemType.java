package com.yuntian.adapterexample.list.typemode;


import com.yuntian.adapterexample.R;
import com.yuntian.adapterlib.base.TypeInterface;


/**
 * @author guangleilei
 * @version 1.0 2018-03-22
 */
public class RvItemType implements TypeInterface {


    private String title;

    public RvItemType() {
    }

    public RvItemType(String title) {
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
        return R.layout.item_rv_item;
    }





}
