package com.example.finalprojectpsi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.example.finalprojectpsi.R
import com.smarteist.autoimageslider.SliderViewAdapter
import com.squareup.picasso.Picasso
import java.util.*

class MySliderImageAdapter() :
    SliderViewAdapter<MySliderImageAdapter.VH>() {
    private var mSliderItems = ArrayList<String>()
    fun renewItems(sliderItems: ArrayList<String>) {
        mSliderItems = sliderItems
        notifyDataSetChanged()
    }

    fun addItem(sliderItem: String) {
        mSliderItems.add(sliderItem)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup): VH {
        val inflate: View = LayoutInflater.from(parent.context).inflate(R.layout.image_holder, null)
        return VH(inflate)
    }

    override fun onBindViewHolder(viewHolder: VH, position: Int) {
        //load image into view

        Picasso.get().load(mSliderItems[position]).fit().into(viewHolder.imageView)
        viewHolder.itemView.setOnClickListener {
            Toast.makeText(viewHolder.itemView.context, "Click was heard!", Toast.LENGTH_SHORT).show()
        }

    }

    override fun getCount(): Int {
        return mSliderItems.size
    }

    inner class VH(itemView: View) : ViewHolder(itemView) {
        var imageView: ImageView = itemView.findViewById(R.id.imageSlider)

    }
}