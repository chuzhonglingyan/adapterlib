package com.yuntian.adapterexample.list;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.yuntian.adapterexample.base.DataBindingActivity;
import com.yuntian.adapterexample.databinding.ActivityNestListBinding;
import com.yuntian.adapterexample.R;
import com.yuntian.adapterexample.list.typemode.RvItemType;
import com.yuntian.adapterexample.list.typemode.RvType;
import com.yuntian.adapterexample.list.typemode.TestType01;
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
public class NestnestListActivity extends DataBindingActivity<ActivityNestListBinding> {


    private BaseRvAdapter baseRvAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_nest_list;
    }

    @Override
    protected void initView() {

        RecyclerViewUtil.initRecyclerViewV(this,mViewBinding.rv,true,
                baseRvAdapter=new BaseRvAdapter(getData()) {} );

        baseRvAdapter.setOnItemClickListener(new OnItemClickListener<TypeInterface>() {
            @Override
            public void onItemClick(View view, TypeInterface t, int truePos, int relativePos) {

                Toast.makeText(NestnestListActivity.this, "truePos=" + truePos+",位置relativePos=" + relativePos, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }


    private List<TypeInterface> getData() {
        List<TypeInterface> data = new ArrayList<>();
      //  data.add(new BannerType());
        for (int i = 0; i <5; i++) {
            data.add(new TestType01("我是商品AA"+i));
        }
        data.add(new RvType(getRvitems()));
        for (int i = 0; i <5; i++) {
            data.add(new TestType01("我是商品BB"+i));
        }
        data.add(new RvType(getRvitems()));
        for (int i = 0; i <5; i++) {
            data.add(new TestType01("我是商品CC"+i));
        }
        return data;
    }

    public List<RvItemType> getRvitems(){
        List<RvItemType> data = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            data.add(new RvItemType("商品"+i));
        }
        return  data;
    }

}
