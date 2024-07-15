package com.example.musicapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.musicapp.R
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

private lateinit var txtField_Register_nameUser : TextInputEditText
private lateinit var txtField_Register_email : TextInputEditText
private lateinit var txtField_Register_password : TextInputEditText
private lateinit var txtField_Register_password2 : TextInputEditText
private lateinit var btn_Register_Registro : ExtendedFloatingActionButton

private lateinit var nameUser : String
private lateinit var email : String
private lateinit var password : String
private lateinit var password2 : String

private lateinit var database : FirebaseDatabase
private lateinit var databaseReference : DatabaseReference
private lateinit var auth : FirebaseAuth

class fragment_registro : Fragment() {
    // TODO: Rename and change types of parameters
//    private var param1: String? = null
//    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_registro, container, false)

        try {
            txtField_Register_nameUser = view.findViewById(R.id.txtField_Register_nameUser)
            txtField_Register_email = view.findViewById(R.id.txtField_Register_email)
            txtField_Register_password = view.findViewById(R.id.txtField_Register_password)
            txtField_Register_password2 = view.findViewById(R.id.txtField_Register_password2)
            btn_Register_Registro = view.findViewById(R.id.btn_Register_Registro)

        }catch(e: Exception) {
            Log.e("Fragment_register", "Error al inicializar los campos",e)
        }
        return view
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fragment_registro()
//                .apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
            }
    }
}