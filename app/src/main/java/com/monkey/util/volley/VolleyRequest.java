package com.monkey.util.volley;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;

import com.monkey.milestone.MyApplication;

import java.util.Map;

/**
 * Created by Lazy-hong on 2016/3/7.
 */
public class VolleyRequest {
    public static  StringRequest stringRequest;
    public static void RequestPost(Context mContext, final Map<String,String > params, String url, String tag, VolleyInterface vif){
        MyApplication.getRequestQueue().cancelAll(tag);
        stringRequest=new StringRequest(url,vif.loadingListener(),vif.errorListener()){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }
        };
        stringRequest.setTag(tag);
        MyApplication.getRequestQueue().add(stringRequest);
        MyApplication.getRequestQueue().start();
    };
}
