package com.example.colombiaweather

import android.os.Build
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.colombiaweather.apiService.citiesList.City
import com.example.colombiaweather.cities.CitiesAdapter
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt


@BindingAdapter("listCities")
fun bindRecyclerViewCities(recyclerView: RecyclerView, data: List<City>?) {
    val adapter = recyclerView.adapter as CitiesAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = it.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context).load(imgUri)
            .apply(RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image))
            .into(imgView)
    }
}

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
@BindingAdapter("bindServerDate")
fun bindServerDate(textView: TextView, date: String) {
    val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH)
    val parsedDate = sdf.parse(date)
    val print = SimpleDateFormat("d MMM yyyy h aa", Locale.forLanguageTag("es"))
    textView.text = print.format(parsedDate)
}

@BindingAdapter("displayTemp")
fun displayTemp(textView: TextView, temperature: Double) {
    textView.text = "${temperature.roundToInt()}°"
}