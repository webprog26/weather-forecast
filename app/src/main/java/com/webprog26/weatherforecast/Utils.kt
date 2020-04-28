package com.webprog26.weatherforecast

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.StringRes
import com.bumptech.glide.Glide

fun ViewGroup.getString(@StringRes stringId: Int, alias: Float) : String {
    return context.getString(stringId, alias)
}

fun ViewGroup.getString(@StringRes stringId: Int, alias1: Float, alias2: Float) : String {
    return context.getString(stringId, alias1, alias2)
}

fun ViewGroup.getString(@StringRes stringId: Int, alias: String) : String {
    return context.getString(stringId, alias)
}

fun loadIcon(icon: Int, parent: View, target: ImageView) {
    val iconFileName = if (icon < 10) {
        "0${icon}"
    } else {
        "$icon"
    }
    Glide.with(parent)
        .load("https://developer.accuweather.com/sites/default/files/$iconFileName-s.png")
        .into(target)
}