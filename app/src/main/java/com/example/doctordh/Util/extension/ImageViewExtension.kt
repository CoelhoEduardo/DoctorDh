package com.example.doctordh.Util.extension

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(url: String){
    Glide.with(this.context).load(url).centerCrop().into(this)

}