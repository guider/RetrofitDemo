package com.yanyuanquan.android.yyqdyb.base;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * @Created by apple on 15/12/25.
 * @description:
 * @projectName:YYQDYB
 */
public abstract class AutoBaseAdapter<T> extends BaseAdapter{
    protected List<T> mList;
    protected int layoutId;

    public void setData(List<T> list){
        this.mList = list;
        notifyDataSetChanged();
    }

    public AutoBaseAdapter(List<T> mList, int layoutId) {
        this.mList = mList;
        this.layoutId = layoutId;
    }

    @Override
    public int getCount() {
        return mList==null?0:mList.size();
    }

    @Override
    public T getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AutoViewHolder holder = AutoViewHolder.getInstance(parent,convertView,layoutId);
        setView(mList.get(position),holder);
        return holder.getConvertView();
    }
    protected abstract void setView(T t, AutoViewHolder holder);
}
