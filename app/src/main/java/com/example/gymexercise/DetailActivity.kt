package com.example.gymexercise

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gymexercise.databinding.ExerciseDetailBinding

class DetailActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_EXERCISE = "extra_exercise"
    }
    private lateinit var binding: ExerciseDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ExerciseDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataExercise = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Exercise>(EXTRA_EXERCISE, Exercise::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Exercise>(EXTRA_EXERCISE)
        }

        binding.tvName.text = dataExercise?.name
        binding.tvDescription.text = dataExercise?.description
        binding.imgLogo.setImageResource(dataExercise?.photo ?: 0)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}