package com.example.lenovo.flappybird.com.example.lenovo.game.layer;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.example.lenovo.flappybird.com.example.lenovo.game.GameSurface;

/**
 * BaseLayer
 *
 * @author: lenovo
 * @time: 2016/1/24 10:12
 */

public abstract class BaseLayer {

    /**
     * 当前surface视图的尺寸
     */
    protected int screenW,screenH;

    protected GameSurface surface;

    protected Resources res;

    public BaseLayer(GameSurface surface){
        this.surface = surface;

        res = surface.getResources();

        this.screenW = surface.getWidth();
        this.screenH = surface.getHeight();
    }
    /**
     * 画图
     * @param canvas 画布
     * @param paint 画笔
     */
    public abstract void draw(Canvas canvas,Paint paint);

    public abstract void logic();

    /**
     * 触摸事件
     * @param event
     */
    public abstract void onTouchEvent(MotionEvent event);

    /**
     * 点击事件
     * @param keyCode
     * @param event
     * @return
     */
    public abstract void onKeyDown(int keyCode, KeyEvent event) ;
}
