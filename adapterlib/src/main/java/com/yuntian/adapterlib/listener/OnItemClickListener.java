package com.yuntian.adapterlib.listener;

import android.view.View;

/**
 * @author guangleilei
 * @version 1.0 2018-03-27
 */
@Deprecated
public interface OnItemClickListener<T> {

    void onItemClick(View view, T item, int truePos, int relativePos);


}
