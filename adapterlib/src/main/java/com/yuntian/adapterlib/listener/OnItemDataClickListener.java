package com.yuntian.adapterlib.listener;

import android.view.View;

/**
 * @author guangleilei
 * @version 1.0 2018-03-27
 */
public interface OnItemDataClickListener<T> {

    void onHeadItemClick(View view, T item, int truePos, int relativePos);

    void onFootItemClick(View view, T item, int truePos, int relativePos);

    void onItemClick(View view, T item, int truePos, int relativePos);
}
