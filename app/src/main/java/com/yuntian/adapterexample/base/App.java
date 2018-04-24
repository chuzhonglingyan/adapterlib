package com.yuntian.adapterexample.base;

import android.app.Application;

import com.yuntian.adapterexample.util.SmartRefreshLayoutUtil;


/**
 * description  .
 * Created by ChuYingYan on 2018/4/7.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SmartRefreshLayoutUtil.init();
    }
}