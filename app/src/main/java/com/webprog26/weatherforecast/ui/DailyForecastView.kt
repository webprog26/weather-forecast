package com.webprog26.weatherforecast.ui

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.webprog26.weatherforecast.R
import com.webprog26.weatherforecast.data.DailyForecastData
import com.webprog26.weatherforecast.databinding.DailyForecastLayoutBinding

private const val DAILY_FORECAST_ICON_BASE_URL = "https://developer.accuweather.com/sites/default/files/"

class DailyForecastView : LinearLayout {
    @JvmOverloads
    constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0)
            : super(context, attrs, defStyleAttr)

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int)
            : super(context, attrs, defStyleAttr, defStyleRes)

    private val binding : DailyForecastLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
            R.layout.daily_forecast_layout, this, true)

    fun populateWithData(dailyForecastData: DailyForecastData) {
        binding.tvDailyIconPhrase.text = dailyForecastData.iconPhraseDay
        binding.tvMaxMinTemp.text = context.getString(R.string.max_and_min_temp_text, dailyForecastData.maxTemp, dailyForecastData.minTemp)
        val iconFileName = if (dailyForecastData.iconDay < 10) {
            "0${dailyForecastData.iconDay}"
        } else {
            "${dailyForecastData.iconDay}"
        }
        Glide.with(this).load("$DAILY_FORECAST_ICON_BASE_URL$iconFileName-s.png").into(binding.ivDailyIcon)
    }
}