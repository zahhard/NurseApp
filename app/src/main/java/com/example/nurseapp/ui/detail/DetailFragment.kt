package com.example.nurseapp.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.nurseapp.databinding.FragmentDetailBinding
import com.example.nurseapp.model.InternetConnection
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    val detailViewModel: DetailViewModel by viewModels()

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkInternetConnection()
    }

    private fun observeProduceItem() {
        detailViewModel.nurseItemLiveData.observe(viewLifecycleOwner) {
            if (it != null) {
                binding.tvDetailName.text = it.fname + " " + it.lname
            }
            binding.rating.text = it.average_rate.toString()
            binding.tvCategoryList.text = it.education
            val transformation = MultiTransformation(CenterCrop(), RoundedCorners(20))
            Glide.with(this)
                .load(it.image)
                .placeholder(android.R.drawable.ic_dialog_info)
                .error(android.R.drawable.ic_dialog_alert)
//            .apply(RequestOptions.circleCropTransform())
                .transform(transformation)
                .into(binding.image)
//                binding.detailPrice.text = it.price
        }
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
        var itemId = requireArguments().getInt("filmId", -1)
        detailViewModel.getItemDetail(itemId)
        observeProduceItem()
    }
}
