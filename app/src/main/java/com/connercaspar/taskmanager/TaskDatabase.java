package com.connercaspar.taskmanager;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

@Database(version = 1, entities = Task.class)
@TypeConverters(DateConverter.class)
abstract class TaskDatabase extends RoomDatabase {


}
