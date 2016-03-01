package com.example.lenovo.calculator;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * AutoSize
 *
 * @author: lenovo
 * @time: 2016/2/29 18:51
 */

public class AutoSize extends TextView{

    private static final float MIN_TEXT_SIZE = 0;
    private static final float MAX_TEXT_SIZE = 0;

    private Paint testPaint;

    private float minTextSize, maxTextSize;

    public AutoSize(Context context, AttributeSet attrs) {
        super(context, attrs);

        initialise();
    }


    private void initialise() {
        testPaint = new Paint();
        testPaint.set(this.getPaint());

        //当前字体大小
        maxTextSize = this.getTextSize();

        if (maxTextSize <= MIN_TEXT_SIZE ) {
            maxTextSize = MAX_TEXT_SIZE ;
        }

        minTextSize = MIN_TEXT_SIZE ;
    }

    /**
     * Re size the font so the specified text fits in the text box * assuming
     * the text box is the specified width.
     */
    private void refitText(String text, int textWidth) {
        if (textWidth > 0) {
            int availableWidth = textWidth - this.getPaddingLeft() - this.getPaddingRight();
            float trySize = maxTextSize;
            testPaint.setTextSize(trySize);
            while ((trySize > minTextSize) && (testPaint.measureText(text) > availableWidth))
            {
                trySize -= 1;
                if (trySize <= minTextSize) {
                    trySize = minTextSize;
                    break;
                }
                testPaint.setTextSize(trySize);
            }
            this.setTextSize(trySize);
        }
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int before, int after) {
        super.onTextChanged(text, start, before, after);
        refitText(text.toString(), this.getWidth());
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        if (w != oldw) {
            refitText(this.getText().toString(), w);
        }
    }

}
