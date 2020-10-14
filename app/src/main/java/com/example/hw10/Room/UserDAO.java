package com.example.hw10.Room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.hw10.Model.Job;

import java.util.List;
@Dao
public interface UserDAO {

    @Insert
    void insert(Job... users);

    @Query("SELECT * FROM tasks")
    List<Job> getAll();

    @Query("SELECT *FROM tasks where id=:id")
    Job getJob(int id);
}
