package com.yuntian.adapterexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yuntian.adapterexample.base.DataBindingActivity;
import com.yuntian.adapterexample.databinding.ActivityMainBinding;
import com.yuntian.adapterexample.list.GroupStickListActivity;
import com.yuntian.adapterexample.list.HeadFootListActivity;
import com.yuntian.adapterexample.list.ItemAnimatorListActivity;
import com.yuntian.adapterexample.list.LayoutManagerActivity;
import com.yuntian.adapterexample.list.MultiTypeGoodListActivity;
import com.yuntian.adapterexample.list.MultiTypeListActivity;
import com.yuntian.adapterexample.list.NestnestDataListActivity;
import com.yuntian.adapterexample.list.NestnestListActivity;
import com.yuntian.adapterexample.list.SmartListActivity;
import com.yuntian.adapterexample.list.TestOperateListActivity;
import com.yuntian.adapterexample.list.TouchOperateListActivity;
import com.yuntian.adapterexample.list.main.MainBean;
import com.yuntian.adapterexample.list.main.MainType;
import com.yuntian.adapterlib.base.BaseRvAdapter;
import com.yuntian.adapterlib.base.TypeInterface;
import com.yuntian.adapterlib.listener.OnItemClickListener;
import com.yuntian.adapterlib.util.RecyclerViewUtil;
import com.yuntian.adapterlib.util.TypeUitl;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends DataBindingActivity<ActivityMainBinding> {


    private BaseRvAdapter baseRvAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        RecyclerViewUtil.initRecyclerViewV(this,mViewBinding.rv,true,
                baseRvAdapter=new BaseRvAdapter<MainType>(getData()) {} );
        baseRvAdapter.setOnItemClickListener(new OnItemClickListener<TypeInterface>() {
            @Override
            public void onItemClick(View view, TypeInterface t, int truePos, int relativePos) {
                   gotoActvity((MainType) t);
            }
        });

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    public void  gotoActvity(MainType type01){
        if (type01.getK().getPageType()==0){
            startActivity(new Intent(this, HeadFootListActivity.class));
        }else if (type01.getK().getPageType()==1){
            startActivity(new Intent(this, MultiTypeListActivity.class));
        }else if (type01.getK().getPageType()==2){
            startActivity(new Intent(this, NestnestListActivity.class));
        }else if (type01.getK().getPageType()==3){
            startActivity(new Intent(this, TestOperateListActivity.class));
        }else if (type01.getK().getPageType()==4){
            startActivity(new Intent(this, MultiTypeGoodListActivity.class));
        }else if (type01.getK().getPageType()==5){
            startActivity(new Intent(this, NestnestDataListActivity.class));
        } else if (type01.getK().getPageType()==6){
            startActivity(new Intent(this, TouchOperateListActivity.class));
        }else if (type01.getK().getPageType()==7){
            startActivity(new Intent(this, ItemAnimatorListActivity.class));
        }else if (type01.getK().getPageType()==8){
            startActivity(new Intent(this, SmartListActivity.class));
        }else if (type01.getK().getPageType()==9){
            startActivity(new Intent(this, LayoutManagerActivity.class));
        }else if (type01.getK().getPageType()==10){
            startActivity(new Intent(this, GroupStickListActivity.class));
        }
    }

    private List<MainType> getData() {
        List<MainBean> mainBeanList=new ArrayList<>();
        mainBeanList.add(new MainBean(0,"加头尾类型列表"));
        mainBeanList.add(new MainBean(1,"多类型列表"));
        mainBeanList.add(new MainBean(2,"嵌套类型列表"));
        mainBeanList.add(new MainBean(3,"测试数据操作列表"));
        mainBeanList.add(new MainBean(4,"商品多类型作列表"));
        mainBeanList.add(new MainBean(5,"嵌套数据多类型列表"));
        mainBeanList.add(new MainBean(6,"拖动操作列表"));
        mainBeanList.add(new MainBean(7,"动画列表列表"));
        mainBeanList.add(new MainBean(8,"上下拉刷新列表列表"));
        mainBeanList.add(new MainBean(9,"选择不同布局列表"));
        mainBeanList.add(new MainBean(10,"吸顶布局列表"));
        return  new TypeUitl<MainBean,MainType>().convert(mainBeanList,MainType.class);
    }


}
