package com.example.filmoneriuygulamasi

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.filmoneriuygulamasi.KitapAdapter.ViewHolder
import com.example.filmoneriuygulamasi.databinding.CardBookBinding

class KitapAdapter(var list :List<Kitaplar>) : RecyclerView.Adapter<ViewHolder>(){

    @SuppressLint("NotifyDataSetChanged")
    fun filtering(newKitapList: ArrayList<Kitaplar>) {
        list = newKitapList
        notifyDataSetChanged()
    }

    inner class ViewHolder(var kitapBinding : CardBookBinding) : RecyclerView.ViewHolder(kitapBinding.root){
        fun bind(result : Kitaplar){
            kitapBinding.apply {
                itemClickListener(result)
            }
        }
        fun itemClickListener(result: Kitaplar) {
            kitapBinding.imageView.apply {
                setOnClickListener {
                    val gecisBook = KitapFragmentDirections.actionKitapFragmentToOneriFragment2(null,result)
                    findNavController().navigate(gecisBook)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val kitapBinding = CardBookBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(kitapBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = list[position]
        holder.kitapBinding.kitapNesnesi = result
        holder.bind(result)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}
