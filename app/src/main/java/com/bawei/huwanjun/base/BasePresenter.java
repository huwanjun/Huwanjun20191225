package com.bawei.huwanjun.base;

/**
 * author: 斛万珺
 * data: 2019/12/25 09:9:06
 * function:
 */
public  abstract class BasePresenter<V> {

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
