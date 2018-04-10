package com.yuntian.adapterlib.base;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/**
 * @author guangleilei
 * @version 1.0 2018-03-22
 */
public abstract class BaseViewHolder<D> extends RecyclerView.ViewHolder implements IViewHolder {

    protected IView iView;
    protected Context context;


    private SparseArray<View> viewSparseArray = new SparseArray<>();


    public BaseViewHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
        iView = getIView(itemView);
        onCreate();
    }


    public IView getIView(View itemView) {
        if (itemView.getContext() instanceof IView) {
            return (IView) itemView.getContext();
        }
        return  null;
    }

    public <T extends View> T getView(@IdRes int viewId) {
        View view = viewSparseArray.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            if (view != null) {
                viewSparseArray.put(viewId, view);
            }
        }
        return (T) view;
    }

    /**
     * 更新数据方法
     * @param item
     * @param position
     */
    public abstract void onBindViewData(D item, int position);


    @Override
    public void onCreate() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestory() {

    }

}
