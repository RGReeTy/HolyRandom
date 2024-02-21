package com.khavanski.holyrandom

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var numbers: TextView
    private lateinit var timer: CountDownTimer

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

        timer = object : CountDownTimer(1500, 100) {
            override fun onTick(millisUntilFinished: Long) {
                val randomNumber = getRandomNumber()
                numbers.text = randomNumber
            }

            override fun onFinish() {
                val randomNumber = getRandomNumber()
                numbers.text = randomNumber
            }

        }

        button.setOnClickListener {
            timer.start()
        }
    }

    private fun getRandomNumber() = Random.nextInt(0, 100).toString()

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