package com.example.postdataproject

import android.os.Bundle
import android.provider.DocumentsContract.Root
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.postdataproject.databinding.FragmentCureentPricesBinding
import com.example.postdataproject.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentHomeBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        var view = binding.root



        binding.button.setOnClickListener {
            var action = HomeFragmentDirections.actionHomeFragmentToCureentPricesFragment()
            findNavController().navigate(action)

        }
        binding.button2.setOnClickListener {

            var action = HomeFragmentDirections.actionHomeFragmentToRendomUserFragment()
            findNavController().navigate(action)
        }
        binding.button3.setOnClickListener {
            var action = HomeFragmentDirections.actionHomeFragmentToUnivarcityFragment()
            findNavController().navigate(action)
        }
        binding.button4.setOnClickListener {
            var action = HomeFragmentDirections.actionHomeFragmentToUsFragment()
            findNavController().navigate(action)
        }
        binding.button5.setOnClickListener {
            var action = HomeFragmentDirections.actionHomeFragmentToCocktailFragment()
            findNavController().navigate(action)

        }
        binding.button6.setOnClickListener {
            var action = HomeFragmentDirections.actionHomeFragmentToCongressMembersFragment()
            findNavController().navigate(action)
        }
        binding.button7.setOnClickListener {
            var action = HomeFragmentDirections.actionHomeFragmentToMakeupBrandsFragment()
            findNavController().navigate(action)
        }
        binding.button8.setOnClickListener {
            var action = HomeFragmentDirections.actionHomeFragmentToWordpressFragment()
            findNavController().navigate(action)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}