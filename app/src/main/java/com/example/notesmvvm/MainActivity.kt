package com.example.notesmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.notesmvvm.databinding.ActivityMainBinding
import com.example.notesmvvm.utilits.APP_ACTIVITY

class MainActivity : AppCompatActivity() {

    lateinit var mToolbar: Toolbar
    lateinit var mNavController: NavController
    private var _binding: ActivityMainBinding?=null
    val mBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        APP_ACTIVITY=this

        mToolbar=mBinding.toolbar
        mNavController=Navigation.findNavController(this, R.id.nav_host_fragment)
        setSupportActionBar(mToolbar)
        title=getString(R.string.title)


    }


    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}