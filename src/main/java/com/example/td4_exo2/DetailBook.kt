package com.example.td4_exo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailBook : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_book)
        val ind = intent.getIntExtra("IND", 0)
        var imageView = findViewById<ImageView>(R.id.livre_image)
        val imageArray  = resources.obtainTypedArray(R.array.writerImage)
        imageView.setImageResource(imageArray.getResourceId(ind, -1))
        val writers = resources.getStringArray(R.array.writers)
        var writer = findViewById<TextView>(R.id.auteur_name)
        writer.text = writers[ind]
        val contents = resources.getStringArray(R.array.contents)
        var content = findViewById<TextView>(R.id.content)
        content.text = contents[ind]
    }
}
