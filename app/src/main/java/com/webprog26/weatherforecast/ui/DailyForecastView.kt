package com.webprog26.weatherforecast.ui

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import androidx.cardview.widget.CardView
import com.webprog26.weatherforecast.R
import com.webprog26.weatherforecast.data.DailyForecastData
import com.webprog26.weatherforecast.databinding.DailyForecastViewBinding
import com.webprog26.weatherforecast.getString
import com.webprog26.weatherforecast.loadIcon
import java.text.SimpleDateFormat
import java.util.*

class DailyForecastView : CardView {

    private lateinit var binding: DailyForecastViewBinding

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
            : super(context, attrs, defStyleAttr)

    override fun onFinishInflate() {
        super.onFinishInflate()
        binding = DailyForecastViewBinding.bind(this)
    }

    fun populateWithData(dailyForecastData: DailyForecastData) {
        binding.tvDailyIconPhrase.text = dailyForecastData.iconPhraseDay
        binding.tvMaxMinTemp.text = getString(R.string.max_and_min_temp_text, dailyForecastData.maxTemp, dailyForecastData.minTemp)
        binding.tvCityName.text = dailyForecastData.cityName
        binding.tvUpdatedAt.text = getString(R.string.forecast_updated_at,
            SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date(System.currentTimeMillis())))

        loadIcon(dailyForecastData.iconDay, this, binding.ivDailyIcon)
    }
}
