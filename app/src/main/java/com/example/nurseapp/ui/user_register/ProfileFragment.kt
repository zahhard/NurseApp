package com.example.nurseapp.ui.user_register

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
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
    lateinit var ppreferences: SharedPreferences

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


        ppreferences = requireActivity().getSharedPreferences("login", Context.MODE_PRIVATE)
        var id = ppreferences.getInt("id", -1)
        binding.name.text = ppreferences.getString("name", "")
        var type = ppreferences.getString("as", "")

        if (id != -1)
            userRegisterViewModel.getAllOrders(id, type!!)


        binding.edit.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Error")
                .setMessage("Do you want delete your account? ")
                .setPositiveButton("yes") { _, _ -> deleteAccount() }
                .setNegativeButton("cancel") { _, _ -> }
                .setCancelable(false)
                .show()

        }

        userRegisterViewModel.orderListLiveData.observe(viewLifecycleOwner) {
            val manager = LinearLayoutManager(requireContext())
            binding.recyclerview.layoutManager = manager
            var adapter = OrderAdapter(this) { }
            adapter.submitList(it)
            binding.recyclerview.adapter = adapter
            binding.recyclerview.layoutManager = GridLayoutManager(requireContext(), 2)
        }
//        val frg:Fragment=ProfileFragment()
//        requireActivity().getFragmentManager().beginTransaction().remove().commit();

    }

    private fun deleteAccount() {
        val editor: SharedPreferences.Editor = ppreferences.edit()
        editor.putInt("id", -1)
        editor.apply()
        editor.putString("name", "")
        editor.apply()
        editor.putString("as", "")
        editor.apply()

        findNavController().navigate(R.id.action_profileFragment_to_homeFragment)
//        requireActivity().getFragmentManager().beginTransaction().remove(this).commit();
    }
}