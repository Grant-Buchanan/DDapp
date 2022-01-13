package com.example.ddapp;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "character_table")
public class Character {

    @PrimaryKey(autoGenerate = true)
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
    @ColumnInfo(name = "size")
    private String mSize;
    @ColumnInfo(name = "background")
    private String mBackground;
    @ColumnInfo(name = "alignment")
    private String mAlignment;
    @ColumnInfo(name = "init")
    private int mInit;
    @ColumnInfo(name = "str")
    private int mStr;
    @ColumnInfo(name = "dex")
    private int mDex;
    @ColumnInfo(name = "con")
    private int mCon;
    @ColumnInfo(name = "intelligence")
    private int mIntelligence;
    @ColumnInfo(name = "wis")
    private int mWis;
    @ColumnInfo(name = "chr")
    private int mChr;
    @ColumnInfo(name = "healthPoints")
    private int mHealthPoints;

    public Character(@NonNull int id,
                     @NonNull String name,
                     @NonNull int level,
                     @NonNull String race,
                     @NonNull String clas,
                     @NonNull String size,
                     @NonNull String background,
                     @NonNull String alignment,
                     @NonNull int init,
                     @NonNull int str,
                     @NonNull int dex,
                     @NonNull int con,
                     @NonNull int intelligence,
                     @NonNull int wis,
                     @NonNull int chr,
                     @NonNull int healthPoints
    ) {
        this.mId = id;
        this.mName = name;
        this.mLevel = level;
        this.mRace = race;
        this.mClas = clas;
        this.mSize = size;
        this.mBackground = background;
        this.mAlignment = alignment;
        this.mInit = init;
        this.mStr = str;
        this.mDex = dex;
        this.mCon = con;
        this.mIntelligence = intelligence;
        this.mWis = wis;
        this.mChr = chr;
        this.mHealthPoints = healthPoints;
    }

    public int getId(){return this.mId;}

    public String getName(){return this.mName;}

    public int getLevel(){return this.mLevel;}

    public String getRace(){return this.mRace;}

    public String getClas(){return this.mClas;}

    public String getSize(){return this.mSize;}

    public String getAlignment(){return this.mAlignment;}

    public String getBackground(){return this.mBackground;}

    public int getInit(){return this.mInit;}

    public int getStr(){return this.mStr;}

    public int getDex(){return this.mDex;}

    public int getCon(){return this.mCon;}

    public int getIntelligence(){return this.mIntelligence;}

    public int getWis(){return this.mWis;}

    public int getChr(){return this.mChr;}

    public int getHealthPoints(){return this.mHealthPoints;}

    public static Character[] populate(){
        return new Character[]{
       //         new Character(0,"Zagara", 10, "Tiefling", "sorcerer"),
       //         new Character(1, "Lothar",2,"Human","fighter"),
       //         new Character(2,"Duul",5,"Half-Orc","barbarian"),
       //         new Character(3,"Shiina",14,"Elf","wizard"),
       //         new Character(4,"Vivic",3,"Drow","ranger"),
       //         new Character(5,"Risu",5,"Half-elf","rogue"),
       //         new Character(6,"Hert",1,"Human","cleric"),
       //         new Character(7,"Kiva",7,"Tiefling","rogue")
        };
    }
}
