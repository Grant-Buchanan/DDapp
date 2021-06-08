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
    private int mId;
    @ColumnInfo(name = "name")
    private String mName;

    public Character(@NonNull int id,
                     @NonNull String name
    ) {
        this.mId = id;
        this.mName = name;
    }

    public int getId(){return this.mId;}

    public String getName(){return this.mName;}

    public static Character[] populate(){
        return new Character[]{
                new Character(1,"James"),
                new Character(2, "Jimmy")
        };
    }
}
