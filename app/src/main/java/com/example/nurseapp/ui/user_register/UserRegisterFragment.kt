package com.example.nurseapp.ui.user_register

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.nurseapp.R
import com.example.nurseapp.data.database.UserEntity
import com.example.nurseapp.databinding.FragmentUserRegisterBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlin.random.Random
import kotlin.Int as Int1

@AndroidEntryPoint
class UserRegisterFragment : Fragment() {

    private lateinit var binding: FragmentUserRegisterBinding
    private val userRegisterViewModel: UserRegisterViewModel by viewModels()
    lateinit var ppreferences: SharedPreferences
    var userId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserRegisterBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ppreferences = requireActivity().getSharedPreferences("is_registered", Context.MODE_PRIVATE)
        registerOrProfile()

        binding.login.setOnClickListener {
            userId = Random(10000).nextInt()
            val user = UserEntity(
                userId,
                binding.firstNme.text.toString(),
                binding.lastName.text.toString(),
                binding.phone.text.toString(),
                binding.city.text.toString(),
                binding.address.text.toString(),
            )

            userRegisterViewModel.insertUser(user)

            val editor: SharedPreferences.Editor = ppreferences.edit()
            editor.putBoolean("is_reg", true)
            editor.apply()

            registerOrProfile()
        }
    }

    private fun registerOrProfile() {
        if (ppreferences.getBoolean("is_reg", false) == true) {
            findNavController().navigate(R.id.action_userRegisterFragment_to_profileFragment, bundleOf("userId" to userId))
        }
    }
}
