package com.example.currentweather.fragments.today

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.currentweather.databinding.TodayFragmentBinding
import com.example.currentweather.utils.ActivityLifeCycleObserver

class TodayFragment : Fragment() {

    companion object {
        fun newInstance() = TodayFragment()
    }

    private val viewModel: TodayViewModel by activityViewModels()
    private var _binding: TodayFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = TodayFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity?.lifecycle?.addObserver(ActivityLifeCycleObserver {
            viewModel.todayWeatherResponse.observe(this, { TodayWeatherResponse ->
                binding.apply {
                    temperature.text = TodayWeatherResponse.temperature
                    description.text = TodayWeatherResponse.description
                    wind.text = TodayWeatherResponse.wind
                }
            })
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}