package com.yanyuanquan.android.yyqdyb.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yanyuanquan.android.yyqdyb.R;
import com.yanyuanquan.android.yyqdyb.base.AutoBaseAdapter;
import com.yanyuanquan.android.yyqdyb.base.AutoViewHolder;
import com.yanyuanquan.android.yyqdyb.entity.JokeWithImg;

import java.util.List;

/**
 * @Created by apple on 15/12/25.
 * @description:
 * @projectName:YYQDYB
 */
public class JokeWithImageAdapter extends AutoBaseAdapter<JokeWithImg.ShowapiResBodyEntity.ContentlistEntity> {
    private Context context;
    public JokeWithImageAdapter(List<JokeWithImg.ShowapiResBodyEntity.ContentlistEntity> mList, int layoutId, Context context) {
        super(mList, layoutId);
        this.context =context;
    }

    @Override
    protected void setView(JokeWithImg.ShowapiResBodyEntity.ContentlistEntity entity, AutoViewHolder holder) {
        ((TextView) holder.getView(R.id.joke_text)).setText(entity.getTitle());
        ImageView imageView = holder.getView(R.id.joke_img);
        Picasso.with(context).load(entity.getImg()).into(imageView);
    }
}
