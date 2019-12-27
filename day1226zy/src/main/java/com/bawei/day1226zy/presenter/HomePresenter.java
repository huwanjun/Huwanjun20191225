package com.bawei.day1226zy.presenter;

import com.android.volley.toolbox.Volley;
import com.bawei.day1226zy.base.BasePresenter;
import com.bawei.day1226zy.contract.IHomeContract;
import com.bawei.day1226zy.model.MyModel;
import com.bawei.day1226zy.model.bean.Bean;
import com.bawei.day1226zy.model.bean.FBean;
import com.bawei.day1226zy.util.NetUtil;

/**
 * author: 斛万珺
 * data: 2019/12/26 19:19:57
 * function:
 */
public class HomePresenter extends BasePresenter<IHomeContract.IView> implements IHomeContract.IPresenter {

    private MyModel myModel;

    @Override
    protected void initModel() {

        myModel = new MyModel();
    }

    @Override
    public void getHomeData(String keyword) {
        myModel.getHomeData(keyword, new IHomeContract.IModel.IModelCallback() {
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
        myModel.getFlowData(new IHomeContract.IModel.IModelCallback() {
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
}
