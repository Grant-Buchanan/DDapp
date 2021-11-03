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
    @ColumnInfo(name = "level")
    private int mLevel;
    @ColumnInfo(name = "race")
    private String mRace;
    @ColumnInfo(name = "clas")
    private String mClas;

    public Character(@NonNull int id,
                     @NonNull String name,
                     @NonNull int level,
                     @NonNull String race,
                     @NonNull String clas
    ) {
        this.mId = id;
        this.mName = name;
        this.mLevel = level;
        this.mRace = race;
        this.mClas = clas;
    }

    public int getId(){return this.mId;}

    public String getName(){return this.mName;}

    public int getLevel(){return this.mLevel;}

    public String getRace(){return this.mRace;}

    public String getClas(){return this.mClas;}

    public static Character[] populate(){
        return new Character[]{
                new Character(0,"Zagara", 10, "Tiefling", "sorcerer"),
                new Character(1, "Lothar",2,"Human","fighter"),
                new Character(2,"Duul",5,"Half-Orc","barbarian"),
                new Character(3,"Shiina",14,"Elf","wizard"),
                new Character(4,"Vivic",3,"Drow","ranger"),
                new Character(5,"Risu",5,"Half-elf","rogue"),
                new Character(6,"Hert",1,"Human","cleric"),
                new Character(7,"Kiva",7,"Tiefling","rogue")
        };
    }
}
