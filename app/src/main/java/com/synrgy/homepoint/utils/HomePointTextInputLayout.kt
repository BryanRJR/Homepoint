package com.synrgy.homepoint.utils

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import com.google.android.material.textfield.TextInputLayout
import com.synrgy.homepoint.R

class HomePointTextInputLayout : TextInputLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        boxStrokeWidth = 0
        boxStrokeWidthFocused = 0

        setHintTextAppearance(R.style.TextLabel)
        hintTextColor = ColorStateList.valueOf(Color.parseColor("#6999B8"))
    }
}