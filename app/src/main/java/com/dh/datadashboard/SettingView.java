package com.dh.datadashboard;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by dh on 16-8-25.
 */
public class SettingView extends View {
    public SettingView(Context context) {
        this(context,null, 0);
    }
    public SettingView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }
    public SettingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setBackgroundColor(Color.RED);
    }
}
