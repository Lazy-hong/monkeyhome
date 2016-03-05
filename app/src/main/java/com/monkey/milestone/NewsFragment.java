package com.monkey.milestone;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.monkey.home.R;

/**
 * Created by THINK on 2016/3/5.
 */
public class NewsFragment extends Fragment{
    private String mTitle = "Default";
    public static final String TITLE = "title";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_monkey,null);
        if(getArguments()!=null){
            mTitle=getArguments().getString(TITLE);
            ((TextView)view.findViewById(R.id.tv_conent)).setText(mTitle);
        }
        return view;
    }
}
