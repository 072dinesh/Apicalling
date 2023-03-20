package com.example.postdataproject.fragment.publicpostfromwordpress

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.postdataproject.databinding.ItemmakeupBinding
import com.example.postdataproject.databinding.ItemwordpressBinding
import com.example.postdataproject.fragment.makeupbrand.MakeupAdapters
import com.example.postdataproject.model.MekepdataItem
import com.example.postdataproject.model.PublicdataItem
import com.example.postdataproject.util.DiffUtilExt




class PublicAdapterMain : RecyclerView.Adapter<PublicAdapterMain.MyViewHolder>() {



    private var callList = emptyList<PublicdataItem>()

    class MyViewHolder(private val binding: ItemwordpressBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            currentItem: PublicdataItem,

            ) {

            binding.itemword = currentItem

            var chidadp = PublicAdapter()
            binding.recyclerviewwp.layoutManager = LinearLayoutManager(binding.root.context,
                LinearLayoutManager.HORIZONTAL,false)
            binding.recyclerviewwp.adapter = chidadp
            chidadp.setData(currentItem.links?.wpTerm?.filterNotNull() ?: emptyList())


        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemwordpressBinding.inflate(layoutInflater, parent, false)
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


    fun setData(Result: List<PublicdataItem>) {
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