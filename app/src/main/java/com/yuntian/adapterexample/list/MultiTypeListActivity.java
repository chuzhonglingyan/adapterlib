package com.yuntian.adapterexample.list;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.yuntian.adapterexample.base.DataBindingActivity;
import com.yuntian.adapterexample.databinding.ActivityMultitypeListBinding;
import com.google.gson.Gson;
import com.yuntian.adapterexample.R;
import com.yuntian.adapterexample.list.typemode.TestType01;
import com.yuntian.adapterexample.list.typemode.TestType02;
import com.yuntian.adapterlib.base.BaseRvAdapter;
import com.yuntian.adapterlib.base.TypeInterface;
import com.yuntian.adapterlib.listener.OnItemClickListener;
import com.yuntian.adapterlib.util.RecyclerViewUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guangleilei
 * @version 1.0 2018-03-27
 */
public class MultiTypeListActivity extends DataBindingActivity<ActivityMultitypeListBinding> {

    private static final String TAG = "MultiTypeListActivity";

    private BaseRvAdapter baseRvAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_multitype_list;
    }

    @Override
    protected void initView() {
        RecyclerViewUtil.initRecyclerViewV(this,mViewBinding.rv,true,
                baseRvAdapter=new BaseRvAdapter(getData()) {} );

        baseRvAdapter.setOnItemClickListener(new OnItemClickListener<TypeInterface>() {
            @Override
            public void onItemClick(View view, TypeInterface t, int truePos, int relativePos) {

                Toast.makeText(MultiTypeListActivity.this, "truePos=" + truePos+",位置relativePos=" + relativePos, Toast.LENGTH_SHORT).show();
            }
        });

        Log.d(TAG,""+baseRvAdapter.getData().toString());

        Log.d(TAG,"gson字符串："+ new Gson().toJson(baseRvAdapter.getData()));


    }

    @Override
    protected void initData(Bundle savedInstanceState) {

        //baseRvAdapter.addHead(new HeadType01("我是头部01"));
        //baseRvAdapter.addHead(new HeadType01("我是头部02"));
    }


    private List<TypeInterface> getData() {
        List<TypeInterface> data = new ArrayList<>();

        data.add(new TestType01("男女装/内衣"));
        data.add(new TestType02("女士服装", "20"));
        data.add(new TestType02("男士服装", "21"));
        data.add(new TestType02("内衣袜品", "22"));
        data.add(new TestType02("服饰配件", "22"));

        data.add(new TestType01("鞋"));
        data.add(new TestType02("男鞋", "23"));
        data.add(new TestType02("女鞋", "24"));

        data.add(new TestType01("时尚美妆"));
        data.add(new TestType02("美容护肤", "22"));
        data.add(new TestType02("个人护理", "23"));
        data.add(new TestType02("日用清洁", "23"));

        data.add(new TestType01("食品"));
        data.add(new TestType02("酒", "23"));
        data.add(new TestType02("休闲食品", "32"));
        data.add(new TestType02("粮油调味", "32"));
        data.add(new TestType02("冲调饮品", "32"));

        return data;
    }


}
