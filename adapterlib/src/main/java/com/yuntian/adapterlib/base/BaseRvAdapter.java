package com.yuntian.adapterlib.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yuntian.adapterlib.imp.FootType;
import com.yuntian.adapterlib.imp.HeadType;
import com.yuntian.adapterlib.listener.OnItemClickListener;
import com.yuntian.adapterlib.listener.OnItemDataClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guangleilei
 * @version 1.0 2018-03-22
 */
public abstract class BaseRvAdapter<T extends TypeInterface> extends RecyclerView.Adapter implements DataInterface<T> {


    private static final String TAG = "BaseRvAdapter";

    protected List<T> totalData = new ArrayList<>();  //总数据集合

    protected List<T> headData = new ArrayList<>(); //头部数据集合


    protected List<T> footData = new ArrayList<>(); //尾部数据集合

    //protected List<T> data = new ArrayList<>(); //数据集合


    protected Context mContext;

    private int tempPosition;

    private boolean isHeadStilled = true;
    private boolean isFootStilled = true;

    private RecyclerView recyclerView;

    private ViewHolderExecuter viewHolderExecuter;


    private OnItemClickListener onItemClickListener;
    private OnItemDataClickListener onItemDataClickListener;

    public BaseRvAdapter() {
        tempPosition = 0;
    }

    public BaseRvAdapter(List<T> list) {
        tempPosition = 0;
        if (list != null) {
            totalData.addAll(list);
        }
    }

    //viewtype的值决定绘制某个布局 优先于onCreateViewHolder()调用
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            recyclerView = (RecyclerView) parent;
            mContext = parent.getContext();
            viewHolderExecuter=new ViewHolderExecuter(this);
        }
        BaseViewHolder viewHolder = getViewHolderByViewType(parent, viewType);
        Log.d(TAG, "onCreateViewHolder:tempPosition=" + tempPosition + ",viewType=" + viewType);
        return viewHolder;
    }

    protected BaseViewHolder getViewHolderByViewType(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        BaseViewHolder baseViewHolder = ViewHolderManager.getViewHolder(viewType, itemView);
        createOnItemClickListener(itemView, baseViewHolder);
        return baseViewHolder;
    }


    protected void createOnItemClickListener(final View itemView, final RecyclerView.ViewHolder holder) {
        //notify 后 adapter当前位置 layout是16ms之前的位置，adapter和layout的位置会有时间差(<16ms),
        if (itemView != null && holder != null) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int adapterPosition = holder.getAdapterPosition();
                    if (onItemClickListener != null && adapterPosition >= 0) {
                        onItemClickListener.onItemClick(itemView, totalData.get(adapterPosition), adapterPosition, getRelativePos(adapterPosition));
                    }
                    if (onItemDataClickListener != null && adapterPosition >= 0) {
                        if (adapterPosition < headData.size()) {
                            onItemDataClickListener.onHeadItemClick(itemView, totalData.get(adapterPosition), adapterPosition, getRelativePos(adapterPosition));
                        } else if (adapterPosition > totalData.size() - footData.size() - 1) {
                            onItemDataClickListener.onFootItemClick(itemView, totalData.get(adapterPosition), adapterPosition, getRelativePos(adapterPosition));
                        } else {
                            onItemDataClickListener.onItemClick(itemView, totalData.get(adapterPosition), adapterPosition, getRelativePos(adapterPosition));
                        }
                    }
                }
            });
        }
    }


    public RecyclerView getAttchReclyView() {
        return recyclerView;
    }


    public ViewHolderExecuter getViewHolderExecuter() {
        return viewHolderExecuter;
    }


    public void setOnItemDataClickListener(OnItemDataClickListener onItemDataClickListener) {
        this.onItemDataClickListener = onItemDataClickListener;
    }

    public int getRelativePos(int adapterPosition) {
        return adapterPosition - headData.size();
    }

    @Override
    public List<T> getData() {
        List<T> tepData = new ArrayList<>(totalData);
        tepData.removeAll(headData);
        tepData.removeAll(footData);
        return tepData;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder:tempPosition=" + position + ",holder=" + holder.toString());
        ((BaseViewHolder) holder).onBindViewData(totalData.get(position), position);

    }

    @Override
    public int getItemCount() {
        return totalData.size();
    }

    @Override
    public int getItemViewType(int position) {
        this.tempPosition = position;
        return totalData.get(position).getViewType();
    }


    public List<T> getHeadData() {
        return headData;
    }


    /**
     * 重置头布局
     *
     * @param headList
     */
    public void setHeadData(List<T> headList) {
        if (headList != null) {
            totalData.removeAll(headData);

            headData.clear();
            headData.addAll(headList);
            totalData.addAll(0, headData);
            notifyItemRangeChanged(0, headList.size());
        }
    }

    /**
     * 移除头布局
     */
    public void removeAllHead() {
        int size = headData.size();
        totalData.removeAll(headData);
        headData.clear();
        notifyItemRangeRemoved(0, size);
        notifyItemRangeChanged(0, size);
    }


    /**
     * 添加头布局
     *
     * @param head
     */
    public void addHead(T head) {
        if (head != null && isHeadType(head)) {

            int pos = headData.size();
            headData.add(head);

            totalData.add(pos, head);
            notifyItemInserted(pos);
        }
    }

    /**
     * 添加头布局
     *
     * @param head
     */
    public void addHead(T head, int index) {
        if (head != null && isHeadType(head)) {
            int trueIndex = Math.min(index, headData.size());
            headData.add(trueIndex, head);
            totalData.add(trueIndex, head);
            notifyItemInserted(trueIndex);
        }
    }

    private boolean isHeadType(T head) {
        return head instanceof HeadType;
    }

    private boolean isFootType(T foot) {
        return foot instanceof FootType;
    }


    /**
     * 添加尾部布局
     *
     * @param foot
     */
    public void addFoot(T foot) {
        if (foot != null && isFootType(foot)) {
            int pos = totalData.size();

            footData.add(foot);
            totalData.add(foot);
            notifyItemInserted(pos);
        }
    }

    /**
     * 添加尾部布局
     *
     * @param foot
     */
    public void addFoot(T foot, int footIndex) {
        if (foot != null && isFootType(foot)) {
            int truePos = Math.min(footIndex, footData.size());
            int pos = totalData.size() - footData.size() + footIndex;

            footData.add(truePos, foot);
            totalData.add(pos, foot);
            notifyItemInserted(pos);
        }
    }


    /**
     * 重置尾布局
     */
    public void setFootData(List<T> footList) {
        if (footList != null) {
            totalData.removeAll(footData);

            int pos = totalData.size();
            footData.clear();
            footData.addAll(footList);
            totalData.addAll(footList);

            notifyItemRangeChanged(pos, footList.size());
        }
    }


    /**
     * 移除尾布局
     */
    public void removeFootData() {
        int size = totalData.size();
        int pos = totalData.size() - footData.size();
        totalData.removeAll(footData);
        footData.clear();
        notifyItemRangeRemoved(pos, size);
        notifyItemRangeChanged(pos, size);
    }


    public void setData(List<T> list) {
        if (list != null) {
            List<T> orginData = new ArrayList<>(totalData);
            orginData.remove(headData);
            totalData.removeAll(orginData);

            int pos = headData.size();
            totalData.addAll(pos, list);
            notifyDataSetChanged();
        }
    }


    public List<T> getAllData() {
        return totalData;
    }


    @Override
    public void add(T item) {
        if (item != null) {
            int pos = totalData.size();

            totalData.add(item);
            notifyItemInserted(pos);
        }
    }

    public void add(T item, int index) {
        if (item != null) {
            int trueIndex = Math.min(index, getData().size());
            int pos = headData.size() + trueIndex;

            totalData.add(pos, item);
            notifyItemInserted(pos);
        }
    }

    public void adds(List<T> items, int startindex) {
        if (items != null) {
            int trueStartIndex = Math.min(startindex, getData().size());

            int pos = headData.size() + trueStartIndex;
            totalData.addAll(pos, items);
            notifyItemRangeInserted(pos, items.size());
        }
    }

    @Override
    public void adds(List<T> items) {
        if (items != null) {
            int pos = totalData.size();

            totalData.addAll(items);
            notifyItemRangeInserted(pos, items.size());
        }
    }


    public boolean isFootStilled() {
        return isFootStilled;
    }

    public void setFootStilled(boolean footStilled) {
        isFootStilled = footStilled;
    }

    public void setHeadStilled(boolean headStilled) {
        isHeadStilled = headStilled;
    }

    @Override
    public void remove(int position) {
        if (verifyPosition(position)) {
            return;
        }
        totalData.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, totalData.size() - position);
    }

    @Override
    public void removes(int startPosition, int endPosition) {
        if (verifyPosition(startPosition) || verifyPosition(endPosition)) {
            return;
        }
        List<T> templist = new ArrayList<>();
        for (int i = startPosition; i <= endPosition; i++) {
            templist.add(totalData.get(i));
        }
        totalData.removeAll(templist);
        notifyItemRangeRemoved(startPosition, templist.size());
        notifyItemRangeChanged(startPosition, templist.size());
    }


    public void removeAt(int relativePos) {
        int position = relativePos + headData.size();
        remove(position);
    }


    public void removesAt(int relativePos, int count) {
        int startPosition = Math.min(relativePos + headData.size(), totalData.size() - footData.size());
        int endPosition = Math.min(startPosition + count, totalData.size() - footData.size()) - 1;
        removes(startPosition, endPosition);
    }


    @Override
    public void update(int position, T item) {
        if (position >= 0 && position < totalData.size()) { //mDatas为数据集合
            totalData.set(position, item);
            notifyItemChanged(position);
        }
    }


    public void updates(int startPosition, List<T> rangeData) {
        for (int i = 0; i < rangeData.size(); i++) {
            totalData.set(startPosition + i, rangeData.get(i));
        }
        if (startPosition >= 0 && startPosition < totalData.size()) {
            notifyItemRangeChanged(startPosition, rangeData.size());
        }
    }


    public void updateAt(int relativePos, T item) {
        int position = relativePos + headData.size();
        if (verifyPosition(position)) {
            return;
        }
        update(position, item);
    }


    public boolean verifyPosition(int position) {
        if (position < 0 || position >= totalData.size()) {
            return false;
        }
        if (isHeadStilled) {
            if (position < headData.size()) {
                return true;
            }
        }
        if (isFootStilled) {
            int footpos = totalData.size() - footData.size();
            if (position >= footpos) {
                return true;
            }
        }
        return false;
    }


}
