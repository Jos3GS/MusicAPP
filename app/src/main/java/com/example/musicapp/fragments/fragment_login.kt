package com.example.musicapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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

private lateinit var txtEmail : TextInputEditText
private lateinit var txtPassword : TextInputEditText
private lateinit var btnLogin : ExtendedFloatingActionButton

private lateinit var email : String
private lateinit var password : String

private lateinit var database : FirebaseDatabase
private lateinit var databaseReference : DatabaseReference
private lateinit var auth : FirebaseAuth


class fragment_login : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        try {
            txtEmail = view.findViewById(R.id.txtField_login_email)
            txtPassword = view.findViewById(R.id.txtField_login_password)
            btnLogin = view.findViewById(R.id.btn_login_Ingresar)

            database = FirebaseDatabase.getInstance()
            databaseReference = database.getReference().child("User")
            auth = FirebaseAuth.getInstance()

        } catch (e: Exception) {
            Log.e("Fragment_login", "Error al inicializar los campos",e)
        }

        btnLogin.setOnClickListener {
            if(login()) {
                Toast.makeText(requireContext(), "Inicio de sesión completo", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        return view
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fragment_login()
//                .apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
            }
    }

private fun login(): Boolean{
    try {
        email = txtEmail.text.toString()
        password = txtPassword.text.toString()
        if(email.isEmpty() || password.isEmpty()) throw Exception("Los campos no pueden estar vacios")
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener { task ->
                if(task.isSuccessful){
                    val user = auth.currentUser
                }
            }
            .addOnFailureListener {
                throw Exception("Error en el ingreso de sesión")
            }
        return true

    }catch (e: Exception){
        Log.e("Fragment_login", "Error al iniciar sesión", e)
    }
    return false
}