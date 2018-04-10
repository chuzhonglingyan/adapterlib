package com.yuntian.adapterlib.helper;

import com.yuntian.adapterlib.base.BaseRvAdapter;

import java.util.Collections;
import java.util.List;

/**
 * description  .
 * Created by ChuYingYan on 2018/4/7.
 */
public class TouchAdapter extends BaseRvAdapter implements ItemTouchHelperAdapter {


    public TouchAdapter(List list) {
        super(list);
    }


    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        if (verifyPosition(fromPosition)||verifyPosition(toPosition)){
            return false;
        }
        //交换位置
        Collections.swap(totalData,fromPosition,toPosition);
        notifyItemMoved(fromPosition,toPosition);
        return true;
    }

    @Override
    public void onItemDismiss(int position) {
        //移除数据
        remove(position);
    }
}
