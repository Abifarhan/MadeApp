package com.abifarhan.madeapp.favorite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.abifarhan.madeapp.core.ui.MovieAdapter
import com.abifarhan.madeapp.detail.DetailMovieActivity
import com.abifarhan.madeapp.favorite.databinding.ActivityFavoriteBinding
import com.abifarhan.madeapp.favorite.di.favoriteModule
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavoriteActivity : AppCompatActivity() {

    private val favoritViewModel: FavoritViewModel by viewModel()

    private var binding: ActivityFavoriteBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        loadKoinModules(favoriteModule)
        val movieAdapter = MovieAdapter()
        movieAdapter.onItemClick = { selectedData ->
            val intent = Intent(this, DetailMovieActivity::class.java)
            intent.putExtra(DetailMovieActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }

        favoritViewModel.favoriteMovie.observe(this,{dataMovie ->
            movieAdapter.setData(dataMovie)
            binding!!.viewEmpty.root.visibility =
                if (dataMovie.isNotEmpty()) View.GONE else View.VISIBLE
        })

        with(binding!!.rvTourism) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = movieAdapter
        }
    }
}