package com.yuntian.adapterexample.util;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

/**
 * description  .
 * Created by ChuYingYan on 2018/4/9.
 */
public class StickyItemDecoration extends RecyclerView.ItemDecoration {


    private int mHeight = 4; //分割线高度


    private static final String TAG = "StickyItemDecoration";

    private Paint mPaint;

    public StickyItemDecoration(int mHeight) {
        this.mHeight = mHeight;
        mPaint = new Paint();
        mPaint.setColor(Color.YELLOW);
    }

    /**
     * 绘制内容在item之下,在绘制Item之前调用 （如果没有通过getItemOffsets设置偏移的话，Item的内容会将其覆盖）
     *
     * @param c
     * @param parent
     * @param state
     */
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        c.save();
        for (int i = 0; i < parent.getChildCount(); i++) {
            View view = parent.getChildAt(i);
            //View的Height值 = view.getBottom() - view.getTop();
            //View的Width值 = view.getRight() - view.getLeft();
            final int bottom = view.getBottom();
            final int top = bottom - mHeight;
            c.drawRect(parent.getLeft(), top, parent.getRight(), bottom, mPaint);//为每个item绘制矩形
        }
        c.restore();
    }


    /**
     * 绘制内容在item之上 (画的内容会覆盖在item的上层)
     *
     * @param c
     * @param parent
     * @param state
     */
    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }


    /*
     *  outRect.set(left, top, right, bottom);
     *  在Item的四周设定距离
     *  所以当Orientation为垂直时，我们只需要在每个Item的下方预留出分割线的高度就可以了
     *  同理当Orientation为水平时，我们只需要在每个Item的右方预留出分割线的宽度就可以了
     *  但通常我们使用分割线的style都是统一的，这样我们在attrs中只需要定义一个即可，即共同使用Height
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildAdapterPosition(view);
        Log.d(TAG, "position" + position);
        //第一个item预留空间
        outRect.bottom = mHeight;
    }


}
