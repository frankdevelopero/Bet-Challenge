package com.apuestatotal.app.presentation.signin

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.apuestatotal.app.R
import com.apuestatotal.app.databinding.FragmentSignInBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SignInFragment : Fragment() {

    private lateinit var binding: FragmentSignInBinding
    private val signInViewModel: SignInViewModel by viewModels()
    private var loadingDialog: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignInBinding.inflate(layoutInflater)
        settingViews()
        return binding.root
    }

    private fun settingViews(){

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            val fcmToken = "fcmToken123"

            signInViewModel.signIn(email, password, fcmToken)
        }

        signInViewModel.user.observe(viewLifecycleOwner) { user ->
            if (user != null) {
                findNavController().navigate(R.id.action_signInFragment_to_mainFragment)
            }
        }

        signInViewModel.error.observe(viewLifecycleOwner) { errorMessage ->
            errorMessage?.let {
                showError(it.error!!)
            }
        }

        signInViewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            if (isLoading) {
                showLoading()
            } else {
                hideLoading()
            }
        }
    }

    private fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

    private fun showLoading() {
        if (loadingDialog == null) {
            loadingDialog = Dialog(requireContext())
            loadingDialog?.setContentView(R.layout.loading_animation)
            loadingDialog?.setCancelable(false)
            loadingDialog?.window?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#57626262")))
        }

        loadingDialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )

        if (loadingDialog?.isShowing == false) {
            loadingDialog?.show()
        }
    }

    private fun hideLoading() {
        loadingDialog?.dismiss()
        loadingDialog = null
    }

}