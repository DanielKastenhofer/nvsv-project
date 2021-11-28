package htl.mynvsnproject.ImageLoading

import android.widget.ImageView
import com.bumptech.glide.Glide
import htl.mynvsnproject.HomePage
import htl.mynvsnproject.ui.home.HomeFragment
import layout.ImageLoader

class GlideImageLoaderHome(private val context: HomeFragment) : ImageLoader {
    override fun loadImage(imageUrl: String, imageView: ImageView) {
        Glide.with(context)
            .load(imageUrl)
            .centerCrop()
            .into(imageView)
    }
}