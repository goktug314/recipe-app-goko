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
        FoodItem("Izgara Somon & Kuşkonmaz", 450, 38.0, 8.0, 22.0),
        FoodItem("Kinoa Salatası & Avokado", 320, 10.0, 42.0, 14.0),
        FoodItem("Tavuklu Sebzeli Kinoa", 410, 35.0, 38.0, 12.0),
        FoodItem("Mercimek Çorbası", 220, 12.0, 34.0, 5.0),
        FoodItem("Nohutlu Akdeniz Salatası", 350, 14.0, 43.0, 13.0),
        FoodItem("Hindi Köfte & Fırın Sebze", 390, 34.0, 28.0, 15.0),
        FoodItem("Mantarlı Ispanaklı Omlet", 280, 21.0, 9.0, 18.0),
        FoodItem("Yoğurtlu Yulaf Kasesi", 330, 18.0, 46.0, 9.0),
        FoodItem("Fırında Levrek & Brokoli", 370, 36.0, 15.0, 17.0),
        FoodItem("Zeytinyağlı Taze Fasulye", 240, 7.0, 28.0, 12.0),
        FoodItem("Bulgurlu Yeşil Mercimek", 360, 19.0, 58.0, 6.0),
        FoodItem("Ton Balıklı Tam Buğday Dürüm", 390, 32.0, 39.0, 11.0),
        FoodItem("Fırında Sebzeli Mücver", 290, 13.0, 31.0, 13.0),
        FoodItem("Izgara Tavuklu Sezar Salata", 420, 39.0, 18.0, 22.0),
        FoodItem("Kabaklı Hindi Sote", 340, 36.0, 17.0, 14.0),
        FoodItem("Avokadolu Haşlanmış Yumurta Tostu", 350, 17.0, 32.0, 18.0),
        FoodItem("Kıymalı Karnabahar", 370, 29.0, 19.0, 19.0),
        FoodItem("Domatesli Kabak Çorbası", 190, 7.0, 26.0, 7.0),
        FoodItem("Fırında Tavuklu Tatlı Patates", 430, 37.0, 46.0, 10.0),
        FoodItem("Peynirli Akdeniz Omleti", 310, 23.0, 10.0, 20.0),
        FoodItem("Karidesli Sebze Wok", 340, 31.0, 29.0, 11.0),
        FoodItem("Fırında Patlıcanlı Nohut", 360, 15.0, 49.0, 12.0),
        FoodItem("Çilekli Chia Puding", 250, 9.0, 29.0, 12.0),
        FoodItem("Yoğurtlu Tavuklu Bulgur", 440, 38.0, 48.0, 11.0),
        FoodItem("Pancarlı Keçi Peynirli Salata", 320, 13.0, 31.0, 17.0),
        FoodItem("Fırında Hindi Dolma Biber", 380, 32.0, 35.0, 13.0),
        FoodItem("Kremasız Brokoli Çorbası", 210, 11.0, 27.0, 7.0),
        FoodItem("Fırın Mücverli Somon Köftesi", 400, 34.0, 22.0, 20.0),
        FoodItem("Elmalı Tarçınlı Yulaf", 310, 12.0, 52.0, 8.0),
        FoodItem("Fasulyeli Meksika Salatası", 340, 16.0, 48.0, 10.0),
        FoodItem("Dana Etli Sebze Güveç", 420, 35.0, 28.0, 19.0),
        FoodItem("Lor Peynirli Ispanaklı Krep", 300, 24.0, 30.0, 10.0),
        FoodItem("Limonlu Fırın Tavuk But", 460, 39.0, 12.0, 28.0),
        FoodItem("Kinoalı Karnabahar Kısırı", 300, 11.0, 45.0, 9.0),
        FoodItem("Fıstık Ezmeli Muzlu Smoothie", 360, 19.0, 42.0, 14.0),
        FoodItem("Izgara Hellim & Sebze", 390, 21.0, 24.0, 23.0),
        FoodItem("Fırında Morina & Bezelye Püresi", 350, 37.0, 30.0, 9.0),
        FoodItem("Köz Patlıcanlı Yoğurtlu Bulgur", 330, 13.0, 48.0, 10.0),
        FoodItem("Havuçlu Mercimek Köftesi", 280, 13.0, 44.0, 6.0),
        FoodItem("Sebzeli Tam Buğday Makarna", 410, 16.0, 65.0, 11.0),
        FoodItem("Yoğurtlu Meyve ve Badem Kasesi", 270, 16.0, 32.0, 10.0),
        FoodItem("Tavuklu Renkli Pirinç Kasesi", 430, 36.0, 51.0, 10.0),
        FoodItem("Domatesli Fırın Yumurta", 290, 20.0, 18.0, 15.0),
        FoodItem("Cevizli Kabaklı Yeşil Salata", 310, 9.0, 25.0, 21.0),
        FoodItem("Baharatlı Fırın Nohut", 230, 12.0, 34.0, 6.0),
        FoodItem("Fırında Sebzeli Alabalık", 400, 35.0, 20.0, 21.0),
        FoodItem("Kırmızı Pancarlı Humus", 260, 10.0, 32.0, 12.0),
        FoodItem("Sebzeli Tofu Sote", 350, 24.0, 29.0, 16.0),
        FoodItem("Yoğurtlu Yaban Mersinli Parfe", 290, 17.0, 38.0, 8.0),
        FoodItem("Fırında Kabaklı Tavuk Graten", 420, 39.0, 21.0, 19.0)
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