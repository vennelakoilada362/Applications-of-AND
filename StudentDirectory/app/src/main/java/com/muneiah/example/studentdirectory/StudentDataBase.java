package com.muneiah.example.studentdirectory;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = StudentEntity.class,version = 1,exportSchema = false)
public abstract class StudentDataBase extends RoomDatabase {
    public abstract StudentDAO studentDAO();
    static StudentDataBase dataBase;
    public static synchronized StudentDataBase getInstance(Application application){
       if (dataBase==null){
           dataBase= Room.databaseBuilder(application,StudentDataBase.class,"apssdc").allowMainThreadQueries().build();
       }
       return dataBase;
    }
}
