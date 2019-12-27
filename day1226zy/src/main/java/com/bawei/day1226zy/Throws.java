package com.bawei.day1226zy;

import android.util.Log;

/**
 * author: 斛万珺
 * data: 2019/12/27 08:8:35
 * function:
 */
public class Throws implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Log.i("TAG",e.getMessage());
    }
}
