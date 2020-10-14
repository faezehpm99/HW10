package com.example.hw10.Room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.hw10.Model.Job;

@Database(entities = {Job.class}, version = 1)
public  abstract class DataBase extends RoomDatabase {
    public abstract UserDAO userDao();

}
