package com.aniruddhapimple.design_system

import android.content.Context
import android.util.TypedValue
import androidx.annotation.*
import androidx.core.content.ContextCompat

private const val RESOURCE_TYPE_STYLE = "style"
private const val RESOURCE_TYPE_DIMENSION = "dimen"
private const val RESOURCE_TYPE_COLOR = "color"

/**Return the theme defined style resource Id for the provided attribute Id.
 * E.g. context.themeStyleResId(R.attr.typographyStyleHighlight) for the default theme will
 * return R.style.Pds_Typography_Highlight, as defined in the default theme for the attribute
 * typographyStyleHighlight.
 */
@StyleRes
fun Context.themeStyleResId(@AttrRes attrRes: Int) = themeResourceId(attrRes, RESOURCE_TYPE_STYLE)

/**Return the theme defined dimen resource Id for the provided attribute Id.
 * E.g. context.themeDimensionResId(R.attr.spacingDefault) for the default theme will
 * return R.dimen.spacing_default, as defined in the default theme for the attribute
 * spacingDefault.
 */
@DimenRes
fun Context.themeDimensionResId(@AttrRes attrRes: Int) = themeResourceId(attrRes, RESOURCE_TYPE_DIMENSION)

/**Return the theme defined color resource Id for the provided attribute Id.
 * E.g. context.themeColorResId(R.attr.colorTypographyDefault) for the default theme will
 * return R.color.gray_0, as defined in the default theme for the attribute
 * colorTypographyDefault.
 */
@ColorRes
fun Context.themeColorResId(@AttrRes attrRes: Int) = themeResourceId(attrRes, RESOURCE_TYPE_COLOR)

fun Context.getThemeSpacing(@AttrRes attrRes: Int): Int {
    return this.resources.getDimensionPixelSize(themeDimensionResId(attrRes))
}

@ColorInt
fun Context.getThemeColor(@AttrRes attrRes: Int): Int {
    return ContextCompat.getColor(this, themeColorResId(attrRes))
}

@AnyRes
private fun Context.themeResourceId(@AttrRes attrRes: Int, expectedResourceType: String): Int {
    val typedValue = TypedValue()
    theme.resolveAttribute(attrRes, typedValue, true)
    val resId = typedValue.resourceId
    val resourceType = resources.getResourceTypeName(resId)
    if (expectedResourceType != resourceType) {
        val attributeName = resources.getResourceName(attrRes)
        throw IllegalArgumentException(
            "No resource of type \"$expectedResourceType\" is defined in the current theme " +
                    "for the provided attribute $attributeName." +
                    "\nPlease check if the attribute in the current theme refers to a " +
                    "resource of type $expectedResourceType."
        )
    }
    return resId
}
