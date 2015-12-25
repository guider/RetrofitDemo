package com.yanyuanquan.android.yyqdyb.adapter;

import android.widget.TextView;

import com.yanyuanquan.android.yyqdyb.R;
import com.yanyuanquan.android.yyqdyb.base.BaseRecyclerViewAdapter;
import com.yanyuanquan.android.yyqdyb.base.RViewHoler;
import com.yanyuanquan.android.yyqdyb.entity.Joke;

import java.util.List;

/**
 * @Created by apple on 15/12/24.
 * @description:
 * @projectName:YYQDYB
 */
public class JokeAdapter extends BaseRecyclerViewAdapter<Joke.ShowapiResBodyEntity.ContentlistEntity> {

    public JokeAdapter(List<Joke.ShowapiResBodyEntity.ContentlistEntity> mList, int layoutId) {
        super(mList, layoutId);
    }

    @Override
    public void setView(RViewHoler holer, Joke.ShowapiResBodyEntity.ContentlistEntity entity) {
        ((TextView) holer.getView(R.id.title)).setText(entity.getTitle());
        ((TextView) holer.getView(R.id.content)).setText(entity.getText());
    }
}
