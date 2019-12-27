package com.bawei.day1226zy.base;

/**
 * author: 斛万珺
 * data: 2019/12/26 18:18:38
 * function:
 */
public abstract class BasePresenter<V> {
    protected V view;

    public void attach(V view){
        this.view=view;
    }

    public void detach(){
        view=null;

    }

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();
}
