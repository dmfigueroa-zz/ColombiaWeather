package com.example.colombiaweather

import android.R
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.colombiaweather.city.CityViewModel
import com.example.colombiaweather.city.CityViewModelFactory
import com.example.colombiaweather.city.ForecastAdapter
import com.example.colombiaweather.databinding.FragmentCityBinding


class CityFragment : Fragment() {

    lateinit var navController : NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }

    @SuppressLint("WrongConstant")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(activity).application
        val binding = FragmentCityBinding.inflate(inflater)
        binding.lifecycleOwner = this

        val city = CityFragmentArgs.fromBundle(arguments!!).selectetedCity



        val viewModelFactory = CityViewModelFactory(city, application)

        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(CityViewModel::class.java)
        binding.viewModel = viewModel

        viewModel.forecast.observe(viewLifecycleOwner, Observer {
            binding.days.layoutManager = LinearLayoutManager(application, LinearLayout.VERTICAL, false)
            binding.days.adapter = ForecastAdapter(it)
        })

        return binding.root
    }
}
