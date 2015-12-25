package com.yanyuanquan.android.yyqdyb.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.yanyuanquan.android.yyqdyb.widget.onLoadMoreLinstener;

/**
 * @Created by apple on 15/12/24.
 * @description:
 * @projectName:YYQDYB
 */
public class AutoRecyclerView extends RecyclerView{
    public AutoRecyclerView(Context context) {
        super(context);
        init();
    }

    public AutoRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public AutoRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private boolean isSlidingToLast=false;
    private void init() {
        this.setOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                LinearLayoutManager manager = (LinearLayoutManager) getLayoutManager();
                if (newState ==RecyclerView.SCROLL_STATE_IDLE&&linstener!=null){
                    int lastVisiableItem = manager.findLastCompletelyVisibleItemPosition();
                    int totleItem = manager.getItemCount();
                    if (lastVisiableItem ==totleItem-1&&isSlidingToLast){
                        linstener.loadMore();
                    }
                }


            }
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy>0){
                    isSlidingToLast = true;
                }else{
                    isSlidingToLast=false;
                }
            }
        });
    }
    private onLoadMoreLinstener linstener;

    public void setOnLoadMoreLinstener(onLoadMoreLinstener linstener){
        this.linstener =linstener;
    }

}
