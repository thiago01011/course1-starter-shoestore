package com.udacity.shoestore

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.udacity.shoestore.models.Shoe

class ShoeAdapter(
    private val context: Context,
    private val list: MutableList<Shoe>,
    private val viewModel: AppViewModel
) : RecyclerView.Adapter<ShoeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_2, parent, false)
        return ShoeViewHolder(view, context)
    }

    override fun onBindViewHolder(holder: ShoeViewHolder, position: Int) {
        val shoeData = list[position]

        holder.shoeText.text = shoeData.name
        holder.sizeText.text = shoeData.size.toString()
        holder.companyText.text = shoeData.company.toString()
        holder.descriptionText.text = shoeData.description.toString()
    }

    override fun getItemCount(): Int = list.size
}

class ShoeViewHolder(view: View, context: Context): RecyclerView.ViewHolder(view) {

    val shoeText: TextView = view.findViewById(R.id.shoe_text)
    val sizeText: TextView = view.findViewById(R.id.size_text)
    val companyText: TextView = view.findViewById(R.id.company_text)
    val descriptionText: TextView = view.findViewById(R.id.description_text)
}