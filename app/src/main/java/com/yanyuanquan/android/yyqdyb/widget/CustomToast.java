package com.yanyuanquan.android.yyqdyb.widget;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.yanyuanquan.android.yyqdyb.R;
import com.yanyuanquan.android.yyqdyb.util.DisplayUtil;

import org.w3c.dom.Text;

/**
 * @Created by apple on 16/1/4.
 * @description:
 * @projectName:YYQDYB
 */
public class CustomToast extends Toast {
    public CustomToast(Context context) {
        super(context);
    }
    public static CustomToast showToast(Context context,String str,int duration){
        CustomToast toast= new CustomToast(context);
        View view = LayoutInflater.from(context).inflate(R.layout.custom_toast,null);
        TextView textView = (TextView) view.findViewById(R.id.toast);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
        layoutParams.height =DisplayUtil.dip2px(context,50);
        layoutParams.width = DisplayUtil.getScreenWidth(context);
        textView.setLayoutParams(layoutParams);
        toast.setView(view);
        return toast;
    }


}
