package com.webprog26.weatherforecast.ui

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.widget.LinearLayout
import com.webprog26.weatherforecast.R
import com.webprog26.weatherforecast.data.HourlyForecastData
import com.webprog26.weatherforecast.databinding.HourlyForecastItemViewBinding
import com.webprog26.weatherforecast.getString
import com.webprog26.weatherforecast.loadIcon

class HourlyForecastItemView : LinearLayout {

    private lateinit var binding: HourlyForecastItemViewBinding

    @JvmOverloads
    constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
    )
            : super(context, attrs, defStyleAttr)

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    )
            : super(context, attrs, defStyleAttr)


    override fun onFinishInflate() {
        super.onFinishInflate()
        binding = HourlyForecastItemViewBinding.bind(this)
    }

    fun populateWithData(data: HourlyForecastData) {
        binding.tvHourlyTime.text = data.time
        binding.tvHourlyTemp.text = getString(R.string.hourly_temp, data.temp)
        loadIcon(data.icon, this, binding.ivHourlyIcon)
    }
}