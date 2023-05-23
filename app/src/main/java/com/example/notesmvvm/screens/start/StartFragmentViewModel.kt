package com.example.notesmvvm.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.notesmvvm.database.room.AppRoomDatabase
import com.example.notesmvvm.database.room.AppRoomRepositoryImpl
import com.example.notesmvvm.utilits.REPOSITORY
import com.example.notesmvvm.utilits.TYPE_ROOM

class StartFragmentViewModel(application: Application) : AndroidViewModel(application) {

    private val mContext = application
    fun initDatabase(type: String,onSuccess:() -> Unit) {
        when (type) { TYPE_ROOM ->
            {
                val dao=AppRoomDatabase.getInstance(context = mContext).getAppRoomDao()
                REPOSITORY=AppRoomRepositoryImpl(dao)
                onSuccess()

            }
        }
    }

}