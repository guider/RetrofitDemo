package com.yanyuanquan.android.yyqdyb.ui;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.yanyuanquan.android.yyqdyb.App;
import com.yanyuanquan.android.yyqdyb.R;
import com.yanyuanquan.android.yyqdyb.base.AutoBaseAdapter;
import com.yanyuanquan.android.yyqdyb.base.AutoViewHolder;
import com.yanyuanquan.android.yyqdyb.base.HttpManager;
import com.yanyuanquan.android.yyqdyb.entity.MeiTuList;
import com.zhy.http.okhttp.callback.StringCallback;

/**
 * @Created by apple on 15/12/25.
 * @description:
 * @projectName:YYQDYB
 */
public class MeituItemFragment extends BaseListFragment<MeiTuList.TngouEntity> {
    @Override
    protected void init() {
        int id = getArguments().getInt("id");
        HttpManager.getMeiTuList(id, 1, new StringCallback() {
            @Override
            public void onResponse(String response) {
                MeiTuList meiTuList = new Gson().fromJson(response,MeiTuList.class);
                if (meiTuList!=null&&meiTuList.getTngou()!=null)
                    initView(R.layout.item_meitu_details,meiTuList);
            }
        });

    }
    protected void initView(int layoutId,MeiTuList  mList) {
        final String imgurl  = "http://tnfs.tngou.net/image";
        adapter = new AutoBaseAdapter<MeiTuList.TngouEntity>(mList.getTngou(),layoutId) {
            @Override
            protected void setView(MeiTuList.TngouEntity entity, AutoViewHolder holder) {
                ((TextView)holder.getView(R.id.title)).setText(entity.getTitle());
                ImageView imageView = holder.getView(R.id.img);
                ImageLoader.getInstance().displayImage(imgurl+entity.getImg()+"_500x500",imageView, App.creatDefaultDisplayBuilder());
            }
        };
        setListAdapter(adapter);
    }
}
