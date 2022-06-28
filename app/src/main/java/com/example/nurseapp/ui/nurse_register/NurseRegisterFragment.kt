package com.example.nurseapp.ui.nurse_register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nurseapp.R
import com.example.nurseapp.databinding.FragmentHomeBinding
import com.example.nurseapp.databinding.FragmentNurceRegesterBinding
import com.example.nurseapp.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class NurseRegisterFragment : Fragment() {

    private lateinit var binding: FragmentNurceRegesterBinding
    val  nurseRegisterViewModel: NurseRegisterViewModel by viewModel()

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

}