package com.example.notesmvvm.database.room

import androidx.lifecycle.LiveData
import com.example.notesmvvm.database.DatabaseRepository
import com.example.notesmvvm.models.AppNote

class AppRoomRepositoryImpl(private val appRoomDao: AppRoomDao): DatabaseRepository {
    override val allNotes: LiveData<List<AppNote>>
        get() = appRoomDao.getAllNotes()

    override suspend fun insert(note: AppNote, onSuccess: () -> Unit) {
        appRoomDao.insert(note)
    }

    override suspend fun delete(note: AppNote, onSuccess: () -> Unit) {
        appRoomDao.delete(note)
    }
}