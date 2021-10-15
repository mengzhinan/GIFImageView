package com.test.gifimageview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

/**
 * @Author: duke
 * @DateTime: 2021-10-15 18:14:06
 * @Description: 功能描述：
 */
public class GIFImageView extends AppCompatImageView {

    public GIFImageView(Context context) {
        this(context, null);
    }

    public GIFImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GIFImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        Log.e("", "");
    }

}
