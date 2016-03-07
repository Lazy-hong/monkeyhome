package com.monkey.milestone;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.monkey.home.R;
import com.monkey.util.volley.BitmapCache;
import com.monkey.util.volley.VolleyInterface;
import com.monkey.util.volley.VolleyRequest;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by lazy-hong on 2016/3/5.
 */
public class MonkeyFragment extends Fragment {
    private String mTitle = "Default";
    public static final String TITLE = "title";
    NetworkImageView network_imageview;
    ImageView imageview;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_monkey,null);
        if(getArguments()!=null){
            mTitle=getArguments().getString(TITLE);
            ((TextView)view.findViewById(R.id.tv_conent)).setText(mTitle);
        }
        String url="https://www.baidu.com/img/bdlogo.png";
        network_imageview= (NetworkImageView) view.findViewById(R.id.network_imageview);
        imageview= (ImageView) view.findViewById(R.id.imageview);

//        ImageRequest imageRequest=new ImageRequest(url, new Response.Listener<Bitmap>() {
//            @Override
//            public void onResponse(Bitmap response) {
//                imageview.setImageBitmap(response);
//            }
//        },  0, 0,ImageView.ScaleType.CENTER, Bitmap.Config.RGB_565, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                imageview.setImageResource(R.mipmap.monkey_house);
//            }
//        });
//
//        MyApplication.getRequestQueue().add(imageRequest);
        ImageLoader loader=new ImageLoader(MyApplication.getRequestQueue(),new BitmapCache());
        ImageLoader.ImageListener imageListener=ImageLoader.getImageListener(imageview,R.mipmap.monkey_house,R.mipmap.monkey_house);
        loader.get(url,imageListener,0,0,ImageView.ScaleType.CENTER);
        return view;
    }
    private void testPost(){
        String url="";
        Map<String,String > params=new HashMap<>();
        params=new HashMap<>();
        VolleyRequest.RequestPost(getActivity(),params,url,"123",new VolleyInterface(getActivity(),VolleyInterface.mListener,VolleyInterface.mErrorListener){

            @Override
            public void onSuccess(String response) {

            }

            @Override
            public void onError(VolleyError error) {

            }
        });
    }
}
