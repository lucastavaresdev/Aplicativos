package com.lucastomiati.bin2dec.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.lucastomiati.bin2dec.R
import com.lucastomiati.bin2dec.databinding.HomeBinding
import com.lucastomiati.bin2dec.service.db.BinarioDataBase
import com.lucastomiati.bin2dec.service.db.BinarioRepository
import com.lucastomiati.bin2dec.service.db.BinarioViewModelFactory
import com.lucastomiati.bin2dec.service.viewmodel.HomeViewModel
import com.lucastomiati.bin2dec.view.componentes.RecyclerViewAdapter
import kotlinx.android.synthetic.main.home.*


class Home() : AppCompatActivity() {
    private lateinit var binding: HomeBinding
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.home)

        val dao = BinarioDataBase.getInstance(application).binarioDao
        val repository = BinarioRepository(dao)
        val factory = BinarioViewModelFactory(repository)

         homeViewModel = ViewModelProvider(this, factory).get(HomeViewModel::class.java)

        binding.myhomeViewModel = homeViewModel
        binding.lifecycleOwner = this


        initRecyclerView()
    }

    private fun initRecyclerView(){
        binding.lista.layoutManager = LinearLayoutManager(this)
        displaySubscribersList()
    }

    private fun displaySubscribersList(){
        homeViewModel.conversoes.observe(this, Observer {
            binding.lista.adapter = RecyclerViewAdapter(it)
        })
//        lista.subscribers.observe(this, Observer {
//            Log.i("MYTAG", it.toString())
//            binding.subscriberRecyclerView.adapter = MyRecyclerViewAdapter(
//                it, {selectedItem:Subscriber -> listItemClicked(selectedItem)})
//         })
    }
}


