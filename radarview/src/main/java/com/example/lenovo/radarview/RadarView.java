package com.example.lenovo.radarview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.annotation.IntDef;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;

/**
 * RadarView
 *
 * @author: lenovo
 * @time: 2016/3/28 19:14
 */

class RadarView extends FrameLayout{

    public final static String TAG = "Radar";

    private Context mContext;
    private Paint mPaintLine;
    private Paint mPaintCircle;
    private Paint mPaintPoint;
    private Paint mPaintSector;

    private ScanThread mThread;

    private Shader mShader;

    public final static int CLOCK_WISE = 1;
    public final static int ANTI_CLOCK_WISE = -1;

    //默认为顺时针
    private final static int DEFAULT_DIERCTION = CLOCK_WISE;
    //雷达扫描方向
    private int direction = DEFAULT_DIERCTION;

    private Matrix matrix;

    private boolean threadRunning = true;
    public boolean isstart = false;

    //起始角度
    private int start = 0;

    @IntDef({CLOCK_WISE , ANTI_CLOCK_WISE})
    public @interface RADAR_DIRECTION{

    }

    public RadarView(Context context) {
        super(context);
        mContext = context;
        initPaint();
    }

    public RadarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initPaint();
    }

    private void initPaint(){
        //透明背景
        setBackgroundColor(Color.TRANSPARENT);

        mPaintLine = new Paint();
        mPaintLine.setAntiAlias(true);
        mPaintLine.setStrokeWidth(5);
        mPaintLine.setStyle(Paint.Style.STROKE);
        mPaintLine.setColor(Color.WHITE);

        mPaintCircle = new Paint();
        mPaintCircle.setStrokeWidth(5);
        mPaintCircle.setAntiAlias(true);
        mPaintCircle.setStyle(Paint.Style.FILL);
        mPaintCircle.setColor(0x99000000);

        mPaintSector = new Paint();
        mPaintSector.setAntiAlias(true);
        mPaintSector.setColor(0x9D00FF00);

        mPaintPoint = new Paint();
        mPaintPoint.setColor(Color.WHITE);
        mPaintPoint.setStyle(Paint.Style.FILL);
    }

    public void start(){
        mThread = new ScanThread(this);
        mThread.setName("radar");
        Log.i(TAG, "--------------START---------------");
        mThread.start();
        threadRunning = true;
        isstart = true;
    }

    public void stop(){
        if(isstart){
            threadRunning = false;
            isstart = false;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {

        //梯度渲染
        mShader = new SweepGradient(getWidth() / 2 , getHeight() / 2 ,Color.TRANSPARENT , Color.GREEN);
        mPaintSector.setShader(mShader);

        //灰色背景
        canvas.drawCircle(getWidth()/2, getHeight() / 2, 350, mPaintCircle);
        //雷达线
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, 150, mPaintLine);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, 250, mPaintLine);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, 350, mPaintLine);
        //纵十字线
        canvas.drawLine(getWidth() / 2 - 350, getHeight() / 2 , getWidth() / 2 + 350 , getHeight() / 2, mPaintLine);
        //横十字线
        canvas.drawLine(getWidth() / 2, getHeight() / 2 - 350 , getWidth() / 2 , getHeight() / 2 + 350 , mPaintLine);

        canvas.concat(matrix);

        //扫描图形
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, 350, mPaintSector);

        super.onDraw(canvas);
    }

    public void setDirection(@RADAR_DIRECTION int direction){
        if(direction != CLOCK_WISE && direction != ANTI_CLOCK_WISE){
            throw new IllegalArgumentException("Use @RADAR_DIRECTION constants only");
        }
        this.direction = direction;
    }


    protected class ScanThread extends Thread{

        private RadarView view;

        public ScanThread(RadarView view){
            this.view = view;
        }

        public void run(){
            while (threadRunning){
                if(isstart){
                    view.post(new Runnable() {
                        @Override
                        public void run() {
                            start = start + 1;
                            matrix = new Matrix();
                            //矩阵 旋转
                            matrix.postRotate(start , getWidth() / 2 , getHeight() / 2);
                            //matrix.setRotate(start, viewSize / 2, viewSize / 2);
                            //matrix.preRotate(direction * start, viewSize / 2, viewSize / 2);
                            view.invalidate();
                        }
                    });
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
