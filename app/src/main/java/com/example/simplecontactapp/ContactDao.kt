package com.example.simplecontactapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao//Data Access Object
interface ContactDao {

    @Insert//to insert data in the table
    fun insert(contact:Contact)

    //to get data from the table-> select all from table
    @Query("SELECT * FROM contacts")
    fun getAllNotes(): List<Contact>

    @Delete
    fun delete(contact: Contact)


}