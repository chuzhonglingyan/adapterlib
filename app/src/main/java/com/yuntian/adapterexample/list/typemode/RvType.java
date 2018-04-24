package com.yuntian.adapterexample.list.typemode;


import com.yuntian.adapterexample.R;
import com.yuntian.adapterlib.base.TypeInterface;

import java.util.List;


/**
 * @author guangleilei
 * @version 1.0 2018-03-22
 */
public class RvType implements TypeInterface {


    private String title;

    private List<RvItemType> list;

    public List<RvItemType> getList() {
        return list;
    }

    public void setList(List<RvItemType> list) {
        this.list = list;
    }

    public RvType() {
    }

    public RvType(List<RvItemType> list) {
        this.list = list;
    }

    public RvType(String title) {
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
        return R.layout.item_rv;
    }



}
