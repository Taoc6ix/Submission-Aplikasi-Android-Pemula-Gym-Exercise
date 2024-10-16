package com.example.gymexercise

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvExercises: RecyclerView
    private val list = ArrayList<Exercise>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        rvExercises = findViewById(R.id.rv_exercises)
        rvExercises.setHasFixedSize(true)
        list.addAll(getListExercise())
        showRecyclerList()
    }

    private fun getListExercise(): ArrayList<Exercise> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listExercise = ArrayList<Exercise>()
        for (i in dataName.indices) {
            val exercise = Exercise(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listExercise.add(exercise)
        }
        return listExercise
    }

    private fun showRecyclerList() {
        rvExercises.layoutManager = LinearLayoutManager(this)
        val listExerciseAdapter = ListExerciseAdapter(list)
        rvExercises.adapter = listExerciseAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val aboutMeIntent = Intent(this@MainActivity, AboutMe::class.java)
                startActivity(aboutMeIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}