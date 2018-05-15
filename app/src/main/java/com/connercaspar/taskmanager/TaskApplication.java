package com.connercaspar.taskmanager;

import android.app.Application;
import android.arch.persistence.room.Room;

public class TaskApplication extends Application {

    private static final String DATABASE_NAME = "task_database";
    private TaskDatabase taskDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        taskDatabase = Room.databaseBuilder(getApplicationContext(), TaskDatabase.class, DATABASE_NAME).allowMainThreadQueries().build();
    }

    public TaskDatabase getTaskDatabase() {
        return taskDatabase;
    }
}
