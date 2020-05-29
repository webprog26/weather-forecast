package com.webprog26.weatherforecast

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.webprog26.weatherforecast.data.DailyForecastData
import com.webprog26.weatherforecast.data.FiveDaysDailyForecastDataWrapper
import com.webprog26.weatherforecast.data.HourlyForecastDataWrapper
import com.webprog26.weatherforecast.databinding.FragmentForecastBinding
import com.webprog26.weatherforecast.ui.WeatherForecastAdapter


/**
 * A simple [Fragment] subclass.
 */
class ForecastFragment : Fragment() {

    private lateinit var binding : FragmentForecastBinding
    private val adapter = WeatherForecastAdapter()

    private var onForecastUpdateRequestedListener : OnForecastUpdateRequestedListener? = null

    interface OnForecastUpdateRequestedListener {
        fun onForecastUpdateRequested()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.app_menu_settings -> {
                log("App menu \"Settings\" clicked")
                true
            }
            R.id.app_menu_manage_cities -> {
                log("App menu \"Manage cities\" clicked")
                true
            }
            else -> return super.onOptionsItemSelected(item)

        }
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
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.adapter = adapter
        requestForecastUpdate()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.app_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    fun setDailyForecastData(dailyForecastData: DailyForecastData) {
        binding.progressBar.visibility = View.GONE
        binding.recyclerView.visibility = View.VISIBLE
        adapter.updateDailyForecastData(dailyForecastData)
        binding.swipeRefresh.isRefreshing.let {
            if (it) {
                binding.swipeRefresh.isRefreshing = false
            }
        }
    }

    fun setHourlyForecastData(hourlyForecastDataWrapper: HourlyForecastDataWrapper) {
        adapter.updateHourlyForecastData(hourlyForecastDataWrapper)
    }

    fun setFiveDaysDailyForecastData(fiveDaysDailyForecastDataWrapper: FiveDaysDailyForecastDataWrapper) {
        log("setFiveDaysDailyForecastData")
        adapter.updateFiveDaysForecastData(fiveDaysDailyForecastDataWrapper)
    }

    private fun requestForecastUpdate() {
        onForecastUpdateRequestedListener?.onForecastUpdateRequested()
    }
}
