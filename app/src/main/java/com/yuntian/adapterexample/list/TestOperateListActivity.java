package com.yuntian.adapterexample.list;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.yuntian.adapterexample.base.DataBindingActivity;
import com.yuntian.adapterexample.databinding.ActivityTestOperateListBinding;
import com.yuntian.adapterexample.R;
import com.yuntian.adapterexample.list.typemode.FootType01;
import com.yuntian.adapterexample.list.typemode.HeadType01;
import com.yuntian.adapterexample.list.typemode.TestType01;
import com.yuntian.adapterlib.base.BaseRvAdapter;
import com.yuntian.adapterlib.base.TypeInterface;
import com.yuntian.adapterlib.listener.OnItemDataClickListener;
import com.yuntian.adapterlib.util.RecyclerViewUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author guangleilei
 * @version 1.0 2018-03-27
 */
public class TestOperateListActivity extends DataBindingActivity<ActivityTestOperateListBinding> {


    private BaseRvAdapter baseRvAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_test_operate_list;
    }

    @Override
    protected void initView() {

        RecyclerViewUtil.initRecyclerViewV(this, mViewBinding.rv, true,
                baseRvAdapter = new BaseRvAdapter(getData()) {
                });
        baseRvAdapter.setOnItemDataClickListener(new OnItemDataClickListener<TypeInterface>() {
            @Override
            public void onHeadItemClick(View view, TypeInterface item, int truePos, int relativePos) {

            }

            @Override
            public void onFootItemClick(View view, TypeInterface item, int truePos, int relativePos) {

            }

            @Override
            public void onItemClick(View view, TypeInterface item, int truePos, int relativePos) {
                baseRvAdapter.update(truePos, new TestType01("我是更新" + truePos + "," + UUID.randomUUID().toString().substring(0, 5)));
                Toast.makeText(TestOperateListActivity.this, "truePos=" + truePos + ",位置relativePos=" + relativePos, Toast.LENGTH_SHORT).show();
            }
        });

        mViewBinding.tvAdd.setOnClickListener((v) -> {

            baseRvAdapter.add(new TestType01("我是大内密探" + UUID.randomUUID().toString().substring(0, 5)), 1);
        });
        mViewBinding.tvAdds.setOnClickListener((v) -> {
            baseRvAdapter.adds(getAdds(3), 2);
        });
        mViewBinding.tvDelete.setOnClickListener((v) -> {
            baseRvAdapter.removeAt(2);
        });
        mViewBinding.tvDeletes.setOnClickListener((v) -> {
            baseRvAdapter.removesAt(3, 2);
        });
        mViewBinding.tvUpdate.setOnClickListener((v) -> {

            //baseRvAdapter.addFoot(new TestType01("我是尾部01"+ UUID.randomUUID().toString().substring(0,5)),1);
        });

        mViewBinding.tvUpdates.setOnClickListener((v) -> {

            //baseRvAdapter.addFoot(new TestType01("我是尾部01"+ UUID.randomUUID().toString().substring(0,5)),1);
        });

        mViewBinding.tvQuery.setOnClickListener((v) -> {

        });

        mViewBinding.tvQuerys.setOnClickListener((v) -> {

        });
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        baseRvAdapter.addHead(new HeadType01("我是头部01"));
        baseRvAdapter.addHead(new HeadType01("我是头部02"));
        baseRvAdapter.addFoot(new FootType01("我是尾吧01"));
        baseRvAdapter.addFoot(new FootType01("我是尾吧02"));
    }


    private List<TypeInterface> getData() {
        List<TypeInterface> data = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            data.add(new TestType01("我是大内密探0000" + i));
        }
        return data;
    }

    private List<TypeInterface> getAdds(int size) {
        List<TypeInterface> data = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            data.add(new TestType01("我是被插入" + i));
        }
        return data;
    }
}
