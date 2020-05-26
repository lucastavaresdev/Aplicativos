package com.lucastomiati.bin2dec.view.componentes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.lucastomiati.bin2dec.R
import com.lucastomiati.bin2dec.databinding.ListItemBinding
import com.lucastomiati.bin2dec.service.Model.Conversao


class RecyclerViewAdapter(private  val conversoesList: List<Conversao>) :
    RecyclerView.Adapter<myViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return myViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return conversoesList.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.bind(conversoesList[position])
    }
}

class myViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(binario: Conversao){
        binding.binario.text = binario.binario.toString()
        binding.decimal.text = binario.decimal.toString()
    }
}