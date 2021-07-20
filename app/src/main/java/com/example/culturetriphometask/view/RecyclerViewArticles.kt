package com.example.culturetriphometask.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.culturetriphometask.R
import com.example.culturetriphometask.model.Article

import com.example.culturetriphometask.model.retrofit.Articles
import com.example.culturetriphometask.view.RecyclerViewArticles.*


class RecyclerViewArticles(articles:ArrayList<Article>): RecyclerView.Adapter<ArticlesHolder>()  {


    var articles1 = articles

    class ArticlesHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        var imageView = itemView.findViewById<ImageView>(R.id.imageView)


           fun bindView(article:Article)

           {
               Glide.with(itemView)  //2
                       .load(article.imageUrl) //3
                       .centerCrop() //4
                       .into(imageView) //8


           }
    }


    var articles=articles
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesHolder {


        var mainView =LayoutInflater.from(parent.context).
        inflate(R.layout.recycler_view_items,parent,false)

        return ArticlesHolder(mainView)
    }

    override fun onBindViewHolder(holder: ArticlesHolder, position: Int) {

        holder.bindView(articles.get(position))
    }

    override fun getItemCount(): Int {

        return articles.size
    }


}
