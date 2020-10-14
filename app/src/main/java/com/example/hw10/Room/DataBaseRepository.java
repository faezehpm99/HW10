package com.example.hw10.Room;

import android.content.Context;

import androidx.room.Room;

import com.example.hw10.Model.Job;

import java.util.List;

public class DataBaseRepository {
    private Context mContext;
    private static DataBaseRepository sInstance;
    private UserDAO Dao;
    public static DataBaseRepository getInstance(Context context) {
        if (sInstance == null)
            sInstance = new DataBaseRepository(context);
        return sInstance;

    }
    private DataBaseRepository(Context context) {
        mContext = context.getApplicationContext();
        DataBase mDataBase = Room.databaseBuilder(mContext, DataBase.class,"tasks").allowMainThreadQueries().
                build();
        Dao=mDataBase.userDao();
    }
    public void Insert(Job job) {
        Dao.insert(job);
    }

    public List<Job>getAll() {
       return Dao.getAll();
    }
    public Job getJob(int id){
        return Dao.getJob(id);
    }


}
