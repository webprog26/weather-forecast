package com.webprog26.weatherforecast.ui

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.webprog26.weatherforecast.R
import com.webprog26.weatherforecast.data.FiveDaysDailyForecastDataWrapper
import com.webprog26.weatherforecast.databinding.FiveDaysForecastViewBinding
import com.webprog26.weatherforecast.log

class FiveDaysForecastView : CardView {

    private lateinit var binding: FiveDaysForecastViewBinding

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
        binding = FiveDaysForecastViewBinding.bind(this)
    }

    fun populateWithData(dataWrapper: FiveDaysDailyForecastDataWrapper) {
        for (data in dataWrapper.fiveDaysDailyForecastDataList) {
            log("data: $data")
        }
        binding.container.removeAllViews()
        for (data in dataWrapper.fiveDaysDailyForecastDataList) {
            data?.let {
                val itemView = LayoutInflater.from(context)
                    .inflate(R.layout.five_days_forecast_item_view, this, false) as FiveDaysForecastItemView
                itemView.populateWithData(data)
                binding.container.addView(itemView)
            }
        }
    }
}