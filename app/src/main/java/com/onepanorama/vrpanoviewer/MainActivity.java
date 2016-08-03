package com.onepanorama.vrpanoviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;

import panoserver.PanoServer;

public class MainActivity extends AppCompatActivity {
    private PanoServer panoServer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(panoServer != null) {
            panoServer.stop();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        panoServer = new PanoServer("panoviewer", 8080);
        try {
            panoServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
