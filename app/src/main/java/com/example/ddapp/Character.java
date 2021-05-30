package com.example.ddapp;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "character_table")
public class Character {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")

    private String mId;
    private String mName;

    public Character(@NonNull String id, @NonNull String Name) {this.mId = id; this.mName = Name;}

    public String getId(){return this.mId;}

    public String getName(){return this.mName;}
}
