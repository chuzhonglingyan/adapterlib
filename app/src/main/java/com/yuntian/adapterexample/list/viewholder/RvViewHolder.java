package com.yuntian.adapterexample.list.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.yuntian.adapterexample.R;
import com.yuntian.adapterexample.list.typemode.RvType;
import com.yuntian.adapterlib.base.BaseRvAdapter;
import com.yuntian.adapterlib.base.BaseViewHolder;
import com.yuntian.adapterlib.util.RecyclerViewUtil;

/**
 * @author guangleilei
 * @version 1.0 2018-03-22
 */
public class RvViewHolder extends BaseViewHolder<RvType> {


    private BaseRvAdapter baseRvAdapter;

    public RvViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        RecyclerView rv=getView(R.id.rv);
        baseRvAdapter=new BaseRvAdapter(){};
        RecyclerViewUtil.initRecyclerViewH(context,rv,true,baseRvAdapter);
    }

    @Override
    public void onBindViewData(RvType item, int position) {
        baseRvAdapter.setData(item.getList());
    }
}
