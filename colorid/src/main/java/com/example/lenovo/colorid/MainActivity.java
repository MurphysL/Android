package com.example.lenovo.colorid;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements PreviewSurface.onColorListener{

    private CircleView circleView; //颜色环
    private PreviewSurface previewSurface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //circleView = (CircleView)findViewById(R.id.circleview);

        //circleView.setColor(Color.GREEN);
        //circleView.refresh();

        circleView = (CircleView)findViewById(R.id.circleview);
        previewSurface = (PreviewSurface)findViewById(R.id.previewsurface);

        previewSurface.setOnColorListener(this);//设置颜色识别监听器
    }

    public void onColor(int color){
        circleView.setColor(color);
        circleView.refresh();
    }
}
