package com.example.nurseapp.ui.user_register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.nurseapp.R
import com.example.nurseapp.databinding.FragmentInsideEachCategoryBinding
import com.example.nurseapp.databinding.FragmentUserRegisterBinding
import com.example.nurseapp.ui.inside_of_each_otem.InsideEachCategoryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserRegisterFragment : Fragment() {

    private lateinit var binding: FragmentUserRegisterBinding
    val userRegisterViewModel: UserRegisterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserRegisterBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}