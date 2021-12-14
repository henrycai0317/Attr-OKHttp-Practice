package com.example.viewwithattrpractice;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class ViewWithAttrs extends View {
    public ViewWithAttrs(Context context) {
        super(context);
    }

    public ViewWithAttrs(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewWithAttrs(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ViewWithAttrs(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
