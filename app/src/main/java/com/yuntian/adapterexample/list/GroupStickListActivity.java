package com.yuntian.adapterexample.list;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.yuntian.adapterexample.base.DataBindingActivity;
import com.yuntian.adapterexample.databinding.ActivityNestListBinding;
import com.yuntian.adapterexample.R;
import com.yuntian.adapterexample.list.typemode.TestType01;
import com.yuntian.adapterexample.util.StickyItemDecoration;
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
public class GroupStickListActivity extends DataBindingActivity<ActivityNestListBinding> {


    private BaseRvAdapter baseRvAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_nest_list;
    }

    @Override
    protected void initView() {

        RecyclerViewUtil.initRecyclerViewV(this, mViewBinding.rv, new StickyItemDecoration(4),
                baseRvAdapter = new BaseRvAdapter(getData()) {
                });

        baseRvAdapter.setOnItemClickListener(new OnItemClickListener<TypeInterface>() {
            @Override
            public void onItemClick(View view, TypeInterface t, int truePos, int relativePos) {

                Toast.makeText(GroupStickListActivity.this, "truePos=" + truePos + ",位置relativePos=" + relativePos, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    private List<TypeInterface> getData() {
        List<TypeInterface> data = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            data.add(new TestType01("我是商品AA" + i));
        }
        for (int i = 0; i < 5; i++) {
            data.add(new TestType01("我是商品BB" + i));
        }
        for (int i = 0; i < 5; i++) {
            data.add(new TestType01("我是商品CC" + i));
        }
        return data;
    }


}
