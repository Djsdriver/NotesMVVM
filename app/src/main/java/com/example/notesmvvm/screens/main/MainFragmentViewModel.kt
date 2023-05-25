package com.example.notesmvvm.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.notesmvvm.utilits.REPOSITORY

class MainFragmentViewModel(application: Application): AndroidViewModel(application) {
    val allNotes= REPOSITORY.allNotes


}