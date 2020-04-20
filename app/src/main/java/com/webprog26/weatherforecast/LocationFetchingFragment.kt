package com.webprog26.weatherforecast

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.webprog26.weatherforecast.databinding.FragmentLocationFetchingBinding
import java.lang.IllegalStateException

/**
 * A simple [Fragment] subclass.
 */

class LocationFetchingFragment : Fragment() {

    private lateinit var binding: FragmentLocationFetchingBinding

    private var onLocationDataObtainedListener: OnLocationDataObtainedListener? = null

    interface OnLocationDataObtainedListener {
        fun onLocationDataObtained()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            onLocationDataObtainedListener = context as OnLocationDataObtainedListener
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_location_fetching, container, false
        )
        return binding.root
    }

    fun onCoordinatesReceived() {
        binding.progressBar.visibility = View.VISIBLE
        binding.tvMessage.visibility = View.VISIBLE
        binding.tvMessage.text = getString(R.string.detecting_user_location_text)
    }
}
