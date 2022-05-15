package com.example.filmoneriuygulamasi

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.filmoneriuygulamasi.databinding.CardItemBinding

class FilmAdapter(var list : List<Filmler>) : RecyclerView.Adapter<FilmAdapter.ViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun filtering(newFilmList: ArrayList<Filmler>) {
        list = newFilmList
        notifyDataSetChanged()

    }

    class ViewHolder(var filmBinding: CardItemBinding) : RecyclerView.ViewHolder(filmBinding.root) {
        fun bind(item: Filmler){
            filmBinding.apply {
                itemClickListener(item)
            }
        }
        fun itemClickListener(item: Filmler) {
            filmBinding.imageView.apply {
                setOnClickListener {
                    val gecis = FilmFragmentDirections.actionFilmFragment2ToOneriFragment2(item,null)
                    findNavController().navigate(gecis)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val filmBinding = CardItemBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(filmBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.filmBinding.filmNesnesi = item
        holder.bind(item)
    }
    override fun getItemCount(): Int {
        return list.size
    }
}
