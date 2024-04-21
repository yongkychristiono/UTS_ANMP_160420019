package com.example.uts_anmp_160420019.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.uts_anmp_160420019.R
import com.example.uts_anmp_160420019.viewmodel.profileViewModel

class FragmentProfil : Fragment() {
    private lateinit var viewModel: profileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profil, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(profileViewModel::class.java)
        viewModel.fetch()
        observeViewModel()
    }

    fun observeViewModel(){
        viewModel.profileLD.observe(viewLifecycleOwner, Observer {
            txtEditChangeNamaDepan(it.namaDepan)
            txtEditChangeNamaBelakang(it.namaBelakang)
            txtEditChangePassword(it.password)
        })
    }
}