package com.test.gifimageview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gif = findViewById<GIFImageView>(R.id.gif)
        gif.setGIFFromAssets("test2.gif")
        gif.setAutoGIFSize(true)


    }
}
