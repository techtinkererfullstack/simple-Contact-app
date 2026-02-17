package com.example.simplecontactapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Contact::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun noteDao(): ContactDao

    companion object{

        private var INSTANCE : AppDatabase?=null

        fun getDatabase(context: Context): AppDatabase{

            if(INSTANCE==null){
                INSTANCE= Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "contact_db"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE!!
        }
    }

}