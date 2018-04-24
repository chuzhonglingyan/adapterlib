package com.yuntian.adapterexample.list.typemode;

import com.yuntian.adapterlib.base.TypeInterface;
import com.yuntian.adapterlib.base.ViewHolderManager;


/**
 * @author guangleilei
 * @version 1.0 2018-03-22
 */
public class TestType01 implements TypeInterface {


    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    private String title;

    public TestType01() {
    }

    public TestType01(String title) {
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
        return ViewHolderManager.getViewType(this.getClass(), type);
    }


}
