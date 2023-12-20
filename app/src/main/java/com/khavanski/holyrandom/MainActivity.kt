package com.khavanski.holyrandom

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var numbers: TextView

    private val randomString = "random"
    private var random: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        if (savedInstanceState != null) {
            val savedRandom = savedInstanceState.getString(randomString)
            numbers.text = savedRandom
        }

        button.setOnClickListener {
            random = Random.nextInt(0, 100).toString()
            numbers.text = random
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        if (random != null) {
            outState.putString(randomString, random)
        }
        super.onSaveInstanceState(outState)
    }

    private fun initViews() {
        button = findViewById(R.id.button)
        numbers = findViewById(R.id.numbers)
    }
}