package com.example.proj3

import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var button01: ImageButton
    private lateinit var button02: ImageButton
    private lateinit var button03: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize Views
        imageView = findViewById(R.id.imageView)
        button01 = findViewById(R.id.button01)
        button02 = findViewById(R.id.button02)
        button03 = findViewById(R.id.button03)

        // Button Click Listeners
        button01.setOnClickListener { changeImageWithAnimation(R.drawable.image01, "Naruto Selected") }
        button02.setOnClickListener { changeImageWithAnimation(R.drawable.image02, "Bleach Selected") }
        button03.setOnClickListener { changeImageWithAnimation(R.drawable.image03, "Fairy Tail Selected") }
    }

    private fun changeImageWithAnimation(imageResId: Int, message: String) {
        // Cross-fade animation
        val fadeOut = AlphaAnimation(1f, 0f).apply { duration = 500 }
        val fadeIn = AlphaAnimation(0f, 1f).apply { duration = 500 }

        imageView.startAnimation(fadeOut)
        imageView.setImageResource(imageResId)
        imageView.startAnimation(fadeIn)

        // Show Toast message
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
