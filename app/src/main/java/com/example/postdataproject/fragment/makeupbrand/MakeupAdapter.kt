package com.example.postdataproject.fragment.makeupbrand

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.postdataproject.databinding.ItemmakeupBinding
import com.example.postdataproject.databinding.ItemunivarsityBinding
import com.example.postdataproject.model.MekepdataItem
import com.example.postdataproject.model.ProductColor
import com.example.postdataproject.model.TestdataItem
import com.example.postdataproject.util.DiffUtilExt


class MakeupAdapter : RecyclerView.Adapter<MakeupAdapter.MyViewHolder>() {



    private var callList = emptyList<MekepdataItem>()

    class MyViewHolder(private val binding: ItemmakeupBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            currentItem: MekepdataItem,



        ) {

            binding.itemmakeup = currentItem

            var chidadp = MakeupAdapters()
            binding.recyclerviews.layoutManager = LinearLayoutManager(binding.root.context,LinearLayoutManager.HORIZONTAL,false)
            binding.recyclerviews.adapter = chidadp
            chidadp.setData(currentItem.productColors?.filterNotNull() ?: emptyList())


        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemmakeupBinding.inflate(layoutInflater, parent, false)
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


    fun setData(Result: List<MekepdataItem>) {
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
