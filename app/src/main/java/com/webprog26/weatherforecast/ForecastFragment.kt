package com.webprog26.weatherforecast

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.webprog26.weatherforecast.data.DailyForecastData
import com.webprog26.weatherforecast.databinding.FragmentForecastBinding
import com.webprog26.weatherforecast.ui.WeatherForecastAdapter


/**
 * A simple [Fragment] subclass.
 */
class ForecastFragment : Fragment() {

    private lateinit var binding : FragmentForecastBinding

    private var onForecastUpdateRequestedListener : OnForecastUpdateRequestedListener? = null

    interface OnForecastUpdateRequestedListener {
        fun onForecastUpdateRequested()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            onForecastUpdateRequestedListener = context as OnForecastUpdateRequestedListener
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        log("${javaClass.simpleName} onCreateView")
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_forecast, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.swipeRefresh.setOnRefreshListener {
            requestForecastUpdate()
        }
        requestForecastUpdate()
    }

    fun setDailyForecastData(dailyForecastData: DailyForecastData) {
        log("${javaClass.simpleName} setDailyForecastData(): $dailyForecastData")
        updateDailyForecast(dailyForecastData)
    }

    private fun updateDailyForecast(dailyForecastData: DailyForecastData) {
        binding.progressBar.visibility = View.GONE
        binding.recyclerView.visibility = View.VISIBLE
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.adapter = WeatherForecastAdapter(arrayListOf(dailyForecastData))

        binding.swipeRefresh.isRefreshing.let {
            if (it) {
                binding.swipeRefresh.isRefreshing = false
            }
        }
    }

    private fun requestForecastUpdate() {
        onForecastUpdateRequestedListener?.onForecastUpdateRequested()
    }
}
