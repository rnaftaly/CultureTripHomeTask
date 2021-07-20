package com.example.culturetriphometask.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.culturetriphometask.R
import com.example.culturetriphometask.viewmodel.ArticlesViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         var vm = ArticlesViewModel()
       var button:Button=findViewById(R.id.button)
        val intent = Intent(this, ArticleActivity::class.java)

         button.setOnClickListener{

                vm.Articles()

                startActivity(intent)

         }

    }
}