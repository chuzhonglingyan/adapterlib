package com.yuntian.adapterexample.list.main;

/**
 * description  .
 * Created by ChuYingYan on 2018/4/6.
 */
public class MainBean {

    public MainBean(String title) {
        this.title = title;
    }


    public MainBean(int pageType,String title ) {
        this.title = title;
        this.pageType = pageType;
    }

    private String title;
    private int pageType;

    public int getPageType() {
        return pageType;
    }

    public void setPageType(int pageType) {
        this.pageType = pageType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
