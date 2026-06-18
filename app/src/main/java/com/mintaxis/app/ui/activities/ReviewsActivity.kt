package com.mintaxis.app.ui.activities

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mintaxis.app.R
import org.json.JSONArray
import org.json.JSONObject

class ReviewsActivity : AppCompatActivity() {

    private lateinit var reviewsList: LinearLayout
    private lateinit var nameInput: EditText
    private lateinit var textInput: EditText
    private lateinit var submitButton: TextView
    private lateinit var star1: TextView
    private lateinit var star2: TextView
    private lateinit var star3: TextView
    private lateinit var star4: TextView
    private lateinit var star5: TextView
    private lateinit var prefs: SharedPreferences

    private var selectedRating = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            setContentView(R.layout.activity_reviews)

            prefs = getSharedPreferences("mintaxis_reviews", Context.MODE_PRIVATE)

            initViews()
            loadReviews()
            setupStarSelector()

            findViewById<ImageButton>(R.id.backButton)?.setOnClickListener { finish() }

            submitButton.setOnClickListener { submitReview() }
        } catch (e: Exception) {
            finish()
        }
    }

    private fun initViews() {
        reviewsList = findViewById(R.id.reviewsList)
        nameInput = findViewById(R.id.reviewNameInput)
        textInput = findViewById(R.id.reviewTextInput)
        submitButton = findViewById(R.id.submitReviewButton)
        star1 = findViewById(R.id.star1)
        star2 = findViewById(R.id.star2)
        star3 = findViewById(R.id.star3)
        star4 = findViewById(R.id.star4)
        star5 = findViewById(R.id.star5)
    }

    private fun setupStarSelector() {
        val starViews = listOf(star1, star2, star3, star4, star5)
        starViews.forEach { star ->
            star.setOnClickListener {
                val rating = star.tag.toString().toInt()
                selectedRating = rating
                updateStarDisplay(rating)
            }
        }
    }

    private fun updateStarDisplay(rating: Int) {
        val starViews = listOf(star1, star2, star3, star4, star5)
        starViews.forEachIndexed { index, star ->
            if (index < rating) {
                star.text = "★"
                star.setTextColor(getColor(R.color.mintaxis_yellow))
            } else {
                star.text = "☆"
                star.setTextColor(getColor(R.color.mintaxis_text_muted))
            }
        }
    }

    private fun loadReviews() {
        val reviewsJson = prefs.getString("reviews", null)
        if (reviewsJson == null) {
            seedDefaultReviews()
        } else {
            val reviewsArray = JSONArray(reviewsJson)
            for (i in 0 until reviewsArray.length()) {
                val review = reviewsArray.getJSONObject(i)
                addReviewToLayout(
                    review.getString("name"),
                    review.getString("text"),
                    review.getInt("rating"),
                    review.getString("date")
                )
            }
        }
    }

    private fun seedDefaultReviews() {
        val defaultReviews = listOf(
            Triple("Tendai M.", "Best taxi service in Harare. The drivers are professional and vehicles are always clean. I use their contract taxi service daily for work.", 5) to "Jan 2026",
            Triple("Grace N.", "Hired a bus for my wedding guests. The coach was comfortable and arrived on time. Highly recommend MIN Taxis for events!", 5) to "Dec 2025",
            Triple("Peter K.", "The car rental service is excellent. Got a Toyota Corolla for a week-long trip. Great rates and the car was in perfect condition.", 4) to "Nov 2025",
            Triple("Rutendo S.", "Airport transfer was seamless. Driver was waiting for me at RGM International Airport. Will definitely use again.", 5) to "Oct 2025",
            Triple("James D.", "Corporate account with MIN Taxis for 2 years now. Reliable service, professional drivers, and great UHF radio tracking system.", 5) to "Sep 2025"
        )

        val reviewsArray = JSONArray()
        for ((reviewTriple, date) in defaultReviews) {
            val (name, text, rating) = reviewTriple
            val obj = JSONObject()
            obj.put("name", name)
            obj.put("text", text)
            obj.put("rating", rating)
            obj.put("date", date)
            reviewsArray.put(obj)
            addReviewToLayout(name, text, rating, date)
        }
        prefs.edit().putString("reviews", reviewsArray.toString()).apply()
    }

    private fun addReviewToLayout(name: String, text: String, rating: Int, date: String) {
        val card = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            val bg = resources.getDrawable(R.drawable.gallery_card_background, null)
            background = bg
            setPadding(24, 20, 24, 20)
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.bottomMargin = 12
            layoutParams = params
        }

        val nameText = TextView(this).apply {
            this.text = name
            setTextColor(getColor(R.color.mintaxis_text_primary))
            textSize = 15f
            paint.isFakeBoldText = true
        }

        val dateText = TextView(this).apply {
            this.text = date
            setTextColor(getColor(R.color.mintaxis_text_muted))
            textSize = 12f
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.topMargin = 2
            layoutParams = params
        }

        val starsLayout = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.topMargin = 6
            layoutParams = params
        }
        for (i in 1..5) {
            val star = TextView(this).apply {
                text = if (i <= rating) "★" else "☆"
                setTextColor(getColor(R.color.mintaxis_yellow))
                textSize = 16f
            }
            starsLayout.addView(star)
        }

        val reviewText = TextView(this).apply {
            this.text = text
            setTextColor(getColor(R.color.mintaxis_text_secondary))
            textSize = 14f
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.topMargin = 8
            layoutParams = params
        }

        card.addView(nameText)
        card.addView(dateText)
        card.addView(starsLayout)
        card.addView(reviewText)

        reviewsList.addView(card)
    }

    private fun submitReview() {
        val name = nameInput.text.toString().trim()
        val text = textInput.text.toString().trim()

        if (name.isEmpty()) {
            nameInput.error = "Please enter your name"
            return
        }
        if (text.isEmpty()) {
            textInput.error = "Please enter your review"
            return
        }
        if (selectedRating == 0) {
            Toast.makeText(this, "Please select a rating", Toast.LENGTH_SHORT).show()
            return
        }

        val date = java.text.SimpleDateFormat("MMM yyyy", java.util.Locale.getDefault())
            .format(java.util.Date())

        val reviewsJson = prefs.getString("reviews", "[]")
        val reviewsArray = JSONArray(reviewsJson)
        val obj = JSONObject()
        obj.put("name", name)
        obj.put("text", text)
        obj.put("rating", selectedRating)
        obj.put("date", date)
        reviewsArray.put(obj)
        prefs.edit().putString("reviews", reviewsArray.toString()).apply()

        addReviewToLayout(name, text, selectedRating, date)

        nameInput.text.clear()
        textInput.text.clear()
        selectedRating = 0
        updateStarDisplay(0)

        Toast.makeText(this, "Review submitted! Thank you for your feedback", Toast.LENGTH_SHORT).show()
    }
}
