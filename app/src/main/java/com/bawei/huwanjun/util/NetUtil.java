package com.bawei.huwanjun.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.huwanjun.App;

import java.util.IdentityHashMap;
import java.util.Map;

/**
 * author: 斛万珺
 * data: 2019/12/25 10:10:35
 * function:
 */
public class NetUtil {

    private static NetUtil netUtil;
    private final RequestQueue requestQueue;

    private NetUtil() {
        requestQueue = Volley.newRequestQueue(App.app);
    }

    public static NetUtil getInstance(){

        if (netUtil==null){
            synchronized (NetUtil.class){

                if (netUtil==null){
                    netUtil=new NetUtil();
                }
            }

        }
        return netUtil;
    }

    public boolean getNet(Context context){

        ConnectivityManager manager=(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info=manager.getActiveNetworkInfo();

        if (info!=null){
            return info.isConnected();
        }
        return false;
    }

    public void getJsonGet(String httpurl, final MyCallback myCallback){
        StringRequest stringRequest = new StringRequest(StringRequest.Method.GET, httpurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                myCallback.onSuccess(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                myCallback.onError(error);

            }
        });
        requestQueue.add(stringRequest);
    }

    public void getJsonPost(String httpurl, final Map<String,String> map, final MyCallback myCallback ){
        StringRequest stringRequest = new StringRequest(StringRequest.Method.POST, httpurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                myCallback.onSuccess(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                myCallback.onError(error);

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }
        };
        requestQueue.add(stringRequest);
    }

    public interface MyCallback{
        void onSuccess(String json);
        void onError(Throwable throwable);

    }

}