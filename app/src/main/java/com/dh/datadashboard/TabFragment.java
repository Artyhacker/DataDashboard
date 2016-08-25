package com.dh.datadashboard;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by dh on 16-8-24.
 */
public class TabFragment extends Fragment {


    private String mTitle = "Default";
    public static final String TITLE = "title";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if(getArguments() != null){
            mTitle = getArguments().getString(TITLE);
        }

        TextView tv = new TextView(getActivity());
        tv.setTextSize(20);
        tv.setBackgroundColor(Color.parseColor("#ffffffff"));
        tv.setText(mTitle);
        tv.setGravity(Gravity.CENTER);
        return tv;
    }

    /*
    private DashboardView mDashboardView;
    private DataView mDataView;
    private SettingView mSettingView;

    public static final String ITEM = "item";
    private String mItem = "Default";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if(getArguments() != null){
            mItem = getArguments().getString("0");
        }
        if(ITEM == "0")
            return mDashboardView;
        else if(ITEM == "1")
            return mDataView;
        else
            return mSettingView;
    }*/
}
