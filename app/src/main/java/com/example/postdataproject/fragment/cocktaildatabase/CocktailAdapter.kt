package com.example.postdataproject.fragment.cocktaildatabase

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.postdataproject.databinding.ItemcocktailBinding
import com.example.postdataproject.databinding.ItemuslayoutBinding
import com.example.postdataproject.model.Data
import com.example.postdataproject.model.Drink
import com.example.postdataproject.util.DiffUtilExt




class CocktailAdapter  : RecyclerView.Adapter<CocktailAdapter.MyViewHolder>() {

    //private var listData : List<GridViewData>?=null

    private var callList = emptyList<Drink>()

    class MyViewHolder(private val binding: ItemcocktailBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            currentItem: Drink,
//            onMainClick: (ExtendedIngredient) -> Unit,

        ) {

            binding.itemcocktail = currentItem
//            binding.root.setOnClickListener {
//                onMainClick(currentItem)
//            }

        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemcocktailBinding.inflate(layoutInflater, parent, false)
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


    fun setData(Result: List<Drink>) {
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