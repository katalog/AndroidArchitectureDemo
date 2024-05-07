package com.example.androidarchitecturedemo.views

import com.example.androidarchitecturedemo.views.timelinefragment.EarthquakeAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.androidarchitecturedemo.databinding.ActivityMainBinding
import com.example.androidarchitecturedemo.viewmodels.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var vm: MainActivityViewModel
    private val adapter = EarthquakeAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vm = ViewModelProvider(this)[MainActivityViewModel::class.java]

        binding.recycler.adapter = adapter

        vm.eqItems.observe(this) { it ->
            adapter.updateData(it)
        }

        vm.fetchDemoData()
    }
}