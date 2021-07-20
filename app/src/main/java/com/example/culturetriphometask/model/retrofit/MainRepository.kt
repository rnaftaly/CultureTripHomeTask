package com.example.culturetriphometask.model.retrofit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.culturetriphometask.model.Article
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainRepository {


    var articleList :ArrayList<Article> = ArrayList()
    var articleListLD = MutableLiveData<ArrayList<Article>>()
    suspend fun getArticlesFromAPI()

    {


        CoroutineScope(Dispatchers.IO).launch {
            val service = RetrofitFactory.makeRetrofitService()

            val response = service.getArticles()


            if (response.isSuccessful)

            {

                var articles =  response.body()

                 createArticleObjects(articles)



            } else {


                var int1=0
            }

        }

    }
    fun createArticleObjects(articles: Articles?)

    {

        for( i in 0 .. articles!!.data.size -1)

        {
            var article=Article()
            article.title=articles.data.get(i).title
            article.authorName=articles.data.get(i).author.authorName
            article.creationTime=articles.data.get(i).metaData.creationTime
            article.authorImageUrl=articles.data.get(i).author.authorAvatar.imageUrl
            article.imageUrl=articles.data.get(i).imageUrl
            articleList.add(article)

        }


        articleListLD.postValue(articleList)

    }

    fun getMutbleLiveData () :MutableLiveData<ArrayList<Article>>

    {

        return articleListLD
    }
}