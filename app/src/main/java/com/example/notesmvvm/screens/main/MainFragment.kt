package com.example.notesmvvm.screens.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.notesmvvm.R
import com.example.notesmvvm.databinding.FragmentMainBinding
import com.example.notesmvvm.utilits.APP_ACTIVITY


class MainFragment : Fragment() {

    private val binding: FragmentMainBinding by lazy {
        FragmentMainBinding.inflate(layoutInflater)
    }

    lateinit var mNavController: NavController

    private lateinit var mViewModel: MainFragmentViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        mViewModel= ViewModelProvider(this)[MainFragmentViewModel::class.java]
        binding.btnAddNote.setOnClickListener {
           // view?.let { it1 -> Navigation.findNavController(it1).navigate(R.id.action_mainFragment_to_addNewNoteFragment) }
            APP_ACTIVITY.mNavController.navigate(R.id.action_mainFragment_to_addNewNoteFragment)
        }
    }


}