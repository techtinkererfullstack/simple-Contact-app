package com.example.simplecontactapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao//Data Access Object
interface ContactDao {

    @Insert//to insert data in the table
    fun insert(contact:Contact)

    //to get data from the table-> select all from table
    @Query("SELECT * FROM contacts")
    fun getAllContact(): List<Contact>

    @Update
    fun update(contact: Contact)


    @Delete
    fun delete(contact: Contact)


}