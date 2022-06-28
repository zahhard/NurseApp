package com.example.nurseapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.nurseapp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        homeViewModel.get()
        homeViewModel.setCategory()

//        homeViewModel.categoryListLiveData.observe(viewLifecycleOwner) {
//            val manager = LinearLayoutManager(requireContext())
//            binding.servicesRecyclerview.layoutManager = manager
//            var adapter = CategoryAdapter(this) { id -> goToCategory(id) }
//            adapter.submitList(it)
//            binding.servicesRecyclerview.adapter = adapter
//            binding.servicesRecyclerview.layoutManager = LinearLayoutManager(
//                requireContext(),
//                LinearLayoutManager.HORIZONTAL, false
//            )
//        }
    }

    private fun goToCategory(id: Int) {

    }

}