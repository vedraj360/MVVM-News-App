package com.vdx.newsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.vdx.newsapp.R
import com.vdx.newsapp.db.ArticleDataBase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: NewsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newsRepository = NewsRepository(ArticleDataBase(this))
        val viewModelProvider = NewsViewModelFactory(application, newsRepository)

        viewModel = ViewModelProvider(this, viewModelProvider).get(NewsViewModel::class.java)

        bottomNavigationView.setupWithNavController(navNewsHostFragment.findNavController())
    }
}