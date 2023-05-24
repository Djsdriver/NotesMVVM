package com.example.notesmvvm.screens.add_new_note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.notesmvvm.R
import com.example.notesmvvm.databinding.FragmentAddNoteBinding
import com.example.notesmvvm.models.AppNote
import com.example.notesmvvm.utilits.APP_ACTIVITY
import com.example.notesmvvm.utilits.showToast


class AddNewNoteFragment : Fragment() {


    private val binding: FragmentAddNoteBinding by lazy {
        FragmentAddNoteBinding.inflate(layoutInflater)
    }

    private lateinit var mViewModel: AddNewNoteViewModel
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
        mViewModel =ViewModelProvider(this)[AddNewNoteViewModel::class.java]
        binding.btnAddNote.setOnClickListener {
            val name=binding.inputNameNote.text.toString()
            val text=binding.inputTextNote.text.toString()
            if (name.isEmpty()){
                showToast(getString(R.string.enter_name_note))
            } else{
                mViewModel.insert(AppNote(name = name, text = text)){
                    APP_ACTIVITY.mNavController.navigate(R.id.action_addNewNoteFragment_to_mainFragment)
                    showToast("Заметка добавлена")
                }
            }
        }
    }


}