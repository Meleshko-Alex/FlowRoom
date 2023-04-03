package com.example.flowroom.repository.room

import kotlinx.coroutines.flow.Flow


class Repository(private val db: NotesDataBase) {
    private val dao get() = db.notesDao

    fun getAll(): Flow<List<Note>> = dao.getAll()

    suspend fun save(note: Note) = dao.add(note)

    suspend fun delete(note: Note) = dao.delete(note)
}