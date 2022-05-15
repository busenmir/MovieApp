package com.example.filmoneriuygulamasi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.example.filmoneriuygulamasi.databinding.FragmentOneriBinding

class OneriFragment : Fragment() {
    private lateinit var binding: FragmentOneriBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_oneri,container,false)
        movieGelen()
        bookGelen()
        return binding.root
    }
    fun movieGelen() {
        val bundle: OneriFragmentArgs by navArgs()
        val movieGelen = bundle.data
        if (movieGelen != null) {
            binding.imageView.setImageResource(movieGelen.resim)
            binding.textView.text = movieGelen.yazi
            binding.textView2.text = movieGelen.aciklama
        }
    }
    fun bookGelen(){
        val bundle : OneriFragmentArgs by navArgs()
        val bookGelen = bundle.dataBook
        if (bookGelen != null) {
            binding.imageView.setImageResource(bookGelen.resim)
            binding.textView.text = bookGelen.yazi
            binding.textView2.text = bookGelen.aciklama
        }
    }


}


