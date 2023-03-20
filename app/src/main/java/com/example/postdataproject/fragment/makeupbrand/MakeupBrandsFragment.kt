package com.example.postdataproject.fragment.makeupbrand

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.postdataproject.R
import com.example.postdataproject.databinding.FragmentCocktailBinding
import com.example.postdataproject.databinding.FragmentMakeupBrandsBinding
import com.example.postdataproject.databinding.FragmentUnivarcityBinding
import com.example.postdataproject.databinding.ItemmakeupBinding
import com.example.postdataproject.fragment.cocktaildatabase.CocktailAdapter
import com.example.postdataproject.fragment.univarcity.UnivarAdepter
import com.example.postdataproject.fragment.univarcity.ViewModelUni
import com.example.postdataproject.model.Drink
import com.example.postdataproject.model.MekepdataItem
import com.example.postdataproject.model.ProductColor
import com.example.postdataproject.util.NetworkResult
import com.example.postdataproject.util.snackBar
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import java.util.*
import kotlin.collections.ArrayList

@AndroidEntryPoint
class MakeupBrandsFragment : Fragment() {

    private var _binding: FragmentMakeupBrandsBinding? = null
    private val binding get() = _binding!!

    private val ViewModelBf: ViewModelMakeup by viewModels()
    private lateinit var adapter: MakeupAdapter
    private lateinit var adapters: MakeupAdapters
    private var lastquery = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMakeupBrandsBinding.inflate(inflater,container,false)

        setupUi()
        setoverview()
        setoverviews()
        //setoverviews()
        //setobserverss()
        return binding.root
    }


    private fun setupUi() {
        adapter = MakeupAdapter()


        adapters = MakeupAdapters()
        // viewmodelsecode.getPost3()
        var list = ArrayList<MekepdataItem>()
        var lists = ArrayList<ProductColor>()
        Log.e("listdata", "$lists")
        //Log.e("DATA", it.toString())
        for (i in list) {

            if (i?.brand?.lowercase(Locale.ROOT)!!.contains(binding.searchView.query)) {

                list.add(i)
            }

        }
        if (list.isEmpty()) {
            //Toast.makeText(requireContext(),"error",Toast.LENGTH_SHORT).show()

        } else {
            Timber.e(list.toString())

            adapter.setData(list)

            //adapters.setData(lists)
        }
        //ViewModelcl.getPostcocktail("fghhfghhhh")


        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())

        binding.recyclerview.adapter = adapter
//        binding.recyclerviews.layoutManager = LinearLayoutManager(requireContext())
//
//        binding.recyclerviews.adapter = adapters
        //binding.recyclerview.adapter = adapters



        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                if (!query.isNullOrEmpty() && query != lastquery) {
                    lastquery = query
                    ViewModelBf.getdatafromApimakeup(query.toString())
                }
                return true

            }


            override fun onQueryTextChange(newText: String?): Boolean {
                // viewmodel.getfood(newText.toString())
                if (!newText.isNullOrEmpty() && newText != lastquery) {
                    lastquery = newText
                    ViewModelBf.getdatafromApimakeup(newText.toString())
                }

                return true
            }

        })

    }

    private fun setoverview() {
        ViewModelBf.allUsers.observe(viewLifecycleOwner,androidx.lifecycle.Observer{ respon ->


            when (respon) {
                is NetworkResult.Error -> {
                    respon.message?.snackBar(requireView(), requireContext())
                }
                is NetworkResult.Loading -> {

                    //binding.recyclerview.showShimmer() // to start showing shimmer

                }
                is NetworkResult.Success -> {
                    respon.data?.let {

                        //binding.recyclerview.hideShimmer()
                        //var list = kotlin.collections.ArrayList<Data>()
                        //adapter.setData(res?.filterNotNull()?: emptyList())

                        adapter.setData(it)

                    }




                }
            }

        })


    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }




    private fun setoverviews() {
        ViewModelBf.allUsersp.observe(viewLifecycleOwner,androidx.lifecycle.Observer{ respon ->

            when (respon) {
                is NetworkResult.Error -> {
                    respon.message?.snackBar(requireView(), requireContext())
                }
                is NetworkResult.Loading -> {

                    //binding.recyclerview.showShimmer() // to start showing shimmer

                }
                is NetworkResult.Success -> {
                    respon.data?.let {

                        //binding.recyclerview.hideShimmer()
                        //var list = kotlin.collections.ArrayList<Data>()

                        adapters.setData(it)
                        Log.e("listdatasss", "${it.toString()}")
                        //adapter.setData()

                    }

                }
            }

        })


    }

}