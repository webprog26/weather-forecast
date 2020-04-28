package com.webprog26.weatherforecast.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.webprog26.weatherforecast.R
import com.webprog26.weatherforecast.data.DailyForecastData
import com.webprog26.weatherforecast.data.HourlyForecastDataWrapper
import com.webprog26.weatherforecast.databinding.DailyForecastViewBinding
import com.webprog26.weatherforecast.databinding.HourlyForecastViewBinding

private const val ITEM_VIEW_TYPE_DAILY_FORECAST = 0
private const val ITEM_VIEW_TYPE_HOURLY_FORECAST = 1

class WeatherForecastAdapter() :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val forecastItems: ArrayList<Any> = arrayListOf(Any(), Any())

    override fun getItemViewType(position: Int): Int {
        return when {
            forecastItems[position] is DailyForecastData -> {
                ITEM_VIEW_TYPE_DAILY_FORECAST
            }
            forecastItems[position] is HourlyForecastDataWrapper -> {
                ITEM_VIEW_TYPE_HOURLY_FORECAST
            }
            else -> {
                -1
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_VIEW_TYPE_DAILY_FORECAST -> {
                val binding = DataBindingUtil.getBinding<DailyForecastViewBinding>(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.daily_forecast_view, parent, false)
                )
                DailyForecastViewHolder(binding!!)
            }
            else -> {
                val binding = DataBindingUtil.getBinding<HourlyForecastViewBinding>(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.hourly_forecast_view, parent, false)
                )
                HourlyForecastViewHolder(binding!!)
            }
        }
    }

    override fun getItemCount(): Int {
        return forecastItems.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            ITEM_VIEW_TYPE_DAILY_FORECAST -> {
                if (forecastItems[position] is DailyForecastData) {
                    (holder as DailyForecastViewHolder).bind(forecastItems[position] as DailyForecastData)
                }
            }
            else -> {
                if (forecastItems[position] is HourlyForecastDataWrapper) {
                    (holder as HourlyForecastViewHolder).bind(forecastItems[position] as HourlyForecastDataWrapper)
                }
            }
        }
    }

    fun updateDailyForecastData(data: DailyForecastData) {
       updateForecastData(ITEM_VIEW_TYPE_DAILY_FORECAST, data)
    }

    fun updateHourlyForecastData(data: HourlyForecastDataWrapper) {
        updateForecastData(ITEM_VIEW_TYPE_HOURLY_FORECAST, data)
    }

    private fun updateForecastData(index: Int, data: Any) {
            forecastItems[index] = data
            notifyItemChanged(index)
    }

    private class DailyForecastViewHolder(val binding: DailyForecastViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: DailyForecastData) {
            (binding.root as DailyForecastView).populateWithData(data)
        }
    }

    private class HourlyForecastViewHolder(val binding: HourlyForecastViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: HourlyForecastDataWrapper) {
            (binding.root as HourlyForecastView).populateWithData(data)
        }
    }
}