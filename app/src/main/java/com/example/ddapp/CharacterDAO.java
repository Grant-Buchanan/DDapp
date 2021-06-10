package com.example.ddapp;

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

    @Query("DELETE FROM character_table")
    void deleteAll();

    @Query("SELECT * FROM character_table ORDER BY id ASC")
    List<Character> getAlphabetizedChars();

    @Insert
    void insertAll(Character... characters);
}
