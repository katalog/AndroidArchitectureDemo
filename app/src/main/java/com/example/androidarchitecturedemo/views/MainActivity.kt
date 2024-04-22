package com.example.androidarchitecturedemo.views

import EarthquakeAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidarchitecturedemo.databinding.ActivityMainBinding
import com.example.androidarchitecturedemo.viewmodels.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var vm: MainActivityViewModel
    private lateinit var adapter: EarthquakeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vm = ViewModelProvider(this)[MainActivityViewModel::class.java]

        binding.recycler.layoutManager = LinearLayoutManager(this)
        adapter = EarthquakeAdapter()
        binding.recycler.adapter = adapter

        vm.eqItems.observe(this) { it ->
            adapter.updateData(it)
        }

        vm.fetchDemoData()
    }
}