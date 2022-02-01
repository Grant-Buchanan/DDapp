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

    @Query("UPDATE character_table SET name=:name, level=:level, race=:race, clas=:clas, size=:size, background=:background, alignment=:alignment, init=:init, str=:str, dex=:dex, con=:con, intelligence=:intelligence, wis=:wis, chr=:chr, healthPoints=:hp  WHERE id = :id")
    void update(int id, String name, int level, String race, String clas, String size, String background, String alignment, int init, int str, int dex, int con, int intelligence, int wis, int chr, int hp);

    @Query("DELETE FROM character_table")
    void deleteAll();

    @Query("SELECT * FROM character_table ORDER BY id ASC")
    LiveData<List<Character>> getAlphabetizedChars();

    @Insert
    void insertAll(Character... characters);
}
