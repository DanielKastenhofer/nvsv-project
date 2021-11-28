package htl.mynvsnproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import htl.mynvsnproject.model.MovieUiModel
import htl.mynvsnproject.model.MovieViewHolder
import layout.ImageLoader

class MoviesAdapter (
    private val layoutInflater: LayoutInflater,
    private val imageLoader: ImageLoader,
    //private val onClickListener: MovieViewHolder.OnClickListener
    ) : RecyclerView.Adapter<MovieViewHolder>() {
        private val movieData = mutableListOf<MovieUiModel>()
        fun setData(catsData: List<MovieUiModel>) {
            this.movieData.clear()
            this.movieData.addAll(catsData)
            notifyDataSetChanged()
        }
        override fun onCreateViewHolder(parent: ViewGroup,
                                        viewType: Int): MovieViewHolder {
            val view = layoutInflater.inflate(R.layout.item_movie,
                parent, false)
            return MovieViewHolder(view, imageLoader,/* object :
                MovieViewHolder.OnClickListener {
                override fun onItemClick(data: MovieUiModel) =
                    onClickListener.onItemClick(data)
            }*/)
        }
        override fun getItemCount() = movieData.size
        override fun onBindViewHolder(holder: MovieViewHolder,
                                      position: Int) {
            holder.bindData(movieData[position])
        }
    }