package com.example.notesmvvm.screens.main

import android.view.TextureView
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notesmvvm.R
import com.example.notesmvvm.models.AppNote

class MainHolder(view: View): RecyclerView.ViewHolder(view) {

    val name=view.findViewById<TextView>(R.id.note_name)
    val text=view.findViewById<TextView>(R.id.note_text)

    fun bind(note: AppNote){
        name.text=note.name
        text.text=note.text
    }
}