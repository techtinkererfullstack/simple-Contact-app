package com.example.simplecontactapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")//creating the table
data class Contact(
//unique Identifier
    @PrimaryKey(autoGenerate = true)
    val id :Int =0,
    //field
    val name : String,
    val mobile: String
)
