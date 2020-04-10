package com.example.td4_exo2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageArray  = resources.obtainTypedArray(R.array.bookImage)
        val n = imageArray.length()
        val scrollview = findViewById<LinearLayout>(R.id.scroll_view)
        val leftLayout = findViewById<LinearLayout>(R.id.left_layout)
        for (i in 0..n){
            val imageView = ImageView(this)
            val imageViewLarge = ImageView(this)
            imageView.setImageResource(imageArray.getResourceId(i, -1))
            imageViewLarge.setImageResource(imageArray.getResourceId(i, -1))
            imageView.setOnClickListener({showDetailBook(i)})
            imageViewLarge.setOnClickListener({showDetailBookLarge(i)})
            scrollview?.addView(imageView)
            leftLayout?.addView(imageViewLarge)
        }

    }

    fun showDetailBook(ind:Int){

        val intent = Intent(this, DetailBook::class.java).apply {
            putExtra("IND", ind)
        }
        startActivity(intent)
    }

    @SuppressLint("Recycle")
    fun showDetailBookLarge(ind:Int){
        val transaction = manager.beginTransaction()
        val fragement = BookFragement.newInstance(ind)
        transaction.replace(R.id.right_layout, fragement)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    @SuppressLint("Recycle")
    fun showLarge(ind:Int){
        var imageView = findViewById<ImageView>(R.id.writerImageLarge)
        val imageArray  = resources.obtainTypedArray(R.array.writerImage)
        imageView.setImageResource(imageArray.getResourceId(ind, -1))
        val writers = resources.getStringArray(R.array.writers)
        var writer = findViewById<TextView>(R.id.writerLarge)
        writer.text = writers[ind]
        val contents = resources.getStringArray(R.array.contents)
        var content = findViewById<TextView>(R.id.contentLarge)
        content.text = contents[ind]
    }
}
