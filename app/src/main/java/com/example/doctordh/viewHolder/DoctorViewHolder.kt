package com.example.doctordh.viewHolder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.doctordh.R
import com.example.doctordh.Util.extension.load
import com.example.doctordh.data.model.DoctorsData

class DoctorViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val name = view.findViewById<TextView>(R.id.doctor_name)
    val image = view.findViewById<ImageView>(R.id.item_image)
    val classification = view.findViewById<TextView>(R.id.doctor_classification)
    val experience = view.findViewById<TextView>(R.id.doctor_experience)
    val patient = view.findViewById<TextView>(R.id.patientStories)
    val specialization = view.findViewById<TextView>(R.id.doctor_specialization)

    fun bind(doctor: DoctorsData){
        name.text = doctor.name
        image.load(doctor.photo)
        classification.text = doctor.classification.toString()
        experience.text = doctor.experience.toString()
        patient.text = doctor.patientStories.toString()
        specialization.text = doctor.specialization
    }

}