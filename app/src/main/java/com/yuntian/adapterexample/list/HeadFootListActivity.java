package com.yuntian.adapterexample.list;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.yuntian.adapterexample.base.DataBindingActivity;
import com.yuntian.adapterexample.databinding.ActivityAddHeadFootListBinding;
import com.yuntian.adapterexample.R;
import com.yuntian.adapterexample.list.typemode.FootType01;
import com.yuntian.adapterexample.list.typemode.HeadType01;
import com.yuntian.adapterexample.list.typemode.TestType01;
import com.yuntian.adapterlib.base.BaseRvAdapter;
import com.yuntian.adapterlib.base.TypeInterface;
import com.yuntian.adapterlib.listener.OnItemClickListener;
import com.yuntian.adapterlib.util.RecyclerViewUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author guangleilei
 * @version 1.0 2018-03-27
 */
public class HeadFootListActivity extends DataBindingActivity<ActivityAddHeadFootListBinding> {


    private BaseRvAdapter baseRvAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_head_foot_list;
    }

    @Override
    protected void initView() {

        RecyclerViewUtil.initRecyclerViewV(this,mViewBinding.rv,true,
                baseRvAdapter=new BaseRvAdapter(getData()) {} );

        baseRvAdapter.setOnItemClickListener(new OnItemClickListener<TypeInterface>() {
            @Override
            public void onItemClick(View view, TypeInterface t, int truePos, int relativePos) {
                baseRvAdapter.remove(truePos);
                Toast.makeText(HeadFootListActivity.this, "truePos=" + truePos+",位置relativePos=" + relativePos, Toast.LENGTH_SHORT).show();
            }
        });

        mViewBinding.tvAddHead.setOnClickListener((v)->{

            baseRvAdapter.addHead(new HeadType01("我是头部01"+ UUID.randomUUID().toString().substring(0,5)));
        });
        mViewBinding.tvAddsHead.setOnClickListener((v)->{
            baseRvAdapter.addHead(new HeadType01("我是头部01#"+ UUID.randomUUID().toString().substring(0,5)),1);
        });
        mViewBinding.tvAddFoot.setOnClickListener((v)->{

            baseRvAdapter.addFoot(new FootType01("我是尾部01"+ UUID.randomUUID().toString().substring(0,5)));
        });
        mViewBinding.tvAddsFoot.setOnClickListener((v)->{

            baseRvAdapter.addFoot(new FootType01("我是尾部01"+ UUID.randomUUID().toString().substring(0,5)),1);
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
        for (int i = 0; i < 20; i++) {
            data.add(new TestType01("我是大内密探0000"+i));
        }
        return data;
    }
}
