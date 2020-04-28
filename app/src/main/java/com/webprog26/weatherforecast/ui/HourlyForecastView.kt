package com.webprog26.weatherforecast.ui

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.cardview.widget.CardView
import com.webprog26.weatherforecast.R
import com.webprog26.weatherforecast.data.HourlyForecastDataWrapper
import com.webprog26.weatherforecast.databinding.HourlyForecastViewBinding

class HourlyForecastView : CardView {

    private lateinit var binding: HourlyForecastViewBinding

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
        binding = HourlyForecastViewBinding.bind(this)
    }

    fun populateWithData(hourlyForecastDataWrapper: HourlyForecastDataWrapper) {
        binding.hourlyForecastItemsContainer.removeAllViews()
        for (data in hourlyForecastDataWrapper.hourlyForecastDataList) {
            data?.let {
                val itemView = LayoutInflater.from(context)
                    .inflate(R.layout.hourly_forecast_item_view, this, false) as HourlyForecastItemView
                itemView.populateWithData(data)
                binding.hourlyForecastItemsContainer.addView(itemView)
            }
        }
    }
}