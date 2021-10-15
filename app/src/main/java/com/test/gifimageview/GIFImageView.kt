package com.test.gifimageview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Movie
import android.graphics.drawable.AnimatedImageDrawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

/**
 * @Author: duke
 * @DateTime: 2021-10-15 18:14:06
 * @Description: 功能描述：Gif ImageView
 */
class GIFImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    private var gifDrawable: AnimatedImageDrawable? = null
    private var autoGIFSize: Boolean = false

    fun setGIFFromAssets(assetFileName: String) {
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.P) {
            return
        }
        val stream = resources?.assets?.open(assetFileName)
        val tempDrawable = AnimatedImageDrawable.createFromStream(stream, null)
        gifDrawable = (tempDrawable as? AnimatedImageDrawable?)
        if (gifDrawable == null) {
            return
        }
        gifDrawable?.start()
        invalidate()
    }

    fun setAutoGIFSize(isAuto: Boolean) {
        autoGIFSize = isAuto
        requestLayout()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        if (gifDrawable == null) {
            return
        }
        val gifWidth = gifDrawable?.intrinsicWidth ?: 0
        val gifHeight = gifDrawable?.intrinsicHeight ?: 0
        if (gifWidth == 0 || gifHeight == 0) {
            return
        }
        if (!autoGIFSize) {
            return
        }
        val widthSpec = MeasureSpec.makeMeasureSpec(gifWidth, MeasureSpec.EXACTLY)
        val heightSpec = MeasureSpec.makeMeasureSpec(gifHeight, MeasureSpec.EXACTLY)
        setMeasuredDimension(widthSpec, heightSpec)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        playGIF(canvas)
    }

    private fun playGIF(canvas: Canvas?) {
        if (canvas == null || gifDrawable == null) {
            return
        }
        gifDrawable?.draw(canvas)
    }

}
