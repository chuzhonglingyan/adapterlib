package com.yuntian.adapterexample.list.good;


import com.yuntian.adapterexample.util.ViewHolderManagerUtil;
import com.yuntian.adapterlib.base.TypeInterface;

/**
 * description  .
 * Created by ChuYingYan on 2018/4/6.
 */
public class GoodType implements TypeInterface {


    private String name;
    private int type;

    private int num;

    private String title;


    public GoodType(int type, String title) {
        this.type = type;
        this.title = title;
    }

    public GoodType(int type, String name, int num) {
        this.name = name;
        this.type = type;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public int getViewType() {
        return ViewHolderManagerUtil.getViewType(this.getClass(),type);
    }

}
