package com.example.lenovo.calculator;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * MarqueeTextView
 *
 * @author: lenovo
 * @time: 2016/3/4 19:13
 */

public class MarqueeTextView extends TextView{
    public MarqueeTextView(Context context) {
        super(context);
    }

    public MarqueeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MarqueeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean isFocused() {
        return true;
    }
}
