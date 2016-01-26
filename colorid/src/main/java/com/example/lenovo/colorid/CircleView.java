package com.example.lenovo.colorid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * CircleView
 *
 * @author: lenovo
 * @time: 2016/1/23 8:30
 */

public class CircleView extends SurfaceView implements SurfaceHolder.Callback{

    public final static String TAG = "CircleView";

    private SurfaceHolder holder;

    private Paint paint;
    private Canvas canvas;
    private int color;

    public CircleView(Context context) {
        super(context);
        init();
    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    /**
     * 初始化
     */
    private void init(){
        holder = getHolder();
        holder.addCallback(this);
        holder.setFormat(PixelFormat.TRANSPARENT);
        setKeepScreenOn(true);
        setZOrderOnTop(true);

        paint = new Paint();
        paint.setAntiAlias(true);

        color = Color.RED;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        refresh();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Log.i(TAG, "surfaceChanged");
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

        Log.i(TAG, "surfaceDestroyed");

    }


    /**
     * 画图
     * @param canvas
     */
    private void myDraw(Canvas canvas){
        //绘制背景
        //paint.setColor(Color.WHITE);
        //canvas.drawRect(0, 0, getWidth(), getHeight(), paint);
        //canvas.draw

        canvas.save();
        canvas.translate(getWidth() / 2, getHeight() / 2);//设置坐标为中心
        paint.setStyle(Paint.Style.STROKE);//设置画笔为非填充
        paint.setColor(color);
        paint.setStrokeWidth(15);

        float radius = getHeight()/4;
        canvas.drawCircle(0, 0, radius, paint);//画圆

        paint.setStrokeWidth(4);
        canvas.drawLine(0, paint.getStrokeWidth() / 2, 0, -radius, paint);//画上线
        paint.setStrokeWidth(5);
        canvas.drawLine(-paint.getStrokeWidth()/2,0, radius, 0, paint);//画右线

        canvas.restore();
    }

    /**
     * 逻辑
     */
    private void logic(){

    }

    /**
     * 刷新界面
     */
    public void refresh(){
        canvas = holder.lockCanvas();
        if(null != canvas){
            myDraw(canvas);
            holder.unlockCanvasAndPost(canvas);
        }
        logic();
    }

    public void setColor(int color){
        this.color = color;

    }


    //@Override
    /*public void run() {

    }*/
}
