package com.example.doctordh.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.doctordh.R
import com.example.doctordh.data.model.DoctorsData
import com.example.doctordh.viewHolder.DoctorViewHolder

class DoctorAdapter : RecyclerView.Adapter<DoctorViewHolder>(){
    private val doctors: MutableList<DoctorsData> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return DoctorViewHolder(layoutInflater.inflate(R.layout.item_doctor, parent, false))
    }

    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {
        holder.bind(doctors[position])
    }

    override fun getItemCount() = doctors.size


    fun updateList(newItems: List<DoctorsData>) {
        doctors.addAll(newItems)
        notifyDataSetChanged()
    }



}