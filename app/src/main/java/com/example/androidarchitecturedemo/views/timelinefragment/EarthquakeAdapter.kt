package com.example.androidarchitecturedemo.views.timelinefragment

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidarchitecturedemo.databinding.RvItemEarthquakeBinding
import com.example.data.model.EarthquakeDto
import com.example.data.model.Feature
import java.text.SimpleDateFormat
import java.util.Locale

class EarthquakeAdapter(): RecyclerView.Adapter<EarthquakeAdapter.UserHolder>() {
    val datalist = mutableListOf<Feature>()

    class UserHolder(val binding: RvItemEarthquakeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Feature) {
            binding.tvTitle.text = item.properties.title
            binding.tvMag.text = item.properties.time.toString()
            binding.tvPlace.text = item.geometry.coordinates.toString()

            val simpleDateFormat = SimpleDateFormat("dd MMMM yyyy, HH:mm:ss", Locale.ENGLISH)
            binding.tvMag.text = simpleDateFormat.format(item.properties.time)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(eqList: EarthquakeDto) {
        datalist.clear()
        eqList.features.forEach {
            datalist.add(it)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val binding = RvItemEarthquakeBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return UserHolder(binding)
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.bind(datalist[position])
    }

    override fun getItemCount(): Int {
        return datalist.size
    }
}
