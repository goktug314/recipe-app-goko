package com.student.recipes

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

data class FoodItem(
    val name: String,
    val calories: Int,
    val protein: Double,
    val carbs: Double,
    val fat: Double
)

class MainActivity : AppCompatActivity() {

    private val foods = listOf(
        FoodItem("Menemen (1 Porsiyon)", 220, 10.0, 8.0, 16.0),
        FoodItem("Mercimek Çorbası (1 Kase)", 180, 8.5, 26.0, 5.0),
        FoodItem("Karnıyarık (1 Adet)", 350, 12.0, 18.0, 25.0),
        FoodItem("Pirinç Pilavı (1 Porsiyon)", 280, 4.5, 48.0, 8.0),
        FoodItem("Tavuk Sote (1 Porsiyon)", 310, 32.0, 6.0, 17.0),
        FoodItem("Spagetti (1 Porsiyon)", 330, 11.0, 58.0, 5.0),
        FoodItem("Lahmacun (1 Adet)", 240, 12.0, 32.0, 8.0),
        FoodItem("Mantı (1 Porsiyon)", 420, 16.0, 62.0, 14.0)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(48, 48, 48, 48)
            setBackgroundColor(Color.parseColor("#F8F9FA"))
        }

        val titleText = TextView(this).apply {
            text = "NutriFit 🥗"
            textSize = 28f
            setTypeface(null, Typeface.BOLD)
            setTextColor(Color.parseColor("#2C3E50"))
            gravity = Gravity.CENTER
        }
        mainLayout.addView(titleText)

        val subTitleText = TextView(this).apply {
            text = "Akıllı Kalori ve Besin Değeri Hesaplayıcı"
            textSize = 14f
            setTextColor(Color.parseColor("#7F8C8D"))
            gravity = Gravity.CENTER
            setPadding(0, 8, 0, 32)
        }
        mainLayout.addView(subTitleText)

        val spinnerLabel = TextView(this).apply {
            text = "Yemek / Besin Seçimi:"
            textSize = 16f
            setTypeface(null, Typeface.BOLD)
            setTextColor(Color.parseColor("#34495E"))
            setPadding(0, 16, 0, 8)
        }
        mainLayout.addView(spinnerLabel)

        val spinner = Spinner(this)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, foods.map { it.name })
        spinner.adapter = adapter
        mainLayout.addView(spinner)

        val resultCard = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(32, 32, 32, 32)
            setBackgroundColor(Color.WHITE)
        }

        val resultTitle = TextView(this).apply {
            text = "Hesaplanan Değerler"
            textSize = 18f
            setTypeface(null, Typeface.BOLD)
            setTextColor(Color.parseColor("#27AE60"))
            setPadding(0, 0, 0, 16)
        }
        resultCard.addView(resultTitle)

        val calText = TextView(this).apply { textSize = 16f }
        val proteinText = TextView(this).apply { textSize = 16f }
        val carbsText = TextView(this).apply { textSize = 16f }
        val fatText = TextView(this).apply { textSize = 16f }

        resultCard.addView(calText)
        resultCard.addView(proteinText)
        resultCard.addView(carbsText)
        resultCard.addView(fatText)

        mainLayout.addView(resultCard)
        setContentView(mainLayout)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedFood = foods[position]
                calText.text = "🔥 Kalori: ${selectedFood.calories} kcal"
                proteinText.text = "🥩 Protein: ${selectedFood.protein} g"
                carbsText.text = "🍞 Karbonhidrat: ${selectedFood.carbs} g"
                fatText.text = "🥑 Yağ: ${selectedFood.fat} g"
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }
}