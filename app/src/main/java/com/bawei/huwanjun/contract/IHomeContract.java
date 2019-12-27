package com.bawei.huwanjun.contract;

import com.bawei.huwanjun.model.bean.Bean;
import com.bawei.huwanjun.model.bean.FBean;

/**
 * author: 斛万珺
 * data: 2019/12/25 10:10:29
 * function:
 */
public interface IHomeContract {

    interface IView{
        void onHomeSuccess(Bean bean);
        void onHomeFailure(Throwable throwable);

        void onFlowSuccess(FBean fBean);
        void onFlowFailure(Throwable throwable);


    }

    interface IPresenter{
        void getHomeData(String keyword);
        void getFlowData();


    }

    interface IModel{

        void getHomeData(String keyword,IModelCallback iModelCallback);
        void getFlowData(IModelCallback iModelCallback);

        interface IModelCallback{
            void onHomeSuccess(Bean bean);
            void onHomeFailure(Throwable throwable);

            void onFlowSuccess(FBean fBean);
            void onFlowFailure(Throwable throwable);


        }

    }
}
