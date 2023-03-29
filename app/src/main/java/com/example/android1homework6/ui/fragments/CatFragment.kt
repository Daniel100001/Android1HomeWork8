package com.example.android1homework6.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android1homework6.R
import com.example.android1homework6.Repositories.CarRepository
import com.example.android1homework6.data.CatModel
import com.example.android1homework6.interfaces.OnItemClick
import com.example.android1homework6.ui.adapters.CatAdapter
import java.text.AttributedCharacterIterator.Attribute


class CatFragment : Fragment() , OnItemClick {

    private var recyclerView: RecyclerView? = null
    private var repository = CarRepository()
    private var button: Button? = null
    private var list = mutableListOf<CatModel>()
    private var catAdapter = CatAdapter(this,list)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView_catFragment)
        button = view.findViewById(R.id.back)
        list = repository.getLisOfCat()
        initialization()
        goToThirdFragment()

    }

    private fun goToThirdFragment() {
        button?.setOnClickListener(){
            findNavController().navigate(R.id.action_catFragment_to_theeFragment)
        }
    }

    private fun initialization() {
        val bundle = arguments
        if (bundle != null) {
            val dataModel = bundle.getSerializable("text") as CatModel
            list.add(dataModel)
        }
        catAdapter = CatAdapter(this , list)
        catAdapter.notifyDataSetChanged()
        val layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = catAdapter

    }

    override fun onShortClick(catModel: CatModel) {
        val bundle = Bundle()
        bundle.putSerializable("Dan",catModel)
        findNavController().navigate(R.id.action_catFragment_to_detailFragment , bundle)
    }

}