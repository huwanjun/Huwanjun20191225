package com.bawei.day1226zy.util;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.day1226zy.App;
import com.bawei.day1226zy.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestOptions;

import java.util.Map;

/**
 * author: 斛万珺
 * data: 2019/12/26 19:19:34
 * function:
 */
public class NetUtil {

    private static NetUtil netUtil;
    private final RequestQueue requestQueue;

    private NetUtil(){
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

    public void  getJsonGet(String httpUrl, final MyCallback myCallback){
        StringRequest stringRequest = new StringRequest(StringRequest.Method.GET, httpUrl, new Response.Listener<String>() {
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

    public void  getJsonPost(String httpUrl, final Map<String,String> map, final MyCallback myCallback){
        StringRequest stringRequest = new StringRequest(StringRequest.Method.GET, httpUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                myCallback.onSuccess(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                myCallback.onError(error);

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }
        };
        requestQueue.add(stringRequest);

    }
    public void getPhoto(String photoUrl ,ImageView imageView){

        Glide.with(imageView).load(photoUrl)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher_round)
                //圆形图
                .apply(RequestOptions.bitmapTransform(new CenterCrop()))
                .into(imageView);
    }

    public interface MyCallback{

        void onSuccess(String json);
        void onError(Throwable throwable);
    }
}
