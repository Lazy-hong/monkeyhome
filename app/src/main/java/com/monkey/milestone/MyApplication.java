package com.monkey.milestone;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Administrator on 2016/3/7.
 */
public class MyApplication extends Application {
    public static RequestQueue mRequestQueue;
    @Override
    public void onCreate() {
        super.onCreate();
        mRequestQueue=Volley.newRequestQueue(getApplicationContext());

    }
    public static RequestQueue getRequestQueue(){
        return mRequestQueue;

    }
}
