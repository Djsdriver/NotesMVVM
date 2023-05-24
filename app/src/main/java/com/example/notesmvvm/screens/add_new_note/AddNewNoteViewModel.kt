package com.example.notesmvvm.screens.add_new_note

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesmvvm.models.AppNote
import com.example.notesmvvm.utilits.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class AddNewNoteViewModel(application: Application): AndroidViewModel(application) {
    fun insert(note:AppNote, onSuccess:()-> Unit) {
        viewModelScope.launch {
            REPOSITORY.insert(note){
                onSuccess()
            }
        }
    }



}