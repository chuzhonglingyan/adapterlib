package com.yuntian.adapterlib.util;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.yuntian.adapterlib.divider.DividerGridItemDecoration;
import com.yuntian.adapterlib.divider.DividerItemDecoration;


/**
 * 视图帮助类
 */
public class RecyclerViewUtil {

    private RecyclerViewUtil() {
        throw new RuntimeException("RecyclerViewHelper cannot be initialized!");
    }

    /**
     * 配置垂直列表RecyclerView
     *
     * @param view
     */
    public static void initRecyclerViewV(Context context, RecyclerView view, RecyclerView.ItemDecoration dividerItemDecoration,
                                         RecyclerView.Adapter adapter) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        view.setHasFixedSize(true);// setHasFixedSize()方法用来使RecyclerView保持固定的大小，该信息被用于自身的优化。
        view.setLayoutManager(layoutManager);
        for (int i = 0; i < view.getItemDecorationCount(); i++) {
            view.removeItemDecorationAt(i);
        }
        view.setItemAnimator(new DefaultItemAnimator());
        if (dividerItemDecoration!=null) {
            view.addItemDecoration(dividerItemDecoration);
        }
        view.setAdapter(adapter);
    }


    /**
     * 配置垂直列表RecyclerView
     *
     * @param view
     */
    public static void initRecyclerViewV(Context context, RecyclerView view, boolean isDivided,
                                         RecyclerView.Adapter adapter) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        view.setHasFixedSize(true);// setHasFixedSize()方法用来使RecyclerView保持固定的大小，该信息被用于自身的优化。
        view.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(context, DividerItemDecoration.VERTICAL);

        for (int i = 0; i < view.getItemDecorationCount(); i++) {
            view.removeItemDecorationAt(i);
        }

        view.setItemAnimator(new DefaultItemAnimator());
        if (isDivided) {
            view.addItemDecoration(dividerItemDecoration);
        }
        view.setAdapter(adapter);
    }

    public static void initRecyclerViewV(Context context, RecyclerView view, RecyclerView.Adapter adapter) {
        initRecyclerViewV(context, view, false, adapter);
    }


    /**
     * 配置水平列表RecyclerView
     *
     * @param view
     */
    public static void initRecyclerViewH(Context context, RecyclerView view, boolean isDivided,
                                         RecyclerView.Adapter adapter) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        view.setLayoutManager(layoutManager);
        view.setItemAnimator(new DefaultItemAnimator());

        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL);

        for (int i = 0; i < view.getItemDecorationCount(); i++) {
            view.removeItemDecorationAt(i);
        }

        if (isDivided) {
            view.addItemDecoration(dividerItemDecoration);
        }
        view.setAdapter(adapter);
    }

    public static void initRecyclerViewH(Context context, RecyclerView view, RecyclerView.Adapter adapter) {
        initRecyclerViewH(context, view, false, adapter);
    }

    /**
     * 配置网格列表RecyclerView
     *
     * @param view
     */
    public static void initRecyclerViewG(Context context, RecyclerView view, boolean isDivided,
                                         RecyclerView.Adapter adapter, int column) {
        GridLayoutManager layoutManager = new GridLayoutManager(context, column, LinearLayoutManager.VERTICAL, false);
        view.setLayoutManager(layoutManager);
        view.setItemAnimator(new DefaultItemAnimator());

        DividerGridItemDecoration dividerItemDecoration=new DividerGridItemDecoration(context);

        for (int i = 0; i < view.getItemDecorationCount(); i++) {
            view.removeItemDecorationAt(i);
        }

        if (isDivided) {
            view.addItemDecoration(dividerItemDecoration);
        }
        view.setAdapter(adapter);
    }

    public static void initRecyclerViewG(Context context, RecyclerView view, RecyclerView.Adapter adapter, int column) {
        initRecyclerViewG(context, view, false, adapter, column);
    }


    /**
     * 配置瀑布流列表RecyclerView
     *
     * @param view
     */
    public static void initRecyclerViewSV(Context context, RecyclerView view, boolean isDivided,
                                          RecyclerView.Adapter adapter, int column) {
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(column, StaggeredGridLayoutManager.VERTICAL);
        view.setLayoutManager(layoutManager);
        view.setItemAnimator(new DefaultItemAnimator());

        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(context, DividerItemDecoration.VERTICAL);

        for (int i = 0; i < view.getItemDecorationCount(); i++) {
            view.removeItemDecorationAt(i);
        }

        if (isDivided) {
            view.addItemDecoration(dividerItemDecoration);
        }
        view.setAdapter(adapter);
    }

    public static void initRecyclerViewSV(Context context, RecyclerView view, RecyclerView.Adapter adapter, int column) {
        initRecyclerViewSV(context, view, false, adapter, column);
    }


}
