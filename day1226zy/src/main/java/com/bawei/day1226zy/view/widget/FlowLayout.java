package com.bawei.day1226zy.view.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * author: 斛万珺
 * data: 2019/12/27 07:7:58
 * function:
 */
public class FlowLayout extends ViewGroup {
    int screenWid;

    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        screenWid=displayMetrics.widthPixels;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        int wSpace=30;
        int hSpace=20;
        int left=wSpace;
        int top=hSpace;
        int right=0;
        int bottom=0;

        int childCount = getChildCount();

        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            child.measure(0,0);
            int measuredWidth = child.getMeasuredWidth();
            int measuredHeight = child.getMeasuredHeight();
            right=left+measuredWidth;



            if (right>screenWid){

                left=wSpace;
                top=bottom+hSpace;
                right=left+measuredWidth;
            }

            bottom=top+measuredHeight;
            child.layout(left,top,right,bottom);
            left=right+wSpace;
        }

    }

    public  void addTag(String tag){

        TextView textView = new TextView(getContext());
        textView.setText(tag);
        textView.setTextColor(Color.RED);
        textView.setBackgroundColor(Color.BLUE);
        addView(textView);
    }

}
