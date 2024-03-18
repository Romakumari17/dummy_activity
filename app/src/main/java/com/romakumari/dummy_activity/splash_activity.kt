package com.romakumari.dummy_activity

import android.content.Intent
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.TextPaint
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import com.romakumari.dummy_activity.databinding.ActivitySplashBinding
import java.util.Locale

class splash_activity : AppCompatActivity() {
    lateinit var splash_ScreenBinding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splash_ScreenBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(splash_ScreenBinding.root)
        Handler(Looper.getMainLooper()).postDelayed({
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            this.finish()
        },1000)

//        val welcomeText = findViewById<TextView>(R.id.SplashText)

//        // Load animation
//        val animation = AnimationUtils.loadAnimation(this, R.anim.slide_and_fade_in)
//
//        // Set animation listener to remove the view after animation ends
//        animation.setAnimationListener(object : Animation.AnimationListener {
//            override fun onAnimationStart(animation: Animation) {}
//            override fun onAnimationRepeat(animation: Animation) {}
//            override fun onAnimationEnd(animation: Animation) {
//                // Remove the view from the layout after animation ends
//                welcomeText.visibility = View.INVISIBLE
//            }
//        })

        // Start animation
//        welcomeText.startAnimation(animation)

        //gradient text
        splash_ScreenBinding.SplashText.setText("Welcome".uppercase(Locale.getDefault()))

        val paint: TextPaint = splash_ScreenBinding.SplashText.paint
        val width = paint.measureText("WELCOME")

        val textShader: Shader = LinearGradient(
            0f, 0f, width, paint.textSize,
            intArrayOf(
                Color.parseColor("#AC6FCA"),
                Color.parseColor("#D8CC8C"),
                Color.parseColor("#FFADAD"),
                Color.parseColor("#478AEA"),
                Color.parseColor("#8446CC")
            ), null, Shader.TileMode.CLAMP
        )

        splash_ScreenBinding.SplashText.paint.shader = textShader

    }

    }
