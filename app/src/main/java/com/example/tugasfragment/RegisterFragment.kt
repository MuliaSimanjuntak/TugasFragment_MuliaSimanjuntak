package com.example.tugasfragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tugasfragment.databinding.ActivityMain2Binding.inflate
import com.example.tugasfragment.databinding.FragmentRegisterBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegisterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val fragmentRegister =inflater.inflate(R.layout.fragment_register, container, false)
        val buttonRegister = fragmentRegister.findViewById<Button>(R.id.buttonRegister)
        val username = fragmentRegister.findViewById<EditText>(R.id.username)
        val email = fragmentRegister.findViewById<EditText>(R.id.email)
        val phone = fragmentRegister.findViewById<EditText>(R.id.phone)
        val password = fragmentRegister.findViewById<EditText>(R.id.password)

        buttonRegister.setOnClickListener {
            val username = username.text.toString()
            val email = email.text.toString()
            val phone = phone.text.toString()
            val password = password.text.toString()

            if (username.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty()) {
                Toast.makeText(
                    requireActivity(),
                    "Please fill out all fields",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val activity = requireActivity() as? MainActivity
                activity?.saveData(username, password, email, phone)
                activity?.navigateTo(0)

//                // Buat bundle untuk mengirim data
//                val bundle = Bundle().apply {
//                    putString("username", username)
//                    putString("email", email)
//                    putString("phone", phone)
//                    putString("password", password)
//                }
//
//                // Buat instance LoginFragment dan tambahkan bundle
//                val loginFragment = LoginFragment().apply {
//                    arguments = bundle
//                }
//
//                // Navigasi ke LoginFragment
//                parentFragmentManager.beginTransaction()
//                    .replace(R.id.view_pager, loginFragment)
//                    .addToBackStack(null)
//                    .commit()
            }
        }
        return fragmentRegister

    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RegisterFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegisterFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}