package com.example.challange4.room

import androidx.lifecycle.LiveData

class NoteRepository (val data: NoteDAO) {

    fun getAllDataNotes() : LiveData<List<DataNote>>{
        return data.getDataNote()
    }

    suspend fun addNote(notes: DataNote) = data.insertNote(notes)

    suspend fun editNote(notes: DataNote) = data.editNote(notes)

    suspend fun deleteNote(notes: DataNote) = data.deleteNote(notes)


}