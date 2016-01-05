package com.yanyuanquan.android.yyqdyb.ui;

import android.os.Handler;
import android.os.Message;

import com.yanyuanquan.android.yyqdyb.R;
import com.yanyuanquan.android.yyqdyb.base.BaseFragment;
import com.yanyuanquan.android.yyqdyb.widget.TaiJi;

import butterknife.Bind;

/**
 * @Created by apple on 15/12/24.
 * @description:
 * @projectName:YYQDYB
 */
public class NewsFragment extends BaseFragment {
    @Bind(R.id.taiji)
    TaiJi taiji;


    @Override
    protected int initLayout() {
        return R.layout.fragment_taiji;
    }
    float drgree = 0;
    @Override
    protected void init() {

        setview();
    }

    private void setview() {

        final Handler handler = new Handler() {
            private float degrees = 0;

            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                taiji.setDegree(degrees += 2);
                this.sendEmptyMessageDelayed(0, 20);
            }
        };

        handler.sendEmptyMessageDelayed(0, 20);
    }


    @Override
    protected void initView() {

    }

}
