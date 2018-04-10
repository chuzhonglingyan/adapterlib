package com.yuntian.adapterlib.base;

import java.util.HashMap;
import java.util.Map;

/**
 * description  .
 * Created by ChuYingYan on 2018/4/6.
 */
public class ModeViewHolder {


    //维持type和ViewHolder之间的关系
    private static Map<Integer, Class<? extends BaseViewHolder>> viewHolderClassByType = new HashMap<>();


    public static Map<Integer, Class<? extends BaseViewHolder>> getViewHolderClassByType() {
        return viewHolderClassByType;
    }

    private  int viewType;

    private Class<? extends BaseViewHolder> viewHolderClass;

    public ModeViewHolder(int viewType, Class<? extends BaseViewHolder> viewHolderClass) {
        this.viewType = viewType;
        this.viewHolderClass = viewHolderClass;
        viewHolderClassByType.put(viewType,viewHolderClass);
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public Class<? extends BaseViewHolder> getViewHolderClass() {
        return viewHolderClass;
    }

    public void setViewHolderClass(Class<? extends BaseViewHolder> viewHolderClass) {
        this.viewHolderClass = viewHolderClass;
    }
}
