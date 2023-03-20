package com.example.postdataproject.fragment.getusdata

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.postdataproject.databinding.Itemuslayout2Binding
import com.example.postdataproject.databinding.ItemuslayoutBinding
import com.example.postdataproject.model.Data
import com.example.postdataproject.model.Source
import com.example.postdataproject.util.DiffUtilExt



class SourceAdaper  : RecyclerView.Adapter<SourceAdaper.MyViewHolder>() {

    //private var listData : List<GridViewData>?=null

    private var callList = emptyList<Source>()

    class MyViewHolder(private val binding: Itemuslayout2Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            currentItem: Source,
//            onMainClick: (ExtendedIngredient) -> Unit,

        ) {

            binding.itemusd = currentItem
//            binding.root.setOnClickListener {
//                onMainClick(currentItem)
//            }

        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = Itemuslayout2Binding.inflate(layoutInflater, parent, false)
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


    fun setData(Result: List<Source>) {
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