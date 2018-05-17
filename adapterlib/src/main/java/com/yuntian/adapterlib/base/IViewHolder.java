package com.yuntian.adapterlib.base;

/**
 * description  .
 * Created by ChuYingYan on 2018/4/7.
 */
public interface IViewHolder {

    void onAttach(BaseRvAdapter baseRvAdapter);

    void onCreate();

    void onResume();

    void onStop();

    void onDestory();

}
