package com.bawei.huwanjun.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.huwanjun.R;
import com.bawei.huwanjun.base.BaseFragment;
import com.bawei.huwanjun.base.BasePresenter;
import com.bawei.huwanjun.contract.IHomeContract;
import com.bawei.huwanjun.model.bean.Bean;
import com.bawei.huwanjun.model.bean.FBean;
import com.bawei.huwanjun.presenter.HomePresenter;
import com.bawei.huwanjun.view.myadapter.MyAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment<HomePresenter> implements IHomeContract.IView {

    private RecyclerView recy;


    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView(View inflate) {
        recy=inflate.findViewById(R.id.recy);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        recy.setLayoutManager(gridLayoutManager);


    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {

        mPresenter.getHomeData("板鞋");
        mPresenter.getFlowData();

    }

    @Override
    public void onHomeSuccess(Bean bean) {
        List<Bean.ResultBean> result = bean.getResult();
        for (int i = 0; i < result.size(); i++) {

        }




    }

    @Override
    public void onHomeFailure(Throwable throwable) {

    }

    @Override
    public void onFlowSuccess(FBean fBean) {

    }

    @Override
    public void onFlowFailure(Throwable throwable) {

    }
}
