package com.aniruddhapimple.design_system.components.typography

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.view.ContextThemeWrapper
import androidx.appcompat.widget.AppCompatTextView
import com.aniruddhapimple.design_system.R
import com.aniruddhapimple.design_system.getThemeColor
import com.aniruddhapimple.design_system.getThemeSpacing
import com.aniruddhapimple.design_system.themeStyleResId

class BodyTextView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : AppCompatTextView(ContextThemeWrapper(context, context.themeStyleResId(R.attr.typographyStyleBody)), attrs, defStyleAttr) {
    init {
        val horizontalSpacing = context.getThemeSpacing(R.attr.spacingDefault)
        val verticalSpacing = context.getThemeSpacing(R.attr.spacingTight)
        setPadding(horizontalSpacing, verticalSpacing, horizontalSpacing, verticalSpacing)
        setTextColor(context.getThemeColor(R.attr.colorTypographyDefault))
    }
}
