package com.digital.demopincode

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.TextView

class CustomTextView : TextView {
    var colorRes: Int = Color.parseColor("#CED6DE")
    private val paint = Paint()

    init {
        paint.color = colorRes
        paint.style = Paint.Style.FILL
    }

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attr: AttributeSet?) : this(context, attr, 0)
    constructor(context: Context, attr: AttributeSet?, defStyleAttr: Int) : super(context, attr, defStyleAttr)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (text.isNullOrEmpty()) {
            drawFaceBackground(canvas)
        }
    }

    private fun drawFaceBackground(canvas: Canvas) {
        canvas.drawCircle(width / 2f, height / 2f, width / 10f, paint)
    }
}