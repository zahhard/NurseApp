package com.example.nurseapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.example.nurseapp.R
import com.example.nurseapp.adapter.CategoryAdapter
import com.example.nurseapp.adapter.SliderAdapter
import com.example.nurseapp.adapter.TopNursesAdapter
import com.example.nurseapp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    val homeViewModel: HomeViewModel by viewModels()
    var listOfImages = ArrayList<String>()

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
        homeViewModel.setTopNurses()
        homeViewModel.getSpecialNurses()

        homeViewModel.categoryListLiveData.observe(viewLifecycleOwner) {
            val manager = LinearLayoutManager(requireContext())
            binding.servicesRecyclerview.layoutManager = manager
            var adapter = CategoryAdapter(this) { id -> goToCategory(id) }
            adapter.submitList(it)
            binding.servicesRecyclerview.adapter = adapter
            binding.servicesRecyclerview.layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL, false
            )
        }
        homeViewModel.topNursesListLiveData.observe(viewLifecycleOwner) {
            val manager = LinearLayoutManager(requireContext())
            binding.topRecyclerview.layoutManager = manager
            var adapter = TopNursesAdapter(this) { id -> goToCategory(id) }
            adapter.submitList(it)
            binding.topRecyclerview.adapter = adapter
            binding.topRecyclerview.layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL, false
            )
        }


        homeViewModel.specialNursesListLiveData.observe(viewLifecycleOwner) {
            for (nurse in it) {
                listOfImages.add(nurse.image)
            }
            binding.viewPagerImageSlider.adapter =
                SliderAdapter(this, listOfImages, binding.viewPagerImageSlider)
            binding.viewPagerImageSlider.clipToPadding = false
            binding.viewPagerImageSlider.clipChildren = false
            binding.viewPagerImageSlider.offscreenPageLimit = 3
            binding.viewPagerImageSlider.getChildAt(0).overScrollMode =
                RecyclerView.OVER_SCROLL_NEVER
            var compositePageTransformer = CompositePageTransformer()
            compositePageTransformer.addTransformer(MarginPageTransformer(40))
        }
    }

    private fun goToCategory(id: Int) {
//        findNavController().navigate(R.id)
    }

}