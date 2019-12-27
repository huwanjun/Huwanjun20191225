package com.bawei.huwanjun.model;

import com.android.volley.toolbox.StringRequest;
import com.bawei.huwanjun.contract.IHomeContract;
import com.bawei.huwanjun.model.bean.Bean;
import com.bawei.huwanjun.model.bean.FBean;
import com.bawei.huwanjun.util.NetUtil;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * author: 斛万珺
 * data: 2019/12/25 10:10:22
 * function:
 */
public class HomeModel implements IHomeContract.IModel {
    @Override
    public void getHomeData(String keyword, final IModelCallback iModelCallback) {
        try {
            URLEncoder.encode(keyword,"UTF-8");

            String httpUrl="http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?page=1&count=5&keyword=\"+encode";
            NetUtil.getInstance().getJsonGet(httpUrl, new NetUtil.MyCallback() {
                @Override
                public void onSuccess(String json) {

                    Bean bean = new Gson().fromJson(json, Bean.class);
                    iModelCallback.onHomeSuccess(bean);
                }

                @Override
                public void onError(Throwable throwable) {
                    iModelCallback.onHomeFailure(throwable);

                }
            });

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getFlowData(final IModelCallback iModelCallback) {
        NetUtil.getInstance().getJsonGet("http://blog.zhaoliang5156.cn/baweiapi/%E6%89%8B%E6%9C%BA", new NetUtil.MyCallback() {
            @Override
            public void onSuccess(String json) {
                FBean fBean = new Gson().fromJson(json, FBean.class);
                iModelCallback.onFlowSuccess(fBean);
            }

            @Override
            public void onError(Throwable throwable) {
                iModelCallback.onFlowFailure(throwable);

            }
        });

    }
}
