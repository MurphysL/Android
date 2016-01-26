package com.example.lenovo.flappybird.com.example.lenovo.game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.lenovo.flappybird.com.example.lenovo.game.layer.Background;
import com.example.lenovo.flappybird.com.example.lenovo.game.layer.Barrier;
import com.example.lenovo.flappybird.com.example.lenovo.game.layer.Player;
import com.example.lenovo.flappybird.com.example.lenovo.game.layer.Score;
import com.example.lenovo.flappybird.com.example.lenovo.game.layer.Start;
import com.example.lenovo.flappybird.utils.Constants;

/**
 * GameSurface
 *
 * @author: lenovo
 * @time: 2016/1/24 9:29
 */

public class GameSurface extends SurfaceView implements SurfaceHolder.Callback,Runnable{

    public final static String TAG = "GameSurface";

    public static int gameState;//游戏状态

    private SurfaceHolder holder;

    private Paint paint;
    private Canvas canvas;

    private Thread thread;
    private boolean flag;

    //游戏图层
    private Background background;//背景
    private Player player;//主角
    private Start start;//开始
    private Barrier barrier;//障碍
    private Score score;//分数

    private int scoreMax;//最高成绩

    public GameSurface(Context context) {
        super(context);
        init();
    }

    public GameSurface(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    /**
     * 初始化
     */
    private void init(){
        holder = getHolder();
        holder.addCallback(this);
        setKeepScreenOn(true);

        holder.setFormat(PixelFormat.TRANSPARENT);
        setZOrderOnTop(true);

        paint = new Paint();
        paint.setAntiAlias(true);

        scoreMax = 0;
    }

    /**
     * 初始化游戏
     */
    private void initGame(){
        gameState = Constants.GAME_START;//设置初始状态为游戏开始

        background = new Background(this);
        player = new Player(this);
        start = new Start(this);
        barrier = new Barrier(this);
        score = new Score(this);

        score.setScoreMax(scoreMax);
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

    /**
     * 画图
     * @param canvas
     */
    private void myDraw(Canvas canvas){
       // background.draw(canvas, paint);
        //清屏
        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);


        switch (gameState){
            case Constants.GAME_START:
                player.draw(canvas,paint);
                start.draw(canvas,paint);
                score.draw(canvas,paint);
                break;
            case Constants.GAMEING:
                player.draw(canvas,paint);
                barrier.draw(canvas,paint);
                score.draw(canvas,paint);
                break;
            case Constants.GAME_END:
                player.draw(canvas, paint);
                break;
            default:
                break;
        }
    }

    /**
     * 逻辑
     */
    private void logic(){

        switch (gameState){
            case Constants.GAME_START:

                break;
            case Constants.GAMEING:
                player.logic();
                barrier.setPlayerX(player.getPlayerX());
                barrier.setPlayerY(player.getPlayerY());
                barrier.setRadius(player.getRadius());
                barrier.logic();
                score.logic();
                break;
            case Constants.GAME_END:
                initGame();
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (gameState) {
            case Constants.GAME_START:
                start.onTouchEvent(event);
                break;
            case Constants.GAMEING:
                player.onTouchEvent(event);
                break;
            case Constants.GAME_END:

                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void run(){
        while (flag){
            long start = System.currentTimeMillis();
            canvas = holder.lockCanvas();
            if(null != canvas){
                myDraw(canvas);
                holder.unlockCanvasAndPost(canvas);
            }
            logic();
            long end = System.currentTimeMillis();

            if(end - start < 50){
                try {
                    Thread.sleep(50 - (end - start));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getGameState() {
        return gameState;
    }

    public void setGameState(int gameState){
        this.gameState = gameState;
    }

    public void setScoreMax(int scoreMax) {
        this.scoreMax = scoreMax;
    }
}
