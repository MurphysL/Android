package com.example.lenovo.flappybird.com.example.lenovo.game.layer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.example.lenovo.flappybird.R;
import com.example.lenovo.flappybird.com.example.lenovo.game.GameSurface;
import com.example.lenovo.flappybird.utils.Assist;
import com.example.lenovo.flappybird.utils.Constants;

/**
 * Player
 *
 * @author: lenovo
 * @time: 2016/1/24 10:01
 */

public class Player extends BaseLayer{

    private float playerX, playerY;
    private float radius;

    private float speed;//速度
    private float acc;//加速度


    public Player(GameSurface surface) {
        super(surface);

        playerX = screenW / 2;
        playerY = screenH / 2;

        radius = 60;
        speed = 15;
        acc = 6;

    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(Assist.getColor(res, R.color.Black));



        switch (surface.gameState) {
            case Constants.GAME_START:
                canvas.drawCircle(screenW / 2, screenH / 2, radius, paint);
                break;
            case Constants.GAMEING:
                canvas.drawCircle(playerX, playerY, radius, paint);
                break;
            case Constants.GAME_END:
                canvas.drawCircle(screenW / 2, screenH / 2, radius, paint);
                break;
            default:
                break;
        }
    }

    @Override
    public void logic() {
        playerY += speed;
        speed += acc;
        //与边界碰撞
        if(playerY - radius < 0 ||playerY + radius > screenH){
            surface.setGameState(Constants.GAME_END);
        }
    }

    @Override
    public void onTouchEvent(MotionEvent event) {
        //speed -= 60;
        speed = -50 + acc;
    }

    @Override
    public void onKeyDown(int keyCode, KeyEvent event) {

    }

    public float getPlayerX() {
        return playerX;
    }

    public float getPlayerY() {
        return playerY;
    }

    public float getRadius() {
        return radius;
    }
}
