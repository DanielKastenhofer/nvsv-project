package htl.mynvsnproject.model

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import htl.mynvsnproject.R
import layout.ImageLoader

private const val UNKNOWN_SYMBOL = "?"
class MovieViewHolder(
    private val containerView: View,
    private val imageLoader: ImageLoader,
    //private val onClickListener: OnClickListener
) : RecyclerView.ViewHolder(containerView) {

    private val movieTitleView: TextView = containerView.findViewById(R.id.item_movie_title)
    private val movieDescriptionView: TextView
            by lazy { containerView.findViewById(R.id.item_movie_Description) }
    private val movieRatingView: TextView
            by lazy { containerView.findViewById(R.id.item_movie_rating) }
    private val movieGenreView: TextView
            by lazy { containerView.findViewById(R.id.item_movie_genre) }
    private val catPhotoView: ImageView
            by lazy { containerView.findViewById(R.id.item_movie_photo) }

    fun bindData(movieData: MovieUiModel) {
        //containerView.setOnClickListener { onClickListener.onItemClick(movieData) }
        imageLoader.loadImage(movieData.imageUrl, catPhotoView)
        movieTitleView.text = movieData.title
        movieDescriptionView.text = movieData.description
        movieGenreView.text = when (movieData.genre) {
            Genre.Action -> "Action"
            Genre.Comedy -> "Comedy"
            Genre.Drama -> "Drama"
            Genre.Fantasy -> "Fantasy"
            Genre.Horror -> "Horror"
            Genre.Romatic -> "Romantic"
        }
    }
    interface OnClickListener {
        fun onItemClick(movieData: MovieUiModel)
    }

    fun onClick(){

    }
}