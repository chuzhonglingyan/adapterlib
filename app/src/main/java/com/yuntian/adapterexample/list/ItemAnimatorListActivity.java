package com.yuntian.adapterexample.list;

import android.os.Bundle;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Toast;

import com.yuntian.adapterexample.R;
import com.yuntian.adapterexample.base.DataBindingActivity;
import com.yuntian.adapterexample.databinding.ActivityTouchOperateListBinding;
import com.yuntian.adapterexample.list.typemode.TestType01;
import com.yuntian.adapterlib.base.TypeInterface;
import com.yuntian.adapterlib.helper.SimpleItemTouchHelperCallback;
import com.yuntian.adapterlib.helper.TouchAdapter;
import com.yuntian.adapterlib.listener.OnItemDataClickListener;
import com.yuntian.adapterlib.util.RecyclerViewUtil;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;

/**
 * @author guangleilei
 * @version 1.0 2018-03-27
 */
public class ItemAnimatorListActivity extends DataBindingActivity<ActivityTouchOperateListBinding> {


    private TouchAdapter touchAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_touch_operate_list;
    }

    @Override
    protected void initView() {

        touchAdapter=new TouchAdapter(getData());
        RecyclerViewUtil.initRecyclerViewV(this, mViewBinding.rv, true, touchAdapter);

       // 先实例化Callback
        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(touchAdapter);
        //用Callback构造ItemtouchHelper
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        //调用ItemTouchHelper的attachToRecyclerView方法建立联系
        touchHelper.attachToRecyclerView(mViewBinding.rv);

        mViewBinding.rv.setItemAnimator(new SlideInLeftAnimator());

        touchAdapter.setOnItemDataClickListener(new OnItemDataClickListener<TypeInterface>() {
            @Override
            public void onHeadItemClick(View view, TypeInterface item, int truePos, int relativePos) {

            }

            @Override
            public void onFootItemClick(View view, TypeInterface item, int truePos, int relativePos) {

            }

            @Override
            public void onItemClick(View view, TypeInterface item, int truePos, int relativePos) {
                touchAdapter.remove(truePos);
                Toast.makeText(ItemAnimatorListActivity.this, "truePos=" + truePos + ",位置relativePos=" + relativePos, Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    private List<TypeInterface> getData() {
        List<TypeInterface> data = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            data.add(new TestType01("我是大内密探0000" + i));
        }
        return data;
    }

}
