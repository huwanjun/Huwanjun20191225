package com.bawei.day1226zy;

import android.app.Application;

/**
 * author: 斛万珺
 * data: 2019/12/26 19:19:37
 * function:
 */
public class App extends Application {

    public static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        app=this;
        Thread.setDefaultUncaughtExceptionHandler(new Throws());
    }
}
