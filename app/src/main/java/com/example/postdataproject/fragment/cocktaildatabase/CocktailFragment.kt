package com.example.postdataproject.fragment.cocktaildatabase

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
import com.example.postdataproject.databinding.FragmentUsBinding
import com.example.postdataproject.fragment.getusdata.SourceAdaper
import com.example.postdataproject.fragment.getusdata.UsAdepter
import com.example.postdataproject.fragment.getusdata.ViewModelus
import com.example.postdataproject.model.Drink
import com.example.postdataproject.util.NetworkResult
import com.example.postdataproject.util.snackBar
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import java.util.*
import kotlin.collections.ArrayList

@AndroidEntryPoint
class CocktailFragment : Fragment() {

    private var _binding: FragmentCocktailBinding? = null
    private val binding get() = _binding!!
    private val ViewModelcl: ViewModelCocktail by viewModels()
    private lateinit var adapter: CocktailAdapter
    private var lastquery = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCocktailBinding.inflate(inflater,container,false)

        setupUi()
        setoverview()
        //setobserverss()
        return binding.root

    }

    private fun setupUi() {
        adapter = CocktailAdapter()

        // viewmodelsecode.getPost3()
        var list = ArrayList<Drink>()
        Log.e("listdata", "$list")
        //Log.e("DATA", it.toString())
        for (i in list) {

            if (i?.strDrink?.lowercase(Locale.ROOT)!!.contains(binding.searchView.query)) {

                list.add(i)
            }

        }
        if (list.isEmpty()) {
            //Toast.makeText(requireContext(),"error",Toast.LENGTH_SHORT).show()

        } else {
            Timber.e(list.toString())

            adapter.setData(list)
        }
        //ViewModelcl.getPostcocktail("fghhfghhhh")


        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())

        binding.recyclerview.adapter = adapter



        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                if (!query.isNullOrEmpty() && query != lastquery) {
                    lastquery = query
                    ViewModelcl.getPostcocktail(query.toString())
                }
                return true

            }


            override fun onQueryTextChange(newText: String?): Boolean {
                // viewmodel.getfood(newText.toString())
                if (!newText.isNullOrEmpty() && newText != lastquery) {
                    lastquery = newText
                    ViewModelcl.getPostcocktail(newText.toString())
                }

                return true
            }

        })

    }
    private fun setoverview() {
        ViewModelcl.allUsers.observe(viewLifecycleOwner,androidx.lifecycle.Observer{ respon ->


            when (respon) {
                is NetworkResult.Error -> {
                    respon.message?.snackBar(requireView(), requireContext())
                }
                is NetworkResult.Loading -> {

                    //binding.recyclerview.showShimmer() // to start showing shimmer

                }
                is NetworkResult.Success -> {
                    respon.data?.drinks.let {

                        //binding.recyclerview.hideShimmer()
                        //var list = kotlin.collections.ArrayList<Data>()
                        adapter.setData(it?.filterNotNull()?: emptyList())
                        //adapter.setData()

                    }


                }
            }

        })


    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}