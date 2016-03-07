package com.monkey.util.volley;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;

/**
 * Created by Administrator on 2016/3/7.
 */
public abstract  class VolleyInterface {
    public static Listener mListener;
    public static ErrorListener mErrorListener;
    public Context mContext;
    public VolleyInterface(Context context, Listener<String> listener, ErrorListener errorListener){
        this.mContext=context;
        this.mListener=listener;
        this.mErrorListener=errorListener;
    }

    public  Listener<String> loadingListener(){
        mListener=new Listener<String>() {
            @Override
            public void onResponse(String response) {
                onSuccess(response);
            }
        };
        return  mListener;
    }
    public  ErrorListener errorListener(){
       mErrorListener=new ErrorListener() {
           @Override
           public void onErrorResponse(VolleyError error) {
               onError(error);
           }
       };
        return  mErrorListener;
    }
    public abstract void onSuccess(String response);
    public abstract void onError(VolleyError error);

}
