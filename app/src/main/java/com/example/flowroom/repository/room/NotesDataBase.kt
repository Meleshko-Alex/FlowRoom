package com.example.flowroom.repository.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1)
abstract class NotesDataBase: RoomDatabase() {
    abstract val notesDao: NotesDao

    companion object {
        fun create(context: Context) = Room.databaseBuilder(
            context,
            NotesDataBase::class.java,
            "notes-database"
        )
    }
}