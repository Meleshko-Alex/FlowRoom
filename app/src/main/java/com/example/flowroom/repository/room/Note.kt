package com.example.flowroom.repository.room

import androidx.room.*

@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val caption: String,
    val text: String
)

