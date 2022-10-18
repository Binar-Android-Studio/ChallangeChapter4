package com.example.challange4.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNote(notes: DataNote)

    @Query(" SELECT * FROM DataNote ORDER BY id DESC")
    fun getDataNote() : LiveData<List<DataNote>>

    @Update
    suspend fun editNote(notes: DataNote)

    @Delete
    suspend fun deleteNote(notes: DataNote)
}