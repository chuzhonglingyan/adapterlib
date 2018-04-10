package com.yuntian.adapterlib.helper;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author guangleilei
 * @version 1.0 2018-04-04
 */
public class RecyclerViewForEmpty  extends RecyclerView {


    private View emptyView;
    private AdapterDataObserver observer = new AdapterDataObserver() {
        @Override
        public void onChanged() {//设置空view原理都一样，没有数据显示空view，有数据隐藏空view
            Adapter adapter = getAdapter();
            if (adapter.getItemCount() == 0) {
                emptyView.setVisibility(VISIBLE);
                RecyclerViewForEmpty.this.setVisibility(GONE);
            } else {
                emptyView.setVisibility(GONE);
                RecyclerViewForEmpty.this.setVisibility(VISIBLE);
            }
        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount) {
            onChanged();
        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount, Object payload) {
            onChanged();
        }

        @Override
        public void onItemRangeInserted(int positionStart, int itemCount) {
            onChanged();
        }

        @Override
        public void onItemRangeRemoved(int positionStart, int itemCount) {
            onChanged();
        }

        @Override
        public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
            onChanged();
        }
    };

    public RecyclerViewForEmpty(Context context) {
        super(context);
    }

    public RecyclerViewForEmpty(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setEmptyView(View view) {
        this.emptyView = view;
        ((ViewGroup) this.getRootView()).addView(view);
    }

    @Override
    public void setAdapter(Adapter adapter) {
        super.setAdapter(adapter);
        adapter.registerAdapterDataObserver(observer);
        observer.onChanged();
    }


}
