package com.example.culturetriphometask.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.culturetriphometask.R
import com.example.culturetriphometask.model.Article
import com.example.culturetriphometask.model.retrofit.mainRepository
import com.example.culturetriphometask.viewmodel.ArticlesViewModel

class ArticleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
        var rv = findViewById<RecyclerView>(R.id.recycler_view)

        var placesList:  ArrayList<Article> = ArrayList()
        var linearLayout = LinearLayoutManager(this)
        rv.layoutManager=linearLayout
        var adapter = RecyclerViewArticles(placesList)
        rv.adapter=adapter
        var articlesViewModel = ViewModelProvider(this).get(ArticlesViewModel::class.java)

        var repo = mainRepository()
        repo.articleListLD.observe(this, Observer { articles ->

           var ar =  articles
            var test = Int
        })
       articlesViewModel.observeLiveData().observe(this, Observer { articles ->

            var adapter = RecyclerViewArticles(articles)
           Toast.makeText(this,articles.get(0).authorName,Toast.LENGTH_LONG).show()
            rv.adapter=adapter
        })

    }
}
