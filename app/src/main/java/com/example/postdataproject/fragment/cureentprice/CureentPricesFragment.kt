package com.example.postdataproject.fragment.cureentprice

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer

import com.example.postdataproject.databinding.FragmentCureentPricesBinding
import com.example.postdataproject.util.NetworkResult
import com.example.postdataproject.util.snackBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CureentPricesFragment : Fragment() {

    private var _binding:FragmentCureentPricesBinding ? = null
    private val binding get() = _binding!!
    private val viewmodelsecode: ViewModelSecond by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentCureentPricesBinding.inflate(inflater,container,false)

        setupUi()
        setObservers()

        binding.lifecycleOwner=this

        return  binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



    private fun setupUi() {
        viewmodelsecode.getPost2()
    }


    private fun setObservers() {
        viewmodelsecode.allUsers.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is NetworkResult.Error -> {
                    response.message?.snackBar(requireView(), requireContext())
                }
                is NetworkResult.Loading -> {
                    // show loading indicator or shimmer layout
                    //binding.recyclerviewmain.showShimmer() // to start showing shimmer

//                    Handler().postDelayed(Runnable {
//                        binding.recyclerviewmain.hideShimmer() // to hide shimmer
//                    } as Runnable, 3000)

                }
                is NetworkResult.Success -> {
                    response.data?.let {
                        Log.e("DATA",it.toString())
                        binding.currentdata = response.data
                        //binding.currentdata = it?.first()
                    }
                }
            }
        })

    }

}