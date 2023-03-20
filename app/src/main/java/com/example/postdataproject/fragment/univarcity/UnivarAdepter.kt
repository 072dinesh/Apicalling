package com.example.postdataproject.fragment.univarcity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.postdataproject.databinding.ItemunivarsityBinding
import com.example.postdataproject.model.TestdataItem
import com.example.postdataproject.util.DiffUtilExt

class UnivarAdepter  : RecyclerView.Adapter<UnivarAdepter.MyViewHolder>() {

    //private var listData : List<GridViewData>?=null

    private var callList = emptyList<TestdataItem>()

    class MyViewHolder(private val binding: ItemunivarsityBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            currentItem: TestdataItem,
//            onMainClick: (ExtendedIngredient) -> Unit,

        ) {

            binding.itemview = currentItem
//            binding.root.setOnClickListener {
//                onMainClick(currentItem)
//            }

        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemunivarsityBinding.inflate(layoutInflater, parent, false)
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


    fun setData(Result: List<TestdataItem>) {
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