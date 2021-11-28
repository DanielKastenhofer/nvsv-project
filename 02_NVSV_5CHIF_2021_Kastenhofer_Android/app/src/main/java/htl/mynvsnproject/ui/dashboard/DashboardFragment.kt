package htl.mynvsnproject.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import htl.mynvsnproject.FULL_NAME_KEY
import htl.mynvsnproject.ImageLoading.GlideImageLoaderDashboard
import htl.mynvsnproject.MoviesAdapter
import htl.mynvsnproject.R
import htl.mynvsnproject.databinding.FragmentDashboardBinding
import htl.mynvsnproject.model.Genre
import htl.mynvsnproject.model.MovieUiModel

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val moviesAdapter by lazy {
        MoviesAdapter(
            layoutInflater,
            GlideImageLoaderDashboard(this),
            /*object : MovieViewHolder.OnClickListener{} {
                override fun onItemClick(data: MovieUiModel) =

            }*/
        ) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val recyclerView: RecyclerView = binding.recyclerView
        val root: View = binding.root

        recyclerView.adapter = moviesAdapter
        recyclerView.layoutManager = LinearLayoutManager(getActivity(),
            LinearLayoutManager.VERTICAL, false)
        moviesAdapter.setData(
            listOf(
                MovieUiModel(
                    "Star Wars",
                    "Luke Skywalker joins forces with a Jedi Knight, a cocky pilot, a Wookiee and two droids to save the galaxy from the Empire's" +
                            " world-destroying battle station, while also attempting to rescue Princess Leia from the mysterious Darth Vader.",
                    "5/5 Stars",
                    "https://cdn2.thecatapi.com/images/DBmIBhhyv.jpg",
                    Genre.Action
                ),
                MovieUiModel(
                    "LOTR",
                    "Luke Skywalker joins forces with a Jedi Knight, a cocky pilot, a Wookiee and two droids to save the galaxy from the Empire's" +
                            " world-destroying battle station, while also attempting to rescue Princess Leia from the mysterious Darth Vader.",
                    "5/5 Stars",
                    "https://cdn2.thecatapi.com/images/DBmIBhhyv.jpg",
                    Genre.Fantasy
                ),
                MovieUiModel(
                    "LOTR",
                    "Luke Skywalker joins forces with a Jedi Knight, a cocky pilot, a Wookiee and two droids to save the galaxy from the Empire's" +
                            " world-destroying battle station, while also attempting to rescue Princess Leia from the mysterious Darth Vader.",
                    "5/5 Stars",
                    "https://cdn2.thecatapi.com/images/DBmIBhhyv.jpg",
                    Genre.Fantasy
                )
            )
        )

        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}