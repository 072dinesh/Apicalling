package com.example.postdataproject.fragment.univarcity


import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.annotation.RequiresApi
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.postdataproject.databinding.FragmentUnivarcityBinding
import com.example.postdataproject.model.TestdataItem

import com.example.postdataproject.util.NetworkResult
import com.example.postdataproject.util.snackBar
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import java.util.*
import kotlin.collections.ArrayList

@AndroidEntryPoint
class UnivarcityFragment : Fragment() {
    private var _binding: FragmentUnivarcityBinding? = null
    private val binding get() = _binding!!
    private val viewmodelsecode: ViewModelUni by viewModels()
    private lateinit var adapter: UnivarAdepter
    private var lastquery = ""
   // lateinit var a:List<TestdataItem>

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUnivarcityBinding.inflate(inflater,container,false)


        // Inflate the layout for this fragment

        setupUi()
        setingredients()
       setobserverss()
        return binding.root
    }


    @RequiresApi(Build.VERSION_CODES.M)
    private fun setupUi() {
        adapter = UnivarAdepter()
           // viewmodelsecode.getPost3()
        var list = ArrayList<TestdataItem>()
        Log.e("listdata", "$list")
        //Log.e("DATA", it.toString())
        for (i in list) {

            if (i?.country?.lowercase(Locale.ROOT)!!.contains(binding.searchView.query)) {

                list.add(i)
            }

        }
        if (list.isEmpty()) {
            //Toast.makeText(requireContext(),"error",Toast.LENGTH_SHORT).show()

        } else {
            Timber.e(list.toString())

            adapter.setData(list)
        }


        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())

        binding.recyclerview.adapter = adapter

    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun setingredients() {
        viewmodelsecode.allUsers.observe(viewLifecycleOwner) { respon ->


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

                        adapter.setData(it)
                    }

                   // adapter.setData(resci?.filterNotNull() ?: emptyList())
                }
            }


        }

    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun setobserverss() {

        viewmodelsecode.allUsers.observe(viewLifecycleOwner) {

            it.data?.let {
                //var list = ArrayList<Univarcity>()
                binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                    @RequiresApi(Build.VERSION_CODES.M)
                    override fun onQueryTextSubmit(query: String?): Boolean {
                        if (!query.isNullOrEmpty() && query != lastquery) {
                            lastquery = query
                            viewmodelsecode.getAllUserss(query.toString())
                        }
                        return true

                    }

                    @RequiresApi(Build.VERSION_CODES.M)
                    override fun onQueryTextChange(newText: String?): Boolean {
                        // viewmodel.getfood(newText.toString())
                        if (!newText.isNullOrEmpty() && newText != lastquery) {
                            lastquery = newText
                            viewmodelsecode.getAllUserss(newText.toString())
                        }

                        return true
                    }

                })


            }


        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}


