package com.example.android1homework6.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.android1homework6.R
import com.example.android1homework6.Repositories.CarRepository
import com.example.android1homework6.data.CatModel
import com.example.android1homework6.databinding.FragmentTheeBinding
import com.example.android1homework6.ui.adapters.CatAdapter


class TheeFragment() : Fragment() {

    private var binding: FragmentTheeBinding? = null
    private lateinit var model : CatModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTheeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        GoToThreeFragment()
    }

    private fun GoToThreeFragment() {
        binding?.btnBack?.setOnClickListener(View.OnClickListener {
            val text = binding!!.EditTextFragmentThee.text.toString()
            if (text.isNotEmpty()) {
                model = CatModel(null ,text , text , null)
                val bundle = Bundle()
                bundle.putSerializable("text", model)
                findNavController().navigate(R.id.catFragment , bundle)
            }
        })
    }
}


