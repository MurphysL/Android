package com.example.lenovo.colorid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.util.AttributeSet;
import android.view.SurfaceHolder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * PreviewSurface
 *
 * @author: lenovo
 * @time: 2016/1/23 10:48
 */

public class PreviewSurface extends CameraSurface implements android.hardware.Camera.PreviewCallback{

    //private onColorListener onColorListener;

    private onColorListener listener;

    public PreviewSurface(Context context) {
        super(context);
    }

    public PreviewSurface(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void surfaceCreated(SurfaceHolder holder) {
        super.surfaceCreated(holder);

        camera.setPreviewCallback(this);
    }
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        super.surfaceChanged(holder, format, width, height);

    }
    public void surfaceDestroyed(SurfaceHolder holder) {
        camera.setPreviewCallback(null);
        super.surfaceDestroyed(holder);

    }
    public void onPreviewFrame(byte[] date, android.hardware.Camera camera){
        //camera的尺寸
        android.hardware.Camera.Size size = camera.getParameters().getPreviewSize();
        //data转为yuvimage
        YuvImage image = new YuvImage(date, ImageFormat.NV21,size.width,size.height,null);
        //新建一个输出流对象
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        if(null != image){
            //ctrl+shift+上键 语句上移
            image.compressToJpeg(new Rect(0,0,size.width,size.height),100,outputStream);
            try {
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Bitmap bitmap = BitmapFactory.decodeStream(new ByteArrayInputStream(outputStream.toByteArray()));

        int color = bitmap.getPixel(size.width/2,size.height/2);

        if(null != listener){
            listener.onColor(color);
        }
    }

    public void setOnColorListener(onColorListener listener){
        this.listener = listener;

    }
    public interface  onColorListener{
        void onColor(int color);
    }
}
