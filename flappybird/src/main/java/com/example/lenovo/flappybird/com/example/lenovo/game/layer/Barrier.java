package com.example.lenovo.flappybird.com.example.lenovo.game.layer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.example.lenovo.flappybird.R;
import com.example.lenovo.flappybird.com.example.lenovo.game.GameSurface;
import com.example.lenovo.flappybird.utils.Assist;
import com.example.lenovo.flappybird.utils.Constants;

import java.util.Random;

/**
 * Barrier
 *
 * @author: lenovo
 * @time: 2016/1/24 10:03
 */

public class Barrier extends BaseLayer{

    private float spaceH;//障碍的间隔
    private float distance;//障碍的距离
    private float barrierW;//障碍的宽
    private float barrierY;
    private  float speed;//障碍移动速度

    private float barrier1X,barrier2X;
    private float barrier1H,barrier2H;

    private float playerX, playerY;
    private float radius;


    public Barrier(GameSurface surface) {

        super(surface);

        speed  = 20;
        spaceH = screenH / 4;
        barrierW = 200;
        barrierY = 0;
        distance = screenW / 2 - barrierW / 2;

        barrier1X = screenW + 200;
        barrier1H = getBarrierH();

        barrier2X = barrier1X + distance + barrierW;
        barrier2H = getBarrierH();
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(Assist.getColor(res, R.color.SpringGreen));
        //左上
        canvas.drawRect(barrier1X,barrierY,barrier1X + barrierW,barrierY + barrier1H,paint);
        //左下
        canvas.drawRect(barrier1X, barrier1H + spaceH,barrier1X + barrierW,screenH,paint);
        //右上
        canvas.drawRect(barrier2X,barrierY,barrier2X + barrierW,barrierY + barrier2H,paint);
        //右下
        canvas.drawRect(barrier2X,barrier2H + spaceH,barrier2X + barrierW,screenH,paint);

    }

    @Override
    public void logic() {
        barrier1X -= speed;
        barrier2X -= speed;

        if (barrier1X + barrierW < 0){
            barrier1X  = screenW;
            barrier1H = new Random().nextInt((int) (screenH - spaceH));
        }

        if (barrier2X + barrierW < 0){
            barrier2X  = screenW;
            barrier2H = new Random().nextInt((int) (screenH - spaceH));
        }

        //主角与障碍碰撞检测
        boolean isColl1 = circleAndRect(playerX,playerY,radius,barrier1X,barrierY,barrierW,barrier1H);
        boolean isColl2 = circleAndRect(playerX,playerY,radius,barrier1X,barrier1H + spaceH,barrierW,screenH - barrier1H - screenH);
        boolean isColl3 = circleAndRect(playerX,playerY,radius,barrier2X,barrierY,barrierW,barrier2H);
        boolean isColl4 = circleAndRect(playerX,playerY,radius,barrier2X,barrier2H + spaceH,barrierW,screenH - barrier2H - screenH);

        if(isColl1 || isColl2 || isColl3 || isColl4 ){
            surface.setGameState(Constants.GAME_END);//游戏结束
        }
    }

    @Override
    public void onTouchEvent(MotionEvent event) {

    }

    @Override
    public void onKeyDown(int keyCode, KeyEvent event) {

    }

    private float getBarrierH(){
        return new Random().nextInt((int) (screenH - spaceH - 50));
    }

    public void setPlayerX(float playerX) {
        this.playerX = playerX;
    }

    public void setPlayerY(float playerY) {
        this.playerY = playerY;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    private boolean circleAndRect(float circleX, float circleY, float circleR, float rectX, float rectY, float rectW, float rectH) {
        if (circleX + circleR < rectX) {
            return false;
        } else if (circleX - circleR > rectX + rectW) {
            return false;
        } else if (circleY + circleR < rectY) {
            return false;
        } else if (circleY - circleR > rectY + rectH) {
            return false;
        } else if (Math.pow(rectX - circleX, 2) + Math.pow(rectY - circleY, 2) > circleR * circleR && circleX < rectX && circleY < rectX) {
            return false;
        } else if (Math.pow(rectX + rectW - circleX, 2) + Math.pow(rectY - circleY, 2) > circleR * circleR && circleX > rectX + rectW && circleY < rectY) {
            return false;
        } else if (Math.pow(rectX - circleX, 2) + Math.pow(rectY + rectH - circleY, 2) >circleR * circleR && circleX < rectX && circleY > rectY + rectH){
            return false;
        }else if (Math.pow(rectX + rectW - circleX, 2) + Math.pow(rectY + rectH - circleY, 2) > circleR * circleR && circleX > rectX + rectW && circleY > rectY + rectH) {
            return false;
        }
            return true;
        }
}
