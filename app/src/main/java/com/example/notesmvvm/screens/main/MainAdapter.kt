package com.example.notesmvvm.screens.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notesmvvm.R
import com.example.notesmvvm.models.AppNote

class MainAdapter: RecyclerView.Adapter<MainHolder>() {

    private var noteList= emptyList<AppNote>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.note_item,parent,false)
        return MainHolder(view)
    }

    override fun getItemCount(): Int = noteList.size

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bind(noteList[position])
    }


    fun setList(list: List<AppNote>){
        noteList=list
        notifyDataSetChanged()
    }
}