package com.yuntian.adapterlib.util;

import android.support.v7.util.DiffUtil;

import java.util.List;

/**
 * DifUtil 就是这次引入的工具类，它会找出 Adapter 中每一个 Item 对应发生的变化，然后对每一个变化给予对应的刷新
 * @author guangleilei
 * @version 1.0 2018-03-27
 */
public class RecyDiffUtil<T> extends DiffUtil.Callback{

    private List<T> newList;
    private List<T> oldList;

    public RecyDiffUtil(List<T> oldList, List<T> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    /**
     * 该方法用于判断两个 Object 是否是相同的 Item，比如有唯一标识的时候应该比较唯一标识是否相等
     */
    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).getClass().equals(newList.get(newItemPosition).getClass());
    }

    /**
     * 当 areItemsTheSame 返回 true 时调用该方法，返回显示的 Item 的内容是否一致,看属性需求而定
     */
    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        T oldObj = oldList.get(oldItemPosition);
        T newObj = newList.get(newItemPosition);
        return oldObj.equals(newObj);
    }

}
