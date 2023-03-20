package com.example.postdataproject.fragment.congressmembers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.postdataproject.databinding.ItemcocktailBinding
import com.example.postdataproject.databinding.ItemcongressBinding
import com.example.postdataproject.model.CongressdataItem
import com.example.postdataproject.model.Drink
import com.example.postdataproject.util.DiffUtilExt



class CongressAdapter  : RecyclerView.Adapter<CongressAdapter.MyViewHolder>() {

    //private var listData : List<GridViewData>?=null

    private var callList = emptyList<CongressdataItem>()

    class MyViewHolder(private val binding: ItemcongressBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            currentItem: CongressdataItem,
//            onMainClick: (ExtendedIngredient) -> Unit,

        ) {

            binding.itemconges = currentItem
//            binding.root.setOnClickListener {
//                onMainClick(currentItem)
//            }

        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemcongressBinding.inflate(layoutInflater, parent, false)
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


    fun setData(Result: List<CongressdataItem>) {
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
