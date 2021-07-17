package com.example.navigationcomponentgyak.movieList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationcomponentgyak.R

class MovieListAdapter(private val movieItemList: List<MovieData>): RecyclerView.Adapter<MovieListAdapter.MyViewHolder>() {



    class MyViewHolder(viewItem: View): RecyclerView.ViewHolder(viewItem){
        val movieImage: ImageView = viewItem.findViewById(R.id.iv_list_item)
        val movieText: TextView = viewItem.findViewById(R.id.tv_list_item)
        val detailsButton: Button = viewItem.findViewById(R.id.btn_list_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false )
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.movieImage.setImageResource(movieItemList[position].movieImage)
        holder.movieText.text = movieItemList[position].movieTitle

        holder.detailsButton.setOnClickListener {
            val action = MovieListFragmentDirections.actionMovieListFragmentToMovieDetailsFragment(
                title = holder.movieText.text.toString(),
                image = movieItemList[position].movieImage,
                //Because in the string-array of movie details, the story is at index 0.
                story = movieItemList[position].movieDetails[0],
                //Because in the string-array of movie details, the directors are at index 1.
                director = movieItemList[position].movieDetails[1],
                //Because in the string-array of movie details, the writers are at index 2.
                writer = movieItemList[position].movieDetails[2],
                //Because in the string-array of movie details, the stars are at index 3.
                stars = movieItemList[position].movieDetails[3])

            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return movieItemList.size
    }
}