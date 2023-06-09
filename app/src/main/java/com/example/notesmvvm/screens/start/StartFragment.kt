package com.example.notesmvvm.screens.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.notesmvvm.R
import com.example.notesmvvm.databinding.FragmentStartBinding
import com.example.notesmvvm.utilits.APP_ACTIVITY
import com.example.notesmvvm.utilits.TYPE_DATABASE
import com.example.notesmvvm.utilits.TYPE_ROOM

class StartFragment : Fragment() {

    /*private var _binding: FragmentStartBinding?=null
    private val mBinding get() = _binding!!*/
    private lateinit var mViewModel: StartFragmentViewModel

    private val mBinding: FragmentStartBinding by lazy {
        FragmentStartBinding.inflate(layoutInflater)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        mViewModel= ViewModelProvider(this)[StartFragmentViewModel::class.java]
        mBinding.btnRoom.setOnClickListener {
            mViewModel.initDatabase(TYPE_ROOM){
                APP_ACTIVITY.mNavController.navigate(R.id.action_startFragment_to_mainFragment)

            }
        }
    }


}