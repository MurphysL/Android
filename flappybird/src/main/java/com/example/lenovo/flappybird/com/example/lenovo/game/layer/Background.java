package com.example.lenovo.flappybird.com.example.lenovo.game.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Camera;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.example.lenovo.flappybird.R;
import com.example.lenovo.flappybird.com.example.lenovo.game.GameSurface;
import com.example.lenovo.flappybird.utils.Assist;

import java.io.IOException;

/**
 * Background
 *
 * @author: lenovo
 * @time: 2016/1/24 10:01
 */

public class Background extends BaseLayer{

    public Background(GameSurface surface) {
        super(surface);
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        //paint.setColor(Assist.getColor(res,R.color.Cyan));
        //背景
        //canvas.drawRect(0,0,screenW,screenH,paint);
    }

    @Override
    public void logic() {

    }

    @Override
    public void onTouchEvent(MotionEvent event) {

    }

    @Override
    public void onKeyDown(int keyCode, KeyEvent event) {

    }
}
