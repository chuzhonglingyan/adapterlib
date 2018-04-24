package com.yuntian.adapterexample.list;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.yuntian.adapterexample.base.DataBindingActivity;
import com.yuntian.adapterexample.databinding.ActivityMultitypeListBinding;
import com.yuntian.adapterexample.R;
import com.yuntian.adapterexample.list.good.GoodType;
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
public class MultiTypeGoodListActivity extends DataBindingActivity<ActivityMultitypeListBinding> {


    private BaseRvAdapter baseRvAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_multitype_list;
    }

    @Override
    protected void initView() {


        RecyclerViewUtil.initRecyclerViewV(this, mViewBinding.rv, true,
                baseRvAdapter = new BaseRvAdapter<GoodType>(getResopnData()) {
                });

        baseRvAdapter.setOnItemClickListener(new OnItemClickListener<TypeInterface>() {
            @Override
            public void onItemClick(View view, TypeInterface t, int truePos, int relativePos) {

                Toast.makeText(MultiTypeGoodListActivity.this, "truePos=" + truePos + ",位置relativePos=" + relativePos, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

        //baseRvAdapter.addHead(new HeadType01("我是头部01"));
        //baseRvAdapter.addHead(new HeadType01("我是头部02"));
    }

    public List<GoodType> getResopnData() {
        List<GoodType> goodBeans = new ArrayList<>();

        goodBeans.add(new GoodType(0, "男女装/内衣"));
        goodBeans.add(new GoodType(1, "女士服装", 20));
        goodBeans.add(new GoodType(1, "男士服装", 21));
        goodBeans.add(new GoodType(1, "内衣袜品", 22));
        goodBeans.add(new GoodType(1, "服饰配件", 23));

        goodBeans.add(new GoodType(0, "时尚美妆"));
        goodBeans.add(new GoodType(1, "美容护肤", 20));
        goodBeans.add(new GoodType(1, "个人护理", 21));
        goodBeans.add(new GoodType(1, "日用清洁"));

        goodBeans.add(new GoodType(0, "食品"));
        goodBeans.add(new GoodType(1, "酒", 20));
        goodBeans.add(new GoodType(1, "休闲食品", 21));
        goodBeans.add(new GoodType(1, "粮油调味", 29));
        goodBeans.add(new GoodType(1, "冲调饮品", 28));
        return goodBeans;
    }
}
