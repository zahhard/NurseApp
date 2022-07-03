package com.example.nurseapp.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.nurseapp.R
import com.example.nurseapp.adapter.CommentAdapter
import com.example.nurseapp.databinding.FragmentDetailBinding
import com.example.nurseapp.model.InternetConnection
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    val detailViewModel: DetailViewModel by viewModels()
    var nurseId = -1

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


        detailViewModel.nurseCommentsLiveData.observe(viewLifecycleOwner) {
            val manager = LinearLayoutManager(requireContext())
            binding.recyclerview.layoutManager = manager
            var adapter = CommentAdapter(this) { }
            adapter.submitList(it)
            binding.recyclerview.adapter = adapter
            binding.recyclerview.layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL, false
            )
        }

        binding.submit.setOnClickListener {
            var date = binding.date.text.toString()
            var dayCount = binding.dayCount.text.toString()

//            detailViewModel.setOrder(date, dayCount, nurseId)
        }

    }


    private fun observeProduceItem() {
        detailViewModel.nurseItemLiveData.observe(viewLifecycleOwner) {

            if (it != null) {
                detailViewModel.getComments(it.nurseID)
                binding.tvDetailName.text = it.fname + " " + it.lname
                binding.rating.text = it.average_rate.toString()
                binding.tvCategoryList.text = it.education
                val transformation = MultiTransformation(CenterCrop(), RoundedCorners(20))
                Glide.with(this)
                    .load(it.image)
                    .placeholder(android.R.drawable.ic_dialog_info)
                    .error(android.R.drawable.ic_dialog_alert)
                    .transform(transformation)
                    .into(binding.image)
            }

            if (it.education == "baby care"){
                Glide.with(this)
                    .load("https://img.icons8.com/fluency/344/mother-room.png")
                    .placeholder(android.R.drawable.ic_dialog_info)
                    .error(android.R.drawable.ic_dialog_alert)
                    .into(binding.imageViewEdication)
            }
            if (it.education == "elderly care"){
                Glide.with(this)
                    .load("https://img.icons8.com/color/344/elderly-person.png")
                    .placeholder(android.R.drawable.ic_dialog_info)
                    .error(android.R.drawable.ic_dialog_alert)
                    .into(binding.imageViewEdication)
            }
            if (it.education == "general care"){
                Glide.with(this)
                    .load("https://img.icons8.com/color/2x/examination.png")
                    .placeholder(android.R.drawable.ic_dialog_info)
                    .error(android.R.drawable.ic_dialog_alert)
                    .into(binding.imageViewEdication)
            }
            if (it.education == "bandage"){
                Glide.with(this)
                    .load("https://img.icons8.com/color/2x/cast.png")
                    .placeholder(android.R.drawable.ic_dialog_info)
                    .error(android.R.drawable.ic_dialog_alert)
                    .into(binding.imageViewEdication)
            }
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
        nurseId = requireArguments().getInt("filmId", -1)
        detailViewModel.getItemDetail(nurseId)
        observeProduceItem()
    }
}
