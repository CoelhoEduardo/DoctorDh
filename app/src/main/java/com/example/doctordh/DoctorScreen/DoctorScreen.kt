package com.example.doctordh.DoctorScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.doctordh.Adapters.DoctorAdapter
import com.example.doctordh.R
import com.example.doctordh.data.model.DoctorResponse
import com.example.doctordh.data.model.DoctorsData
import com.example.doctordh.viewmodel.DoctorViewModel

class DoctorScreen : AppCompatActivity() {

    private val doctorViewModel: DoctorViewModel by viewModels()

    private val loadingDoctor: FrameLayout
        get() = findViewById(R.id.loading_doctor)
    private val adapter = DoctorAdapter()
    private val recycler: RecyclerView
        get() = findViewById(R.id.recyclerDoctor)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor_screen)

        recycler.adapter = adapter
        setScrollView()

        doctorViewModel.loadDoctors(1)

        observeDoctor()

    }

    private fun setScrollView(){
        var pagelist = 2

        recycler.run{
        addOnScrollListener(object: RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val target = recyclerView.layoutManager as LinearLayoutManager
                val totalCountItems = target.itemCount
                val lastItemVisible = target.findLastVisibleItemPosition()

                val lastItem = lastItemVisible + 5 >= totalCountItems

                if((totalCountItems > 0 && lastItem) && pagelist <= doctorViewModel.limitPages){
                    pagelist++
                    doctorViewModel.loadDoctors(pagelist)
                }
            }

        })
    }
    }

    private fun addData(){
        adapter.updateList(MutableList(10){
            DoctorsData(
                id = "123",
                photo = "https://media.istockphoto.com/photos/portrait-of-mature-male-doctor-wearing-white-coat-standing-in-picture-id1203995945?k=20&m=1203995945&s=612x612&w=0&h=g0_ioNezBqP0NXrR_36-A5NDHIR0nLabFFrAQVk4PhA=",
                name = "Doctor ${it+1}",
                specialization = "Dentist",
                classification = 4.75,
                experience = 7,
                patientStories = 99,
                views = 200
            )
        })
    }
    fun observeDoctor(){
        doctorViewModel.loading.observe(this) { loadingDoctor.isVisible = it }
        doctorViewModel.error.observe(this){
            if (it)
                Toast.makeText(this,"Deu Errão", Toast.LENGTH_LONG).show()
        }
        doctorViewModel.doctors.observe(this){
            Toast.makeText(this,"Sucess", Toast.LENGTH_LONG).show()
            adapter.updateList(it.doctors)

        }
    }
}