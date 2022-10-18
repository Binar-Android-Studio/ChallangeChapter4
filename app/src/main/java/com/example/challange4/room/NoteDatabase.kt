package com.example.challange4.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.challange4.AddNoteFragment
import com.example.challange4.HomeFragment

@Database(entities = [DataNote::class], version = 1 )
abstract class NoteDatabase : RoomDatabase () {
    abstract fun noteDao() : NoteDAO

    companion object{
        @Volatile
        private var INSTANCE : NoteDatabase? = null

        fun getInstance(context : Context): NoteDatabase? {
            if (INSTANCE == null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        NoteDatabase::class.java,
                        "note.db"
                    ).build()
                }
            }
            return INSTANCE
        }
    }
}