package com.khavanski.holyrandom

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var numbers: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        button.setOnClickListener {
            val random = Random.nextInt(0, 100)
            numbers.text = random.toString()
        }
    }

    private fun initViews() {
        button = findViewById(R.id.button)
        numbers = findViewById(R.id.numbers)
    }
}