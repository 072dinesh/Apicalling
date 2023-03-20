package com.example.postdataproject.fragment.congressmembers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.postdataproject.R
import com.example.postdataproject.databinding.FragmentCocktailBinding
import com.example.postdataproject.databinding.FragmentCongressMembersBinding
import com.example.postdataproject.fragment.cocktaildatabase.CocktailAdapter
import com.example.postdataproject.fragment.cocktaildatabase.ViewModelCocktail
import com.example.postdataproject.fragment.getusdata.SourceAdaper
import com.example.postdataproject.fragment.getusdata.UsAdepter
import com.example.postdataproject.util.NetworkResult
import com.example.postdataproject.util.snackBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CongressMembersFragment : Fragment() {

    private var _binding: FragmentCongressMembersBinding? = null
    private val binding get() = _binding!!
    private val ViewModelcs: ViewModelCongressMember by viewModels()
    private lateinit var adapter: CongressAdapter
    //private var lastquery = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCongressMembersBinding.inflate(inflater,container,false)

        setupUi()
        setoverview()
        //setobserverss()
        return binding.root

    }

    private fun setupUi() {
        adapter = CongressAdapter()


        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())

        binding.recyclerview.adapter = adapter



    }

    private fun setoverview() {
        ViewModelcs.allUsers.observe(viewLifecycleOwner,androidx.lifecycle.Observer{ respon ->


            when (respon) {
                is NetworkResult.Error -> {
                    respon.message?.snackBar(requireView(), requireContext())
                }
                is NetworkResult.Loading -> {

                    //binding.recyclerview.showShimmer() // to start showing shimmer

                }
                is NetworkResult.Success -> {
                    respon.data?.let {

                        adapter.setData(it)

                    }


                }
            }

        })


    }



}