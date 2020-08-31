package com.lucastomiati.freshfoodapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostsAdapter(val posts: ArrayList<String>) : RecyclerView.Adapter<PostsAdapter.ViewHolder>(){


    override fun getItemCount() = posts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = posts[position]
    }

    //ligação com o layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.layont_list_horizontal, parent, false)
        return ViewHolder(view)
    }

    //coloca os dados no layout
    class ViewHolder(itemView: View):  RecyclerView.ViewHolder(itemView){
        val name: TextView = itemView.findViewById(R.id.name)
    }

}
