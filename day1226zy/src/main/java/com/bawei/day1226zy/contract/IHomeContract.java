package com.bawei.day1226zy.contract;

import com.bawei.day1226zy.model.bean.Bean;
import com.bawei.day1226zy.model.bean.FBean;

/**
 * author: 斛万珺
 * data: 2019/12/26 19:19:26
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

        void getHomeData(String keyword, IModelCallback iModelCallback );
        void getFlowData(IModelCallback iModelCallback);

        interface IModelCallback{

            void onHomeSuccess(Bean bean);
            void onHomeFailure(Throwable throwable);

            void onFlowSuccess(FBean fBean);
            void onFlowFailure(Throwable throwable);
        }

    }


}
