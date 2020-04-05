package com.example.colombiaweather.city

import android.R
import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.colombiaweather.apiService.cityDays.Day
import com.example.colombiaweather.databinding.FragmentDayCardBinding


class ForecastAdapter(var list: List<Day>?): RecyclerView.Adapter<ForecastAdapter.ViewHolder>() {
    class ViewHolder(private var binding: FragmentDayCardBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindItems(data: Day) {
            binding.day = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(FragmentDayCardBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return if (list.isNullOrEmpty()) 0 else list!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        list?.get(position)?.let { holder.bindItems(it) }
    }
}