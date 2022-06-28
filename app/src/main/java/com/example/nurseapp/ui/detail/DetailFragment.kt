package com.example.nurseapp.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nurseapp.R
import com.example.nurseapp.databinding.FragmentDetailBinding
import com.example.nurseapp.databinding.FragmentHomeBinding
import com.example.nurseapp.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    val detailViewModel: DetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}