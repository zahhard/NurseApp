package com.example.nurseapp.ui.user_register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nurseapp.R
import com.example.nurseapp.adapter.OrderAdapter
import com.example.nurseapp.databinding.FragmentProfileBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    val userRegisterViewModel: UserRegisterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var userId = requireArguments().getInt("userId", 0)


        if (userId != 0) {
            userRegisterViewModel.getUser(userId)
            userRegisterViewModel.getAllOrders()
            userRegisterViewModel.UserLiveData.observe(viewLifecycleOwner) {
                binding.name.text = it.name + " " + it.lname
            }
        }
        else{
            findNavController().navigate(R.id.action_profileFragment_to_userRegisterFragment)
            Toast.makeText(requireContext(), "You don't have any account!", Toast.LENGTH_SHORT).show()
        }

        userRegisterViewModel.orderListLiveData.observe(viewLifecycleOwner) {
            val manager = LinearLayoutManager(requireContext())
            binding.recyclerview.layoutManager = manager
            var adapter = OrderAdapter(this) { }
            adapter.submitList(it)
            binding.recyclerview.adapter = adapter
            binding.recyclerview.layoutManager = GridLayoutManager(requireContext(), 2)
        }
    }
}