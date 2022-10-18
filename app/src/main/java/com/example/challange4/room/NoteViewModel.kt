package com.example.challange4.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class NoteViewModel (application : Application) : AndroidViewModel(application){

    private val noteRepo : NoteRepository

    init {
        val noteDao = NoteDatabase.getInstance(application)?.noteDao()
        noteRepo = NoteRepository(noteDao!!)
    }

    fun getDataNotes() : LiveData<List<DataNote>> = noteRepo.getAllDataNotes()

    fun addNote(notes: DataNote){
        viewModelScope.launch {
            noteRepo.addNote(notes)
        }
    }

    fun editNote(notes: DataNote){
        viewModelScope.launch {
            noteRepo.editNote(notes)
        }
    }

    fun deleteNote(notes: DataNote){
        viewModelScope.launch {
            noteRepo.deleteNote(notes)
        }
    }

}