package com.example.lenovo.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.*;
import android.view.View;

/**
 * Myview
 *
 * @author: lenovo
 * @time: 2016/1/22 8:22
 */

public class Myview extends View{

    public Paint paint;
    private int x;
    private int y;


    public Myview(Context context) {
        super(context);
        init();
    }

    public Myview(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    /**
     * 初始化
     */
    private void init(){
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);//是否抗锯齿

        x = 100;
        y = 100;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(15);
        canvas.drawLine(0, 0, x, y, paint);

        //drawTest(canvas);
        //drawPath(canvas);
        //drawBitmap(canvas);
    }

    /**
     * 基础绘图
     * @param canvas
     */
    private void drawTest(Canvas canvas){
        //颜色
        paint.setColor(Color.RED);
        //STROKE非填充
        paint.setStyle(Paint.Style.STROKE);
        //画笔的宽度
        paint.setStrokeWidth(15);
        //画线 canvas.drawLine (float startX, float startY, float stopX, float stopY, Paint paint)
        canvas.drawLine(0, 0, x, y, paint);
        //画圆 canvas.drawCircle(float cx, float cy, float radius, Paint paint);
        canvas.drawCircle(200, 100, 100, paint);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(200, 100, 100, paint);

        //画矩形 canvas.drawRect(float left, float top, float right, float bottom, Paint paint);
        paint.setColor(Color.BLACK);
        canvas.drawRect(100, 500, 300, 600, paint);
        //画圆角矩形
        //canvas.drawRoundRect(100,700,200,800,10,10,paint);
        //
    }

    //路径是自动封闭的
    private void drawPath(Canvas canvas){
        //三角
        Path path = new Path();
        path.moveTo(100, 100);
        path.lineTo(100, 300);
        path.lineTo(200, 250);

        paint.setColor(Color.GRAY);
        canvas.drawPath(path,paint);

        //轮子
        Path path1 = new Path();
        //path.addCircle(500,500,100,Path.Direction.CW);
        path1.addCircle(500, 500, 200, Path.Direction.CW);
        path1.moveTo(500, 300);
        path1.lineTo(500, 700);
        path1.moveTo(300, 500);
        path1.lineTo(700, 500);

        paint.setColor(Color.RED);
        paint.setStrokeWidth(15);
        paint.setStyle(Paint.Style.STROKE);
        //paint.setStyle(Paint.Style.FILL);
        canvas.drawPath(path1, paint);
    }

    private void drawBitmap(Canvas canvas){
        //加载图片
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        canvas.drawBitmap(bitmap, 0, 0, paint);

        //设置坐标系原点位置
        canvas.translate(getWidth() / 2, getHeight() / 2);
        //坐标系
        canvas.drawLine(0, -getHeight() / 2, 0, getHeight() / 2, paint);
        canvas.drawLine(-getWidth() / 2,0, getWidth(), 0,paint);

        canvas.drawCircle(0, 0, 20,paint);
        canvas.drawBitmap(bitmap, 0, 0, paint);

        //保存之前设置
        canvas.save();

        //旋转
        canvas.rotate(90);
        canvas.drawBitmap(bitmap, 0, 0, paint);

        //恢复之前设置
        canvas.restore();

        canvas.drawCircle(200,200,20,paint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        //alt + 回车 改错
        x = (int)event.getX();
        y = (int)event.getY();

        //重置
        invalidate();

        return super.onTouchEvent(event);
    }
}
