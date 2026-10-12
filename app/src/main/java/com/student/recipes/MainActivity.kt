package com.student.recipes

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val textView = TextView(this).apply {
            text = "Recipe App Loaded Successfully!\n\nRecipes from JSON:\n" + loadJsonFromAssets()
            textSize = 16f
            setPadding(40, 40, 40, 40)
        }
        setContentView(textView)
    }

    private fun loadJsonFromAssets(): String {
        return try {
            val inputStream = assets.open("recipes.json")
            BufferedReader(InputStreamReader(inputStream)).use { it.readText() }
        } catch (e: Exception) {
            "Error loading recipes"
        }
    }
}