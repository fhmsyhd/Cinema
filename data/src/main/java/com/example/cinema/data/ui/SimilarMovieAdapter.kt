package com.example.cinema.data.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cinema.data.R
import com.example.cinema.data.databinding.ItemSimilarMovieBinding
import com.example.cinema.data.domain.model.SimilarMovie
import com.example.cinema.data.utils.Constant

class SimilarMovieAdapter: RecyclerView.Adapter<SimilarMovieAdapter.ListViewHolder>() {

    private var listData = ArrayList<SimilarMovie>()
    var onItemClick: ((SimilarMovie) -> Unit)? = null

    fun setData(newListData: List<SimilarMovie>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_similar_movie, parent, false))

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return if (listData.size > 5) {
            5
        } else {
            listData.size
        }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemSimilarMovieBinding.bind(itemView)
        @SuppressLint("SetTextI18n")
        fun bind(data: SimilarMovie) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(Constant.IMAGE_URL + data.posterPath)
                    .into(imgMovie)
                tvTitle.text = data.title
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}