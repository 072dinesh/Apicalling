package com.example.postdataproject.fragment.publicpostfromwordpress

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.postdataproject.databinding.ItemmaketestBinding
import com.example.postdataproject.databinding.Itemwordpressterm2Binding
import com.example.postdataproject.model.ProductColor
import com.example.postdataproject.model.WpTerm
import com.example.postdataproject.util.DiffUtilExt


class PublicAdapter: RecyclerView.Adapter<PublicAdapter.MyViewHolder>() {

    //private var listData : List<GridViewData>?=null

    private var callList = emptyList<WpTerm>()

    class MyViewHolder(private val binding: Itemwordpressterm2Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            currentItem: WpTerm

//            onMainClick: (ExtendedIngredient) -> Unit,

        ) {

            binding.itemwpterm = currentItem
//            binding.root.setOnClickListener {
//                onMainClick(currentItem)
//            }

        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = Itemwordpressterm2Binding.inflate(layoutInflater, parent, false)
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


    fun setData(Result: List<WpTerm>) {
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