package com.muneiah.example.studentdirectory;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "student_directory")
public class StudentEntity {
    @ColumnInfo(name = "name")
    @NonNull
    String name;

    @PrimaryKey
    @ColumnInfo(name = "id")
    @NonNull
    String id;

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }
}
