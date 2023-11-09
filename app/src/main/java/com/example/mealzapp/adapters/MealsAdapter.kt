package com.example.mealzapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.entities.Category
import com.example.domain.entities.MealsResponse
import com.example.mealzapp.databinding.ItemCategoryBinding

class MealsAdapter(private val categoryList: List<Category>): RecyclerView.Adapter<MealsAdapter.MealsViewHolder>() {


    class MealsViewHolder(item: ItemCategoryBinding): RecyclerView.ViewHolder(item.root){

        val item = item
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealsViewHolder {
        return MealsViewHolder(ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
       return this.categoryList.size
    }

    override fun onBindViewHolder(holder: MealsViewHolder, position: Int) {
       val model = categoryList[position]

        holder.item.tvTitle.text = model.strCategory
        holder.item.tvDescription.text = model.strCategoryDescription
        Glide.with(holder.item.root.context).load(model.strCategoryThumb).into(holder.item.ivImage)
    }

//    fun setData(categoryList: MealsResponse?){
//        if (categoryList != null) {
//            this.categoryList = categoryList
//        }
//    }
}