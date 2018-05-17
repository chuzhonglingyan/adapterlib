package com.yuntian.adapterlib.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * description  .
 * Created by ChuYingYan on 2018/4/7.
 */
public class ViewHolderExecuter {


    private BaseRvAdapter baseRvAdapter;
    private RecyclerView recyclerView;


    public ViewHolderExecuter(BaseRvAdapter baseRvAdapter) {
        this.baseRvAdapter = baseRvAdapter;
        recyclerView = this.baseRvAdapter.getAttchReclyView();
    }

    /**
     * 获取可见范围内所有的View的ViewHolder
     * @return
     */
    public List<BaseViewHolder> getAllViewHolder() {
        List<BaseViewHolder> baseViewHolders = new ArrayList<>();
        for (int i = 0; i < recyclerView.getChildCount(); i++) {
            View view = recyclerView.getChildAt(i);
            RecyclerView.ViewHolder viewHolder = recyclerView.getChildViewHolder(view);
            baseViewHolders.add((BaseViewHolder) viewHolder);
        }
        return baseViewHolders;
    }

    public BaseViewHolder getHolderAtPosition(int position) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (position>recyclerView.getChildCount()){
            return null;
        }
        for (int i = 0; i < recyclerView.getChildCount(); i++) {
            if (i == position) {
                View view = layoutManager.getChildAt(i);
                return (BaseViewHolder) recyclerView.getChildViewHolder(view);
            }
        }
        return null;
    }



    public void executeViewHolderonAttach() {
        List<BaseViewHolder> baseViewHolderList = getAllViewHolder();
        for (BaseViewHolder baseViewHolder : baseViewHolderList) {
            baseViewHolder.onAttach(baseRvAdapter);
        }
    }


    public void executeViewHolderonStop() {
        List<BaseViewHolder> baseViewHolderList = getAllViewHolder();
        for (BaseViewHolder baseViewHolder : baseViewHolderList) {
            baseViewHolder.onStop();
        }
    }


    public void executeViewHolderResume() {
        List<BaseViewHolder> baseViewHolderList = getAllViewHolder();
        for (BaseViewHolder baseViewHolder : baseViewHolderList) {
            baseViewHolder.onResume();
        }
    }

    public void executeViewHolderResume(int position) {
        getHolderAtPosition(position).onResume();
    }


    public void executetViewHolderDetory() {
        List<BaseViewHolder> baseViewHolderList = getAllViewHolder();
        for (BaseViewHolder baseViewHolder : baseViewHolderList) {
            baseViewHolder.onDestory();
        }
    }

    public void executeViewHolderDetory(int position) {
        getHolderAtPosition(position).onDestory();
    }

}
