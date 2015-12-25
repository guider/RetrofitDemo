package com.yanyuanquan.android.yyqdyb.base;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * @Created by apple on 15/12/24.
 * @description:
 * @projectName:YYQDYB
 */
public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<RViewHoler> {
    private List<T> mList;
    private int layoutId;

    public BaseRecyclerViewAdapter(List<T> mList, int layoutId) {
        this.mList = mList;
        this.layoutId = layoutId;
    }
    @Override
    public RViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutId,parent,false);
        RViewHoler viewHoler = new RViewHoler(view);
        return viewHoler;
    }
    @Override
    public void onBindViewHolder(RViewHoler holder, int position) {
        if (linstener!=null) {
            holder.getItemView().setOnClickListener(v->linstener.onItemClick(holder.getItemView(),holder.getLayoutPosition()));
            holder.getItemView().setOnLongClickListener(v->{linstener.onItemLongClick(holder.getItemView(),holder.getLayoutPosition());return true;});
        }
        setView(holder,mList.get(position));
    }
    @Override
    public int getItemCount() {
        return mList==null? 0:mList.size();
    }

    public abstract void setView(RViewHoler holer,T t);

    /**
     * 实现RecyclerView 点击事件，onItemClick, onItemLongClick；
     *
     * @deprecated by guider
     */
    private ItemClickLinstener linstener;
    public interface ItemClickLinstener{
        void onItemClick(View itemView,int layoutPosition);
        void onItemLongClick(View itemView,int layoutPosition);
    }
    public void setOnItemClickLinstener(ItemClickLinstener linstener){
        this.linstener =linstener;
    }


    public void appendDatas(List<T> list){
        if (mList==null)
            mList=list;
        else
            mList.addAll(list);
        notifyItemRangeChanged(mList.size()-list.size(),mList.size());
    }
/*
  notifyItemChanged(int position)，position数据发生了改变，那调用这个方法，
 就会回调对应position的onBindViewHolder()方法了，当然，因为ViewHolder是复用的，所以如果position在当前屏幕以外，
  也就不会回调了，因为没有意义，下次position滚动会当前屏幕以内的时候同样会调用onBindViewHolder()方法刷新数据了。其他的方法也是同样的道理。

 public final void notifyItemRangeChanged(int positionStart, int itemCount)，
 顾名思义，可以刷新从positionStart开始itemCount数量的item了（这里的刷新指回调onBindViewHolder()方法）。

 public final void notifyItemInserted(int position)，
 这个方法是在第position位置被插入了一条数据的时候可以使用这个方法刷新，注意这个方法调用后会有插入的动画，这个动画可以使用默认的，也可以自己定义。

 public final void notifyItemMoved(int fromPosition, int toPosition)，
 这个方法是从fromPosition移动到toPosition为止的时候可以使用这个方法刷新

 public final void notifyItemRangeInserted(int positionStart, int itemCount)，
 显然是批量添加。

 public final void notifyItemRemoved(int position)，
 第position个被删除的时候刷新，同样会有动画。

 public final void notifyItemRangeRemoved(int positionStart, int itemCount)，
 批量删除。
 */

}
