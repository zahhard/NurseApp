package com.example.nurseapp.ui.inside_of_each_otem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nurseapp.R
import com.example.nurseapp.adapter.EachCategotyAdapter
import com.example.nurseapp.databinding.FragmentInsideEachCategoryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InsideEachCategoryFragment : Fragment() {

    private lateinit var binding: FragmentInsideEachCategoryBinding
    val insideEachCategoryViewModel: InsideEachCategoryViewModel by viewModels()

    //    lateinit var ppreferences: SharedPreferences
    var filter = "General Care"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInsideEachCategoryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var itemId = requireArguments().getString("education", "")
        var search = requireArguments().getString("search", "")

        if (itemId != "") {
            insideEachCategoryViewModel.getItemDetail(itemId)
        }
        if (search != ""){
            insideEachCategoryViewModel.search(search)

        }
            binding.radioGroup.setOnCheckedChangeListener { radioGroup, i ->

                if (i == R.id.baby) {
                    filter = "Baby care"
                }
                if (i == R.id.elderly) {
                    filter = "Elderly care"
                }
                if (i == R.id.bandage) {
                    filter = "Bandage"
                }
                if (i == R.id.rating) {
                    filter = "Top"
                }
                insideEachCategoryViewModel.filter(search, filter)
                Toast.makeText(requireContext(), "$search / $filter" , Toast.LENGTH_SHORT).show()
            }





        insideEachCategoryViewModel.nursesListLiveData.observe(viewLifecycleOwner) {
            val manager = LinearLayoutManager(requireContext())
            binding.recyclerview.layoutManager = manager
            var adapter = EachCategotyAdapter(this) { id -> goToDetail(id) }
            adapter.submitList(it)
            binding.recyclerview.adapter = adapter
        }
    }


    private fun goToDetail(id: Int) {
        findNavController().navigate(
            R.id.action_insideEachCategoryFragment_to_detailFragment,
            bundleOf("filmId" to id)
        )
    }


}