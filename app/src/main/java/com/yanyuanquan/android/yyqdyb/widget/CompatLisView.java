package com.yanyuanquan.android.yyqdyb.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.yanyuanquan.android.yyqdyb.R;

/**
 * @Created by apple on 15/12/25.
 * @description:
 * @projectName:YYQDYB
 */
public class CompatLisView extends ListView implements AbsListView.OnScrollListener{
    private TextView loadingText;
    private ProgressBar loadingPBar;
    private int scrollState;
    private boolean isLoading;
    private View footer;

    public CompatLisView(Context context) {
        super(context);
        init();
    }
    public CompatLisView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public CompatLisView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        footer = LayoutInflater.from(getContext()).inflate(R.layout.compat_listview_footer,null);
        loadingText = (TextView) footer.findViewById(R.id.loading_text);
        loadingPBar = (ProgressBar) footer.findViewById(R.id.loading_progress);
        this.addFooterView(footer);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        this.scrollState = scrollState;
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        Log.i("zjw","last"+view.getLastVisiblePosition()+"count"+totalItemCount);
        if (listener ==null|| isLoading)
            return;
        if (scrollState==OnScrollListener.SCROLL_STATE_IDLE
                &&view.getLastVisiblePosition()==totalItemCount-1
                && !isLoading)
        {
            footer.setVisibility(View.VISIBLE);
            listener.loadMore();
        }
    }
    private onLoadMoreListener listener;
    public void setOnLoadMoreListener(onLoadMoreListener listener){
        this.listener = listener;
    }
    public void onLoadComplete(){
        isLoading =false;
        footer.setVisibility(View.GONE);
    }
}
