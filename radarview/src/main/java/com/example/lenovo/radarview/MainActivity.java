package com.example.lenovo.radarview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadarView radarView = (RadarView) findViewById(R.id.radarview);
        radarView.setDirection(RadarView.ANTI_CLOCK_WISE);
        radarView.start();
    }
}
