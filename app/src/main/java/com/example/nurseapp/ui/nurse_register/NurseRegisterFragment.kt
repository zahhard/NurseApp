package com.example.nurseapp.ui.nurse_register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.nurseapp.databinding.FragmentNurceRegesterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NurseRegisterFragment : Fragment() {

    private lateinit var binding: FragmentNurceRegesterBinding
//    val  nurseRegisterViewModel: NurseRegisterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNurceRegesterBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}