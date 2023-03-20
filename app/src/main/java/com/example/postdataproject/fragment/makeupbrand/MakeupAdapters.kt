package com.example.postdataproject.fragment.makeupbrand

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.postdataproject.databinding.ItemmaketestBinding
import com.example.postdataproject.databinding.ItemmakeupBinding
import com.example.postdataproject.model.MekepdataItem
import com.example.postdataproject.model.ProductColor
import com.example.postdataproject.model.makeitem
import com.example.postdataproject.util.DiffUtilExt




class MakeupAdapters() : RecyclerView.Adapter<MakeupAdapters.MyViewHolder>() {

    //private var listData : List<GridViewData>?=null

    private var callList = emptyList<ProductColor>()

    class MyViewHolder(private val binding: ItemmaketestBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            currentItem: ProductColor,

//            onMainClick: (ExtendedIngredient) -> Unit,

        ) {

            binding.itemmk = currentItem
//            binding.root.setOnClickListener {
//                onMainClick(currentItem)
//            }

        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemmaketestBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }


    override fun getItemCount(): Int {
        return callList.size
    }


    fun setData(Result: List<ProductColor>) {
//        this.callList= user
//        notifyDataSetChanged()

        val userDiffUtil = DiffUtilExt(callList, Result)
        val userDiffUtilResult = DiffUtil.calculateDiff(userDiffUtil)
        callList = Result
        userDiffUtilResult.dispatchUpdatesTo(this)

    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = callList.getOrNull(position)

        currentItem?.let {
            holder.bind(it)
        }
    }

}