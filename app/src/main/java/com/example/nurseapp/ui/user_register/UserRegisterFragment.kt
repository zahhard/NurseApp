package com.example.nurseapp.ui.user_register

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.nurseapp.R
import com.example.nurseapp.data.database.NurseEntity
import com.example.nurseapp.data.database.UserEntity
import com.example.nurseapp.databinding.FragmentUserRegisterBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlin.random.Random

@AndroidEntryPoint
class UserRegisterFragment : Fragment() {

    private lateinit var binding: FragmentUserRegisterBinding
    private val userRegisterViewModel: UserRegisterViewModel by viewModels()
    lateinit var ppreferences: SharedPreferences
    var userId = -1
    var type = ""
    var filter = ""

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

        ppreferences = requireActivity().getSharedPreferences("login", Context.MODE_PRIVATE)
        goToProfile()
        binding.redio.setOnCheckedChangeListener { radioGroup, i ->
            if (i == R.id.nurse) {
                type = "nurse"
                binding.radioGroup.isGone = false
            }
            if (i == R.id.user) {
                type = "user"
                binding.radioGroup.isGone = true
            }
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
        }

        binding.login.setOnClickListener {


            if (binding.firstNme.text.isNullOrBlank()) {
                binding.firstNme.error = "empty"
            }
            else if (binding.lastName.text.isNullOrBlank()) {
                binding.lastName.error = "empty"
            }
            else if (binding.address.text.isNullOrBlank()) {
                binding.address.error = "empty"
            }
            else if (binding.city.text.isNullOrBlank()) {
                binding.city.error = "empty"
            }
           else if (binding.phone.text.isNullOrBlank()) {
                binding.phone.error = "empty"
            } else {

                userId = Random.nextInt(0, 1000)

                if (type == "user") {

                    val user = UserEntity(userId, binding.firstNme.text.toString(), binding.lastName.text.toString(), binding.phone.text.toString(), binding.city.text.toString(), binding.address.text.toString(),
                    )
                    userRegisterViewModel.insertUser(user)
                } else if (type == "nurse") {
                    val nurse = NurseEntity(userId, userId, binding.firstNme.text.toString(), binding.lastName.text.toString(), binding.phone.text.toString(), 0F, filter, "https://img.freepik.com/free-photo/healthcare-workers-preventing-virus-quarantine-campaign-concept-smiling-pleasant-asian-female-physician-doctor-during-examination-wearing-scrubs-holding-clipboard-white-background_1258-21394.jpg?w=2000")

                    userRegisterViewModel.insertNurse(nurse)
                }


                var name = binding.firstNme.text.toString() + " " + binding.lastName.text.toString()

                val editor: SharedPreferences.Editor = ppreferences.edit()
                editor.putString("name", name)
                editor.putInt("id", userId)
                editor.putString("as", type)
                editor.apply()
                Toast.makeText(requireContext(), "successful", Toast.LENGTH_SHORT).show()

                goToProfile()
            }
        }
    }

    private fun goToProfile() {
        if ( ppreferences.getInt("id", -1) != -1) {
            findNavController().navigate(
                R.id.action_userRegisterFragment_to_profileFragment2,
                bundleOf("id" to userId)
            )
        }
    }
}
