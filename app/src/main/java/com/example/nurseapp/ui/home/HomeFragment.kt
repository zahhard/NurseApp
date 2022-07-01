package com.example.nurseapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
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
import com.example.nurseapp.model.InternetConnection
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
//
        homeViewModel.setTestOrder()
        homeViewModel.setTestData()
        checkInternetConnection()

        binding.imageButton.setOnClickListener {
            if ( !binding.search.text.isNullOrBlank() ) {
                var bundle = bundleOf("search" to binding.search.text.toString())
                findNavController().navigate(
                    R.id.action_homeFragment_to_insideEachCategoryFragment,
                    bundle
                )
            }
        }


    }

    private fun goToCategory(id: String) {
        findNavController().navigate(R.id.action_homeFragment_to_insideEachCategoryFragment, bundleOf("education" to id))
    }

    private fun goToDetail(id: Int) {
        findNavController().navigate(R.id.action_homeFragment_to_detailFragment, bundleOf("filmId" to id))
    }

    private fun checkInternetConnection() {
        if (InternetConnection().checkForInternet(requireContext())) {
            observreAllLiveDatas()
//            search()
        } else
            AlertDialog.Builder(requireContext())
                .setTitle("Error")
                .setMessage("Check your internet connection! ")
                .setPositiveButton("ok") { _, _ -> checkInternetConnection() }
                .setCancelable(false)
                .show()
    }

    private fun observreAllLiveDatas() {
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
            var adapter = TopNursesAdapter(this) { id -> goToDetail(id) }
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

}