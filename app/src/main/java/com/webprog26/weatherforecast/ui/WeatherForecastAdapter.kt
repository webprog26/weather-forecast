package com.webprog26.weatherforecast.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.webprog26.weatherforecast.data.DailyForecastData
import com.webprog26.weatherforecast.databinding.DailyForecastViewBinding

private const val ITEM_VIEW_TYPE_DAILY_FORECAST = 0

class WeatherForecastAdapter(private val forecastItems: ArrayList<Any>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return if (forecastItems[position] is DailyForecastData) {
            ITEM_VIEW_TYPE_DAILY_FORECAST
        } else {
            -1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = DailyForecastViewBinding.inflate(LayoutInflater.from(parent.context))
        return DailyForecastViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return forecastItems.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as DailyForecastViewHolder).bind(forecastItems[position] as DailyForecastData)
    }

    private class DailyForecastViewHolder(val binding: DailyForecastViewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: DailyForecastData) {
            (binding.root as DailyForecastView).populateWithData(data)
        }
    }
}