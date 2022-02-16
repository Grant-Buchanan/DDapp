package com.example.ddapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CharacterDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Character id);

    @Delete
    void delete(Character id);

    @Query("UPDATE character_table SET name=:name, level=:level, race=:race, clas=:clas, size=:size, background=:background, alignment=:alignment, init=:init, str=:str, dex=:dex, con=:con, intelligence=:intelligence, wis=:wis, chr=:chr, healthPoints=:hp, acroProf=:acroProf, AHProf=:AHProf, arcProf=:arcProf, athProf=:athProf, deceptProf=:deceptProf, histProf=:histProf, insProf=:insProf, intimiProf=:intimiProf, investProf=:investProf, medProf=:medProf, natProf=:natProf, percProf=:percProf, perfProf=:perfProf, persProf=:persProf, religProf=:religProf, slightOfHandProf=:SoHProf, stealProf=:stealProf, survProf=:survProf WHERE id = :id")
    void update(int id, String name, int level, String race, String clas, String size, String background, String alignment, int init, int str, int dex, int con, int intelligence, int wis, int chr, int hp, boolean acroProf, boolean AHProf, boolean arcProf, boolean athProf, boolean deceptProf, boolean histProf, boolean insProf, boolean intimiProf, boolean investProf, boolean medProf, boolean natProf, boolean percProf, boolean perfProf, boolean persProf, boolean religProf, boolean SoHProf, boolean stealProf, boolean survProf);

    @Query("DELETE FROM character_table")
    void deleteAll();

    @Query("SELECT * FROM character_table ORDER BY id ASC")
    LiveData<List<Character>> getAlphabetizedChars();

    @Insert
    void insertAll(Character... characters);
}
