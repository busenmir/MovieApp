package com.example.filmoneriuygulamasi

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("image")
fun setImageResource(imageView: ImageView, resourse: Int) {
    imageView.setImageResource(resourse)
}
