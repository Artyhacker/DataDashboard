package com.dh.datadashboard;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by dh on 16-8-25.
 */
public class DataView extends View {
    public DataView(Context context) {
        this(context,null, 0);
    }
    public DataView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }
    public DataView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setBackgroundColor(Color.YELLOW);
    }
}
