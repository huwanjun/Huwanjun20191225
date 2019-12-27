package com.bawei.day1226zy.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.day1226zy.R;
import com.bawei.day1226zy.base.BaseFragment;
import com.bawei.day1226zy.base.BasePresenter;
import com.bawei.day1226zy.contract.IHomeContract;
import com.bawei.day1226zy.model.bean.Bean;
import com.bawei.day1226zy.model.bean.FBean;
import com.bawei.day1226zy.presenter.HomePresenter;
import com.bawei.day1226zy.view.myadapter.MyAdapter;
import com.bawei.day1226zy.view.widget.FlowLayout;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment<HomePresenter> implements IHomeContract.IView {

    private RecyclerView recy;
    private FlowLayout flow;

    @Override
    protected void initView(View inflate) {
        recy=inflate.findViewById(R.id.recy);
        flow=inflate.findViewById(R.id.flow);

    }

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
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
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recy.setLayoutManager(gridLayoutManager);
        MyAdapter myAdapter = new MyAdapter(result);
        recy.setAdapter(myAdapter);


    }

    @Override
    public void onHomeFailure(Throwable throwable) {

    }

    @Override
    public void onFlowSuccess(FBean fBean) {

        List<String> tags = fBean.getTags();
        for (int i = 0; i < tags.size(); i++) {
            flow.addTag(tags.get(i));
        }
    }

    @Override
    public void onFlowFailure(Throwable throwable) {

    }
}
