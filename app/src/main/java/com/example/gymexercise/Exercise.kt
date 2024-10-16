package com.example.gymexercise

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Exercise(
    var name: String,
    var description: String,
    var photo: Int
) : Parcelable