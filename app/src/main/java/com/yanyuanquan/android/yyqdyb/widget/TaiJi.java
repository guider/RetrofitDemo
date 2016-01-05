package com.yanyuanquan.android.yyqdyb.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * @Created by apple on 16/1/1.
 * @description:
 * @projectName:YYQDYB
 */
public class TaiJi extends View {
    Paint blackPaint,whitePaint;
    public TaiJi(Context context) {
        super(context);
        init();
    }
    public TaiJi(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public TaiJi(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int centerX = getWidth()/2;
        int centerY = getHeight()/2;
        Point point = new Point(centerX,centerY);
        canvas.translate(point.x,point.y);
        canvas.drawColor(Color.GRAY);
        canvas.rotate(degree);

        int radius = Math.max(centerX,centerY)/2-50;
        RectF rect = new RectF(-radius,-radius,radius,radius);
        canvas.drawArc(rect,90,180,true,blackPaint);
        canvas.drawArc(rect,-90,180,true,whitePaint);
//        RectF oval          //绘制的区域（是一个矩形）
//        float startAngle    //开始角度
//        float sweepAngle    //扫过角度
//        boolean useCenter   //是否使用中心
//        Paint paint         //画笔
        int samllRadius = radius/2;
        canvas.drawCircle(0,-samllRadius,samllRadius,blackPaint);
        canvas.drawCircle(0,samllRadius,samllRadius,whitePaint);

        canvas.drawCircle(0,-samllRadius,samllRadius/4,whitePaint);
        canvas.drawCircle(0,samllRadius,samllRadius/4,blackPaint);
    }

    private float degree =0;
    public void setDegree(float degree){
        this.degree = degree;
        invalidate();
    }





    private void init() {
        blackPaint = new Paint();
        whitePaint = new Paint();
        blackPaint.setAntiAlias(true);
        whitePaint.setAntiAlias(true);
        whitePaint.setColor(Color.parseColor("#ffffff"));
        blackPaint.setColor(Color.parseColor("#000000"));
    }

}
