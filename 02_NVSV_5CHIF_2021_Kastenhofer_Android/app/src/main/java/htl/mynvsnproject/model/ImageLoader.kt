package layout

import android.widget.ImageView

public interface ImageLoader {
    fun loadImage(imageUrl: String, imageView: ImageView)
}