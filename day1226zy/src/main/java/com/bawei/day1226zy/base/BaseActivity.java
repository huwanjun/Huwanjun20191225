package com.bawei.day1226zy.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * author: 斛万珺
 * data: 2019/12/26 18:18:39
 * function:
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        mPresenter=providePresenter();
        if (mPresenter != null) {
            mPresenter.attach(this);
        }
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract P providePresenter();

    protected abstract int layoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detach();
        }
    }
}
