package com.example.postdataproject.fragment.publicpostfromwordpress

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
import com.example.postdataproject.databinding.FragmentMakeupBrandsBinding
import com.example.postdataproject.databinding.FragmentWordpressBinding
import com.example.postdataproject.fragment.makeupbrand.MakeupAdapter
import com.example.postdataproject.fragment.makeupbrand.MakeupAdapters
import com.example.postdataproject.fragment.makeupbrand.ViewModelMakeup
import com.example.postdataproject.model.MekepdataItem
import com.example.postdataproject.model.ProductColor
import com.example.postdataproject.util.NetworkResult
import com.example.postdataproject.util.snackBar
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import java.util.*
import kotlin.collections.ArrayList

@AndroidEntryPoint
class WordpressFragment : Fragment() {

    private var _binding: FragmentWordpressBinding? = null
    private val binding get() = _binding!!

    private val ViewModelwf: ViewModelPublic by viewModels()
    private lateinit var adapter: PublicAdapterMain
    private lateinit var adapters: PublicAdapter
    private var lastquery = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWordpressBinding.inflate(inflater,container,false)

        setupUi()
        setoverview()
        setoverviews()
        //setoverviews()
        //setobserverss()
        return binding.root
    }


    private fun setupUi() {
        adapter = PublicAdapterMain()

        adapters = PublicAdapter()
        // viewmodelsecode.getPost3()


        binding.pbrecyclerview.layoutManager = LinearLayoutManager(requireContext())

        binding.pbrecyclerview.adapter = adapter


    }

    private fun setoverview() {
        ViewModelwf.allUsers.observe(viewLifecycleOwner,androidx.lifecycle.Observer{ respon ->


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
        ViewModelwf.allUsersp.observe(viewLifecycleOwner,androidx.lifecycle.Observer{ respon ->

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