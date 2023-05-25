package com.example.notesmvvm.screens.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notesmvvm.R
import com.example.notesmvvm.databinding.FragmentMainBinding
import com.example.notesmvvm.models.AppNote
import com.example.notesmvvm.utilits.APP_ACTIVITY


class MainFragment : Fragment() {

    private val binding: FragmentMainBinding by lazy {
        FragmentMainBinding.inflate(layoutInflater)
    }

    //lateinit var mRecycler:RecyclerView
    lateinit var mainAdapter: MainAdapter
    lateinit var listObserveList: Observer<List<AppNote>>

    lateinit var mNavController: NavController

    private lateinit var mViewModel: MainFragmentViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root

    }


    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        mainAdapter= MainAdapter()

        binding.recyclerView.adapter=mainAdapter
        listObserveList= Observer {
            val list=it.asReversed()
            mainAdapter.setList(list = list)
        }
        binding.recyclerView.layoutManager=LinearLayoutManager(APP_ACTIVITY)

        mViewModel= ViewModelProvider(this)[MainFragmentViewModel::class.java]
        mViewModel.allNotes.observe(this,listObserveList)
        binding.btnAddNote.setOnClickListener {
           // view?.let { it1 -> Navigation.findNavController(it1).navigate(R.id.action_mainFragment_to_addNewNoteFragment) }
            APP_ACTIVITY.mNavController.navigate(R.id.action_mainFragment_to_addNewNoteFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mViewModel.allNotes.removeObserver(listObserveList)
    }


}