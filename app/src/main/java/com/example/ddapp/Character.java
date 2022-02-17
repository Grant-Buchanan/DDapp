package com.example.ddapp;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "character_table")
public class Character {

    //Define the Character table.
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
    @ColumnInfo(name = "acroProf")
    private boolean mAcroProf;
    @ColumnInfo(name = "aHProf")
    private boolean mAHProf;
    @ColumnInfo(name = "arcProf")
    private boolean mArcProf;
    @ColumnInfo(name = "athProf")
    private boolean mAthProf;
    @ColumnInfo(name = "deceptProf")
    private boolean mDeceptProf;
    @ColumnInfo(name = "histProf")
    private boolean mHistProf;
    @ColumnInfo(name = "insProf")
    private boolean mInsProf;
    @ColumnInfo(name = "intimiProf")
    private boolean mIntimiProf;
    @ColumnInfo(name = "investProf")
    private boolean mInvestProf;
    @ColumnInfo(name = "medProf")
    private boolean mMedProf;
    @ColumnInfo(name ="natProf")
    private boolean mNatProf;
    @ColumnInfo(name ="percProf")
    private boolean mPercProf;
    @ColumnInfo(name = "perfProf")
    private boolean mPerfProf;
    @ColumnInfo(name = "persProf")
    private boolean mPersProf;
    @ColumnInfo(name = "religProf")
    private boolean mReligProf;
    @ColumnInfo(name = "slightOfHandProf")
    private boolean mSlightOfHandProf;
    @ColumnInfo(name = "stealProf")
    private boolean mStealProf;
    @ColumnInfo(name = "survProf")
    private boolean mSurvProf;


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
                     @NonNull int healthPoints,
                     @NonNull boolean acroProf,
                     @NonNull boolean aHProf,
                     @NonNull boolean arcProf,
                     @NonNull boolean athProf,
                     @NonNull boolean deceptProf,
                     @NonNull boolean histProf,
                     @NonNull boolean insProf,
                     @NonNull boolean intimiProf,
                     @NonNull boolean investProf,
                     @NonNull boolean medProf,
                     @NonNull boolean natProf,
                     @NonNull boolean percProf,
                     @NonNull boolean perfProf,
                     @NonNull boolean persProf,
                     @NonNull boolean religProf,
                     @NonNull boolean slightOfHandProf,
                     @NonNull boolean stealProf,
                     @NonNull boolean survProf
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
        this.mAcroProf = acroProf;
        this.mAHProf = aHProf;
        this.mArcProf = arcProf;
        this.mAthProf = athProf;
        this.mDeceptProf = deceptProf;
        this.mHistProf = histProf;
        this.mInsProf = insProf;
        this.mIntimiProf = intimiProf;
        this.mInvestProf = investProf;
        this.mMedProf = medProf;
        this.mNatProf = natProf;
        this.mPercProf = percProf;
        this.mPerfProf = perfProf;
        this.mPersProf = persProf;
        this.mReligProf = religProf;
        this.mSlightOfHandProf = slightOfHandProf;
        this.mStealProf = stealProf;
        this.mSurvProf = survProf;
    }

    //Get methods for each column of the table.
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

    public boolean getAcroProf(){return this.mAcroProf;}

    public boolean getAHProf(){return this.mAHProf;}

    public boolean getArcProf(){return this.mArcProf;}

    public boolean getAthProf(){return this.mAthProf;}

    public boolean getDeceptProf(){return this.mDeceptProf;}

    public boolean getHistProf(){return this.mHistProf;}

    public boolean getInsProf(){return this.mInsProf;}

    public boolean getIntimiProf(){return this.mIntimiProf;}

    public boolean getInvestProf(){return this.mInvestProf;}

    public boolean getMedProf(){return this.mMedProf;}

    public boolean getNatProf(){return this.mNatProf;}

    public boolean getPercProf(){return this.mPercProf;}

    public boolean getPerfProf(){return this.mPerfProf;}

    public boolean getPersProf(){return this.mPersProf;}

    public boolean getReligProf(){return this.mReligProf;}

    public boolean getSlightOfHandProf(){return this.mSlightOfHandProf;}

    public boolean getStealProf (){return this.mStealProf;}

    public boolean getSurvProf(){return this.mSurvProf;}

    //Method to populate the database with test data.
    public static Character[] populate(){
        return new Character[]{
                new Character(1,"Zagara", 10, "Tiefling", "Sorcerer","medium","noble","neutral",3,10,13,15,13,8,19,43,false,false,false,false,true,false,false,false,true,false,false,true,false,true,false,false,true,false),
                new Character(2, "Lothar",2,"Human","Fighter", "medium","vagrant","chaotic neutral",3,16,16,15,9,8,8,20,false,false,false,true,false,false,false,true,false,true,false,false,false,false,false,false,false,false),
                new Character(3,"Duul",5,"Half-Orc","Barbarian","medium","hermit","evil",3,18,13,16,8,8,8,45,false,true,false,true,false,false,false,true,false,false,false,false,false,false,false,false,false,true),
                new Character(4,"Shiina",14,"Elf","Wizard","medium","student","good",4,9,14,14,20,8,14,67,true,false,true,false,false,false,true,false,true,false,false,false,false,false,false,false,false,false),
                new Character(5,"Vivic",3,"Drow","Ranger","medium","assassin","chaotic evil",3,13,18,13,12,14,11,22,true,true,true,false,false,false,false,false,false,true,false,false,false,false,false,false,false,true),
                new Character(6,"Risu",5,"Half-elf","Rogue","medium","thief","chaotic neutral",3,12,15,11,13,14,11,32,true,true,true,false,true,false,false,false,false,false,false,false,false,false,false,false,true,false),
                new Character(7,"Hert",1,"Human","Cleric","medium","hermit","good",2,14,9,13,12,17,13,13,false,false,false,true,false,true,true,false,false,true,false,false,false,false,false,false,false,false),
                new Character(8,"Kiva",7,"Tiefling","Rogue","medium","assasin","lawful evil",3,13,19,13,11,10,13,41,true,false,true,false,true,false,false,true,false,false,false,false,false,false,false,true,true,true),
                new Character(9,"Zyreph",12,"Kobold","Fighter","small","knight","chaotic good",2,20,15,15,8,12,10,100,false,true,false,true,false,true,false,false,false,false,false,false,false,true,false,false,false,false),
        };
    }
}
