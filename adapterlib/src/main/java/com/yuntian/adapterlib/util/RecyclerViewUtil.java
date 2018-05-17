package com.yuntian.adapterlib.util;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.yuntian.adapterlib.divider.GridDividerItemDecoration;
import com.yuntian.adapterlib.divider.LinearDecoration;


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
    public static void initRecyclerViewV(RecyclerView view, RecyclerView.Adapter adapter) {
        initRecyclerViewV(view,adapter,false);
    }

    /**
     * 配置垂直列表RecyclerView
     *
     * @param view
     */
    public static void initRecyclerViewV(RecyclerView view, RecyclerView.Adapter adapter,boolean isDivider) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        view.setHasFixedSize(true);// setHasFixedSize()方法用来使RecyclerView保持固定的大小，该信息被用于自身的优化。
        view.setLayoutManager(layoutManager);
        view.setItemAnimator(new DefaultItemAnimator());

        for (int i = 0; i < view.getItemDecorationCount(); i++) {
            view.removeItemDecorationAt(i);
        }
        LinearDecoration dividerItemDecoration=new LinearDecoration(view.getContext(), LinearLayoutManager.VERTICAL);
        if (isDivider) {
            view.addItemDecoration(dividerItemDecoration);
        }
        view.setAdapter(adapter);
    }



    /**
     * 配置垂直列表RecyclerView
     *
     * @param view
     */
    public static void initRecyclerViewV(RecyclerView view, RecyclerView.Adapter adapter, RecyclerView.ItemDecoration dividerItemDecoration) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
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
    public static void initRecyclerViewH(RecyclerView view, RecyclerView.Adapter adapter) {
        initRecyclerViewH(view,adapter,false);
    }

    /**
     * 配置垂直列表RecyclerView
     *
     * @param view
     */
    public static void initRecyclerViewH(RecyclerView view, RecyclerView.Adapter adapter,boolean isDivider) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        view.setHasFixedSize(true);// setHasFixedSize()方法用来使RecyclerView保持固定的大小，该信息被用于自身的优化。
        view.setLayoutManager(layoutManager);
        view.setItemAnimator(new DefaultItemAnimator());

        for (int i = 0; i < view.getItemDecorationCount(); i++) {
            view.removeItemDecorationAt(i);
        }
        LinearDecoration dividerItemDecoration=new LinearDecoration(view.getContext(),  LinearLayoutManager.HORIZONTAL);
        if (isDivider) {
            view.addItemDecoration(dividerItemDecoration);
        }
        view.setAdapter(adapter);
    }



    /**
     * 配置垂直列表RecyclerView
     *
     * @param view
     */
    public static void initRecyclerViewH(RecyclerView view, RecyclerView.Adapter adapter, RecyclerView.ItemDecoration dividerItemDecoration) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
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


    public static void initRecyclerViewG(RecyclerView view, RecyclerView.Adapter adapter, int column) {
        initRecyclerViewG(view,  adapter, column,false);
    }

    /**
     * 配置网格列表RecyclerView
     *
     * @param view
     */
    public static void initRecyclerViewG( RecyclerView view, RecyclerView.Adapter adapter, int column,boolean isDivided) {
        GridLayoutManager layoutManager = new GridLayoutManager(view.getContext(), column, LinearLayoutManager.VERTICAL, false);
        view.setLayoutManager(layoutManager);
        view.setItemAnimator(new DefaultItemAnimator());

        GridDividerItemDecoration dividerItemDecoration=new GridDividerItemDecoration(view.getContext());

        for (int i = 0; i < view.getItemDecorationCount(); i++) {
            view.removeItemDecorationAt(i);
        }

        if (isDivided) {
            view.addItemDecoration(dividerItemDecoration);
        }
        view.setAdapter(adapter);
    }


    /**
     * 配置网格列表RecyclerView
     *
     * @param view
     */
    public static void initRecyclerViewG( RecyclerView view, RecyclerView.Adapter adapter, int column,RecyclerView.ItemDecoration dividerItemDecoration) {
        GridLayoutManager layoutManager = new GridLayoutManager(view.getContext(), column, LinearLayoutManager.VERTICAL, false);
        view.setLayoutManager(layoutManager);
        view.setItemAnimator(new DefaultItemAnimator());

        for (int i = 0; i < view.getItemDecorationCount(); i++) {
            view.removeItemDecorationAt(i);
        }

        if (dividerItemDecoration!=null) {
            view.addItemDecoration(dividerItemDecoration);
        }
        view.setAdapter(adapter);
    }


    public static void initRecyclerViewSV(RecyclerView view, RecyclerView.Adapter adapter, int column) {
        initRecyclerViewSV(view, adapter, column,false);
    }




    /**
     * 配置瀑布流列表RecyclerView
     *
     * @param view
     */
    public static void initRecyclerViewSV(RecyclerView view, RecyclerView.Adapter adapter, int column,boolean isDivided) {
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(column, StaggeredGridLayoutManager.VERTICAL);
        view.setLayoutManager(layoutManager);
        view.setItemAnimator(new DefaultItemAnimator());

        LinearDecoration dividerItemDecoration=new LinearDecoration(view.getContext(), LinearLayoutManager.VERTICAL);

        for (int i = 0; i < view.getItemDecorationCount(); i++) {
            view.removeItemDecorationAt(i);
        }

        if (isDivided) {
            view.addItemDecoration(dividerItemDecoration);
        }
        view.setAdapter(adapter);
    }


    /**
     * 配置瀑布流列表RecyclerView
     *
     * @param view
     */
    public static void initRecyclerViewSV(RecyclerView view, RecyclerView.Adapter adapter, int column,RecyclerView.ItemDecoration dividerItemDecoration) {
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(column, StaggeredGridLayoutManager.VERTICAL);
        view.setLayoutManager(layoutManager);
        view.setItemAnimator(new DefaultItemAnimator());

        for (int i = 0; i < view.getItemDecorationCount(); i++) {
            view.removeItemDecorationAt(i);
        }
        if (dividerItemDecoration!=null) {
            view.addItemDecoration(dividerItemDecoration);
        }
        view.setAdapter(adapter);
    }


}
