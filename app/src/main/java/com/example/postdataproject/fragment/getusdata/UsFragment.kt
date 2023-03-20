package com.example.postdataproject.fragment.getusdata

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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import com.example.postdataproject.R
import com.example.postdataproject.databinding.FragmentUnivarcityBinding
import com.example.postdataproject.databinding.FragmentUsBinding
import com.example.postdataproject.fragment.univarcity.UnivarAdepter
import com.example.postdataproject.fragment.univarcity.ViewModelUni
import com.example.postdataproject.model.Data
import com.example.postdataproject.model.TestdataItem
import com.example.postdataproject.util.NetworkResult
import com.example.postdataproject.util.snackBar
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.internal.addHeaderLenient
import timber.log.Timber
import java.util.*
import kotlin.collections.ArrayList

@AndroidEntryPoint
class UsFragment : Fragment() {
    private var _binding: FragmentUsBinding? = null
    private val binding get() = _binding!!
    private val viewmodelsecode: ViewModelus by viewModels()
    private lateinit var adapter: UsAdepter
    private lateinit var adapters: SourceAdaper

    private var lastquery = ""

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUsBinding.inflate(inflater,container,false)


        // Inflate the layout for this fragment

        setupUi()
        setoverview()
        //setobserverss()
        return binding.root
    }



    private fun setupUi() {
        adapter = UsAdepter()
        adapters = SourceAdaper()
//        // viewmodelsecode.getPost3()
//        var list = ArrayList<Data>()
//        Log.e("listdata", "$list")
//        //Log.e("DATA", it.toString())
//        for (i in list) {
//
//            if (i?.nation?.lowercase(Locale.ROOT)!!.contains(binding.searchView.query)) {
//
//                list.add(i)
//            }
//
//        }
//        if (list.isEmpty()) {
//            //Toast.makeText(requireContext(),"error",Toast.LENGTH_SHORT).show()
//
//        } else {
//            Timber.e(list.toString())
//
//            adapter.setData(list)
//        }
//        viewmodelsecode.getAllUsdata("")


        binding.recyclerviewus.layoutManager = LinearLayoutManager(requireContext())

        binding.recyclerviewus.adapter = adapter

        binding.recyclerviews.layoutManager = LinearLayoutManager(requireContext())

        binding.recyclerviews.adapter = adapters


//        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                if (!query.isNullOrEmpty() && query != lastquery) {
//                    lastquery = query
//                    viewmodelsecode.getAllUsdata(query.toString())
//                }
//                return true
//
//            }
//
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                // viewmodel.getfood(newText.toString())
//                if (!newText.isNullOrEmpty() && newText != lastquery) {
//                    lastquery = newText
//                    viewmodelsecode.getAllUsdata(newText.toString())
//                }
//
//                return true
//            }
//
//        })

    }


    private fun setoverview() {
        viewmodelsecode.allUsers.observe(viewLifecycleOwner,androidx.lifecycle.Observer{ respon ->


            when (respon) {
                is NetworkResult.Error -> {
                    respon.message?.snackBar(requireView(), requireContext())
                }
                is NetworkResult.Loading -> {

                    //binding.recyclerview.showShimmer() // to start showing shimmer

                }
                is NetworkResult.Success -> {
                    respon.data?.data.let {

                        //binding.recyclerview.hideShimmer()
                        //var list = kotlin.collections.ArrayList<Data>()
                        adapter.setData(it?.filterNotNull()?: emptyList())
                        //adapter.setData()

                    }
                    respon.data?.source.let {

                        adapters.setData((it?.filterNotNull()?: emptyList()))

                    }

                }
            }

        })


    }





//    @RequiresApi(Build.VERSION_CODES.M)
//    private fun setobserverss() {
//
//        viewmodelsecode.allUsers.observe(viewLifecycleOwner) {
//
//            it.data?.let {
//
//
//
//
//            }
//
//
//        }
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}