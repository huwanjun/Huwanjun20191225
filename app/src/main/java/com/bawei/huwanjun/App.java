package com.bawei.huwanjun;

import android.app.Application;

/**
 * author: 斛万珺
 * data: 2019/12/25 10:10:38
 * function:
 */
public class App extends Application {
    public static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        app=this;
    }
}
