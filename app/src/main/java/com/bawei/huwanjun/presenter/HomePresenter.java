package com.bawei.huwanjun.presenter;

import com.bawei.huwanjun.base.BasePresenter;
import com.bawei.huwanjun.contract.IHomeContract;
import com.bawei.huwanjun.model.HomeModel;
import com.bawei.huwanjun.model.bean.Bean;
import com.bawei.huwanjun.model.bean.FBean;
import com.bawei.huwanjun.util.NetUtil;

/**
 * author: 斛万珺
 * data: 2019/12/25 11:11:01
 * function:
 */
public class HomePresenter extends BasePresenter<IHomeContract.IView> implements IHomeContract.IPresenter {

    private HomeModel homeModel;

    @Override
    protected void initModel() {
        homeModel = new HomeModel();
    }

    @Override
    public void getHomeData(String keyword) {
        homeModel.getHomeData(keyword, new IHomeContract.IModel.IModelCallback() {
            @Override
            public void onHomeSuccess(Bean bean) {
                view.onHomeSuccess(bean);

            }

            @Override
            public void onHomeFailure(Throwable throwable) {
                view.onHomeFailure(throwable);

            }

            @Override
            public void onFlowSuccess(FBean fBean) {
                view.onFlowSuccess(fBean);

            }

            @Override
            public void onFlowFailure(Throwable throwable) {
                view.onFlowFailure(throwable);

            }
        });

    }

    @Override
    public void getFlowData() {

        homeModel.getFlowData(new IHomeContract.IModel.IModelCallback() {
            @Override
            public void onHomeSuccess(Bean bean) {
                view.onHomeSuccess(bean);


            }

            @Override
            public void onHomeFailure(Throwable throwable) {
                view.onHomeFailure(throwable);

            }

            @Override
            public void onFlowSuccess(FBean fBean) {
                view.onFlowSuccess(fBean);

            }

            @Override
            public void onFlowFailure(Throwable throwable) {
                view.onHomeFailure(throwable);

            }
        });
    }
}
