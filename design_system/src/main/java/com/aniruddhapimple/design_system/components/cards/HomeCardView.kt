package com.aniruddhapimple.design_system.components.cards

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import com.aniruddhapimple.design_system.R
import com.aniruddhapimple.design_system.components.buttons.HomeCardButton
import com.aniruddhapimple.design_system.components.containers.ElevatedCardContainer
import com.aniruddhapimple.design_system.components.typography.BodyTextView
import com.aniruddhapimple.design_system.components.typography.PageHeaderTextView
import com.aniruddhapimple.design_system.getThemeColor

class HomeCardView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : ElevatedCardContainer(context, attrs, defStyleAttr) {
    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.HomeCardView)
        val title = typedArray.getString(R.styleable.HomeCardView_title)
        val description = typedArray.getString(R.styleable.HomeCardView_description)
        val callToAction = typedArray.getString(R.styleable.HomeCardView_callToAction)
        val buttonType = typedArray.getString(R.styleable.HomeCardView_buttonType)
//        val imageResId = typedArray.getResourceId(R.styleable.HomeCardView_image, 0)
        typedArray.recycle()
        initialize(title ?: "", description ?: "", callToAction ?: "", buttonType ?: "")
    }

    private fun initialize(title: String, description: String, callToAction: String, buttonType : String) {
        val linearLayout = LinearLayout(context)
        linearLayout.orientation = LinearLayout.VERTICAL
        val layoutParams = ViewGroup.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
        linearLayout.layoutParams = layoutParams
        linearLayout.addView(createTitleTextView(title))
        linearLayout.addView(createDescriptionTextView(description))
        if(callToAction.isNotEmpty()){
            linearLayout.addView(createCTATextView(callToAction, buttonType))
        }
        this.addView(linearLayout)
    }

    private fun createTitleTextView(title: String): View {
        val titleTextView = PageHeaderTextView(context)
        val layoutParamsTitle = ViewGroup.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
        titleTextView.layoutParams = layoutParamsTitle
        titleTextView.text = title
        titleTextView.gravity = Gravity.CENTER_HORIZONTAL
        return titleTextView
    }

    private fun createDescriptionTextView(description: String): View {
        val descriptionTextView = BodyTextView(context)
        val layoutParamsDescription = ViewGroup.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
        descriptionTextView.layoutParams = layoutParamsDescription
        descriptionTextView.text = description
        descriptionTextView.gravity = Gravity.CENTER_HORIZONTAL
        return descriptionTextView
    }

    @SuppressLint("RtlHardcoded")
    private fun createCTATextView(callToAction: String, buttonType: String): View {
        val callToActionTextView = HomeCardButton(context)
        val layoutParamsCTA = ViewGroup.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
        callToActionTextView.layoutParams = layoutParamsCTA
        callToActionTextView.text = callToAction
        callToActionTextView.setBackgroundColor(context.getThemeColor((R.attr.colorBackgroundAlternate)))

        if(buttonType=="notification"){
            callToActionTextView.id = R.id.notificationButton
        } else if (buttonType=="animation"){
            callToActionTextView.id = R.id.animationButton
        }
        return callToActionTextView
    }
}
