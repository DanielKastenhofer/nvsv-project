package htl.mynvsnproject.model

data class MovieUiModel(
    val title: String,
    val description: String,
    val rating: String,
    val imageUrl: String,
    val genre: Genre,
)
