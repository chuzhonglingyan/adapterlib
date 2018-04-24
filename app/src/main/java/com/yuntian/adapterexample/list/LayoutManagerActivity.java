package com.yuntian.adapterexample.list;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.yuntian.adapterexample.base.DataBindingActivity;
import com.yuntian.adapterexample.databinding.ActivityLayoutmanagerListBinding;
import com.yuntian.adapterexample.R;
import com.yuntian.adapterexample.list.typemode.TestType01;
import com.yuntian.adapterlib.base.BaseRvAdapter;
import com.yuntian.adapterlib.base.TypeInterface;
import com.yuntian.adapterlib.listener.OnItemDataClickListener;
import com.yuntian.adapterlib.util.RecyclerViewUtil;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;

/**
 * @author guangleilei
 * @version 1.0 2018-03-27
 */
public class LayoutManagerActivity extends DataBindingActivity<ActivityLayoutmanagerListBinding> {


    private BaseRvAdapter baseRvAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_layoutmanager_list;
    }

    @Override
    protected void initView() {

        baseRvAdapter=new BaseRvAdapter(getData()){};
        RecyclerViewUtil.initRecyclerViewV(this, mViewBinding.rv, true, baseRvAdapter);

        mViewBinding.rv.setItemAnimator(new SlideInLeftAnimator());

        baseRvAdapter.setOnItemDataClickListener(new OnItemDataClickListener<TypeInterface>() {
            @Override
            public void onHeadItemClick(View view, TypeInterface item, int truePos, int relativePos) {

            }

            @Override
            public void onFootItemClick(View view, TypeInterface item, int truePos, int relativePos) {

            }

            @Override
            public void onItemClick(View view, TypeInterface item, int truePos, int relativePos) {
                Toast.makeText(LayoutManagerActivity.this, "truePos=" + truePos + ",位置relativePos=" + relativePos, Toast.LENGTH_SHORT).show();
            }
        });

        mViewBinding.tvLinearVertical.setOnClickListener((v)->{
            RecyclerViewUtil.initRecyclerViewV(this, mViewBinding.rv, true, baseRvAdapter);

        });
        mViewBinding.tvLinearHorizontal.setOnClickListener((v)->{
            RecyclerViewUtil.initRecyclerViewH(this, mViewBinding.rv, true, baseRvAdapter);
        });
        mViewBinding.tvGrid.setOnClickListener((v)->{
            RecyclerViewUtil.initRecyclerViewG(this, mViewBinding.rv, true, baseRvAdapter,3);
        });
        mViewBinding.tvStragger.setOnClickListener((v)->{
            RecyclerViewUtil.initRecyclerViewSV(this, mViewBinding.rv, true, baseRvAdapter,3);
        });


    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    private List<TypeInterface> getData() {
        List<TypeInterface> data = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            data.add(new TestType01("我是大内密探0000" + i));
        }
        return data;
    }

}
