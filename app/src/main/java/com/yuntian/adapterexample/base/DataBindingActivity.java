package com.yuntian.adapterexample.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.yuntian.adapterexample.R;
import com.yuntian.adapterexample.util.StatusBarCompat;


public abstract class DataBindingActivity<B extends ViewDataBinding> extends AppCompatActivity {

    protected Context mContext;
    protected Activity mActivity;
    public B mViewBinding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        initView();
        initData(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    protected void init() {
        mViewBinding = DataBindingUtil.setContentView(this, getLayoutId());
        mContext = this;
        mActivity = this;

        // 设置竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        // 默认着色状态栏
        SetStatusBarColor(R.color.main_color);
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initData(Bundle savedInstanceState);


    /**
     * 着色状态栏（4.4以上系统有效）
     */
    protected void SetStatusBarColor(@ColorRes int corlor) {
        StatusBarCompat.setStatusBarColor(this, ContextCompat.getColor(this, corlor));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
