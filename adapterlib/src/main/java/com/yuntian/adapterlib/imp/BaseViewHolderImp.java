package com.yuntian.adapterlib.imp;

import android.view.View;

import com.yuntian.adapterlib.base.BaseViewHolder;

/**
 * @author guangleilei
 * @version 1.0 2018-03-22
 */
public abstract class BaseViewHolderImp<K> extends BaseViewHolder<TypeInterfaceImp<K>> {


    public BaseViewHolderImp(View itemView) {
        super(itemView);
    }


    @Override
    public void onBindViewData(TypeInterfaceImp<K> item, int position) {
        onBindViewBeanData(item.getK(), position);
    }

    public abstract void onBindViewBeanData(K item, int position);

}
