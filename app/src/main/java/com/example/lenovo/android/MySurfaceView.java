package com.example.lenovo.android;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.Random;

/**
 * MySurfaceView
 *
 * @author: lenovo
 * @time: 2016/1/22 10:18
 */

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback,Runnable{

    public final static String TAG = "MySurfaceView";
    private SurfaceHolder holder;

    private Canvas canvas;//画布
    private Paint paint;//画笔

    private Thread thread;
    private boolean flag;

    private float x,y;
    private float speedsX,speedsY;
    private  float radius;
    private  int color;

    private Vector local;//位置
    private Vector speed;//速度
    private Vector acc;//加速度

    private float recX,recY,recX1,recY1;
    private float recWidth,recHeight,rec1Width,rec1Height;
    private boolean isColl;


    public MySurfaceView(Context context) {
        super(context);
        init();
    }

    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    /**
     * 初始化
     */
    private void init(){
        holder = getHolder();
        holder.addCallback(this);

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);

    }

    /**
     * 初始化游戏
     */
    private void initGame(){
        x = 0;
        y = 0;

        //基础移动
        speedsX = 10;
        speedsY = 20;
        radius = 50;
        color = Color.RED;

        //向量移动
        local = new Vector(100,100);
        speed = new Vector(10,20);
        acc = new Vector(1.0f,2.0f);

        //
        recX = getWidth()/2 - 100;
        recY = getHeight()/2 -100;
        recWidth = 200;
        recHeight = 160;

        recX1 = x;
        recY1 = y;
        rec1Width = 200;
        rec1Height = 100;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Log.i(TAG, "surfaceCreated");

        initGame();

        flag = true;

        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Log.i(TAG, "surfaceChanged");
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        Log.i(TAG, "surfaceDestroyed");
        flag = false;
    }

    private void myDraw(Canvas canvas){
        paint.setColor(Color.WHITE);
        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);
        paint.setColor(color);
        canvas.drawCircle(x, y, radius, paint);
        //canvas.drawRect(recX1,recY1, recX1 + recWidth,recY1 + recHeight,paint);

        paint.setColor(Color.BLUE);
        canvas.drawRect(recX,recY,recX + recWidth,recY + recHeight,paint);


        paint.setColor(Color.RED);
        canvas.drawCircle(local.x, local.y, radius, paint);

        if(isColl){
            paint.setColor(Color.BLACK);
            canvas.drawCircle(150, 200,100, paint);
        }

    }

    private void logic(){


        //简单移动
        x += speedsX;
        y += speedsY;

        if(x >= getWidth()||x < 0){
            speedsX = -speedsX;
        }
        if(y >= getHeight()||y < 0){
            speedsY = -speedsY;
        }


        //向量移动
        speed.limit(50);
        speed.add(acc);
        local.add(speed);

        if(local.x >= getWidth()||local.x < 0){
            speed.x = -speed.x;
            acc.x = -acc.x;
        }
        if(local.y >= getHeight()||local.y < 0){
            speed.y = -speed.y;
            acc.y = -acc.y;
        }

        //碰撞检测
        recX1 = x;
        recY1 = y;

        //矩形碰撞
        //isColl = rectandRect(recX1,recY1,rec1Width,rec1Height,recX,recY,recWidth,recHeight);
        //圆与圆
        isColl = circleAndCircle(x,y,radius,local.x,local.y,radius);

    }

    /**
     * 矩形间碰撞检测
     * @param recX1
     * @param recY1
     * @param rec1Width
     * @param rec1Height
     * @param recX
     * @param recY
     * @param recWidth
     * @param recHeight
     * @return
     */
    public boolean rectandRect(float recX1,float recY1,float rec1Width,float rec1Height,
                               float recX,float recY,float recWidth,float recHeight){
        if(recX1 + rec1Width < recX){
            return false;
        }else if (recX1 > recX + recWidth){
            return false;
        }else if(recY1 + rec1Height < recY){
            return  false;
        }else  if(recY1 > recY + recHeight){
            return  false;
        }
        return true;
    }

    /**
     * 圆的碰撞
     * @param circle1X
     * @param circle1Y
     * @param circle1R
     * @param circle2X
     * @param circle2Y
     * @param circle2R
     * @return
     */
    private boolean circleAndCircle(float circle1X,float circle1Y,float circle1R,
                                    float circle2X,float circle2Y,float circle2R){
        float dis = (float)(Math.pow(circle2X - circle1X,2) + Math.pow(circle2X - circle1X,2));
        if(dis < Math.pow(circle1R + circle2R,2)){
            return false;
        }
        return true;
    }

    /**
     * 圆与矩形的碰撞
     * @param circle1X
     * @param circle1Y
     * @param circle1R
     * @param recX
     * @param recY
     * @param recWidth
     * @param recHeight
     * @return
     */
    private boolean circleAndRect(float circle1X,float circle1Y,float circle1R,
                                  float recX,float recY,float recWidth,float recHeight){
        if(circle1X + circle1R < recX){
            return false;
        }else if (circle1X - circle1R> recX + recWidth){
            return false;
        }else if(circle1Y + circle1R < recY){
            return false;
        }else if(circle1Y - circle1R > recY + recHeight){
            return false;
        }else if(Math.pow(recX - circle1X,2)+ Math.pow(recY - circle1Y,2)> circle1R * circle1R){
            return false;
        }else if(Math.pow(recX + recWidth - circle1X,2)+ Math.pow(recY - circle1Y,2)> circle1R * circle1R){
            return false;
        }else if(Math.pow(recX - circle1X,2)+ Math.pow(recY + recHeight - circle1Y,2)> circle1R * circle1R){
            return false;
        }else if(Math.pow(recX + recWidth - circle1X,2)+ Math.pow(recY + recHeight - circle1Y,2)> circle1R * circle1R){
            return false;
        }
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int)event.getX();
        int y = (int)event.getY();
        int[] colors = new int[]{Color.RED,Color.BLACK,Color.BLUE,Color.GRAY,Color.YELLOW};
        color = colors[new Random().nextInt(colors.length)];
        radius = new Random().nextInt(20) + 50;

        //牵引力
        Vector touch = new Vector(x,y);
        acc = Vector.sub(touch,local);
        acc.normalize();
        acc.mult(15.0f);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }

    public void run(){
        while (flag){
            long start = System.currentTimeMillis();

            //加锁
            canvas = holder.lockCanvas();
            if(null != canvas){
                myDraw(canvas);
                //解锁
                holder.unlockCanvasAndPost(canvas);
            }
            logic();

            long end = System.currentTimeMillis();

            if(end - start < 50){
                try{
                    Thread.sleep(50-(end - start));
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
