package com.example.nurseapp.ui.detail

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.nurseapp.databinding.FragmentCommentBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CommentFragment : Fragment() {

    private lateinit var binding: FragmentCommentBinding
    val detailViewModel: DetailViewModel by viewModels()
    lateinit var ppreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCommentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ppreferences = requireActivity().getSharedPreferences("login", Context.MODE_PRIVATE)

       var  nurseId = requireArguments().getInt("nurse", -1)
       var  date = requireArguments().getString("date", "")
       var  dayCount = requireArguments().getInt("day_count", -1)
       var  userId = requireArguments().getInt("user", -1)

        binding.payment.setOnClickListener {
            if (ppreferences.getInt("id", -1) != -1) {
                if (date != "" && dayCount != -1) {
                    detailViewModel.setOrder(
                        date,
                        dayCount,
                        nurseId,
                        ppreferences.getInt("id", -1),
                    )
                    Snackbar.make(binding.content, "Final payment was successful", Snackbar.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "Choose an other time please", Toast.LENGTH_SHORT).show()

            }

        }

        Snackbar.make(binding.content, "message", Snackbar.LENGTH_SHORT).show()

//    }

    }
}