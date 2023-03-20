package com.example.postdataproject.fragment.user

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.postdataproject.databinding.FragmentRendomUserBinding
import com.example.postdataproject.util.NetworkResult
import com.example.postdataproject.util.snackBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RendomUserFragment : Fragment() {

    private var _binding: FragmentRendomUserBinding? = null
    private val binding get() = _binding!!
    private val viewmodeltv: ViewModelUser by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRendomUserBinding.inflate(inflater,container,false)


        setupUi()
        setingredients()



        binding.lifecycleOwner=this

        // viewmodelcurr.updateds.value = "hellow"
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



    private fun setupUi() {


        viewmodeltv.getPostuser()


    }


    private fun setingredients() {
        viewmodeltv.allUsers.observe(viewLifecycleOwner, Observer { response ->


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


                        response.data?.results.let {
                            //Log.e("DATA", it.toString())
                            binding.userdatas = it?.first()
                           // binding.userdatas = it?.

                            //viewmodelusers.gender.value = it?.gender?.toString()
                        }

                            //viewmodelusers.gender.value=it?.gender.toString()
                        //viewmodelcurr.updatedISO.value=it?.updatedISO.toString()







                }
            }


        })

    }



}