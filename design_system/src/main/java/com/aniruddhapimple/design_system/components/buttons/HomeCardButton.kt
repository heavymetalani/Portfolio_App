package com.aniruddhapimple.design_system.components.buttons

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import androidx.appcompat.view.ContextThemeWrapper
import androidx.appcompat.widget.AppCompatTextView
import com.aniruddhapimple.design_system.R
import com.aniruddhapimple.design_system.getThemeColor
import com.aniruddhapimple.design_system.getThemeSpacing
import com.aniruddhapimple.design_system.themeStyleResId

class HomeCardButton @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : AppCompatTextView(ContextThemeWrapper(context, context.themeStyleResId(R.attr.typographyStyleButton)), attrs, defStyleAttr) {
    init {
        val spacing = context.getThemeSpacing(R.attr.spacingDefault)
        setPadding(spacing, spacing, spacing, spacing)
        setTextColor(context.getThemeColor(R.attr.colorTypographyDefaultInverted))
        gravity = Gravity.RIGHT
        isAllCaps = true
    }
}