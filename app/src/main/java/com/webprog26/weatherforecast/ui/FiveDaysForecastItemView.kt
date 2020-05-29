package com.webprog26.weatherforecast.ui

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.widget.LinearLayout
import com.webprog26.weatherforecast.R
import com.webprog26.weatherforecast.data.FiveDaysDailyForecastData
import com.webprog26.weatherforecast.databinding.FiveDaysForecastItemViewBinding
import com.webprog26.weatherforecast.databinding.HourlyForecastItemViewBinding
import com.webprog26.weatherforecast.getString
import com.webprog26.weatherforecast.loadIcon
import com.webprog26.weatherforecast.log
import java.text.SimpleDateFormat
import java.time.DateTimeException
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class FiveDaysForecastItemView : LinearLayout {

    private lateinit var binding: FiveDaysForecastItemViewBinding

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
        binding = FiveDaysForecastItemViewBinding.bind(this)
    }

    fun populateWithData(data: FiveDaysDailyForecastData) {

        log("date: ${data.date}")
        binding.tvDay.text = data.date
        loadIcon(data.iconDay, this, binding.ivIcon)
        binding.tvTemp.text = getString(R.string.max_and_min_temp_text, data.maxTemp, data.minTemp)
    }
}