package com.example.notesmvvm.database

import androidx.lifecycle.LiveData
import com.example.notesmvvm.models.AppNote

interface DatabaseRepository {

    val allNotes: LiveData<List<AppNote>>
    suspend fun insert(note: AppNote, onSuccess:()->Unit)
    suspend fun delete(note: AppNote, onSuccess:()->Unit)
}