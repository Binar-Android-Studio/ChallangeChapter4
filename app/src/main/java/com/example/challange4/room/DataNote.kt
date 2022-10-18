package com.example.challange4.room

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
class DataNote (
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    var title : String,
    var content : String
) : Parcelable