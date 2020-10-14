package com.example.hw10.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tasks")
public class Job {
    @PrimaryKey(autoGenerate = true)
 public int id;

    @ColumnInfo(name = "name")
    public String mJobName;

    @ColumnInfo(name = "state")
    public String mState;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getmJobName() {
        return mJobName;
    }

    public void setmJobName(String mJobName) {
        this.mJobName = mJobName;
    }

    public String getmState() {
        return mState;
    }

    public void setmState(String mState) {
        this.mState = mState;
    }
}
