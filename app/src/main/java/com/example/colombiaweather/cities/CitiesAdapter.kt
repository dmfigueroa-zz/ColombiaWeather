package com.example.colombiaweather.cities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.colombiaweather.apiService.citiesList.City
import com.example.colombiaweather.databinding.FragmentCityCardBinding

class CitiesAdapter(val onClickListener: OnClickListener) : ListAdapter<City, CitiesAdapter.CityViewHolder>(DiffCallback) {
    class CityViewHolder(private var binding: FragmentCityCardBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(city: City) {
            binding.city = city
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback: DiffUtil.ItemCallback<City>() {
        override fun areItemsTheSame(oldItem: City, newItem: City): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: City, newItem: City): Boolean {
            return oldItem.cityId == newItem.cityId
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int ): CityViewHolder {
        return CityViewHolder(FragmentCityCardBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val city = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(city)
        }
        holder.bind(city)
    }

    class OnClickListener(val clickListener: (marsProperty: City) -> Unit) {
        fun onClick(city: City) = clickListener(city)
    }
}