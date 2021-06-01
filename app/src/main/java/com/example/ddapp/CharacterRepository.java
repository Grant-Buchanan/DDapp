package com.example.ddapp;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class CharacterRepository {

    private CharacterDAO mCharacterDAO;
    private LiveData<List<Character>> mAllCharacters;

    CharacterRepository(Application application){
        RoomDB db = RoomDB.getDatabase(application);
        mCharacterDAO = db.characterDAO();
        mAllCharacters = mCharacterDAO.getAlphabetizedChars();
    }

    LiveData<List<Character>> getAllCharacters(){
        return mAllCharacters;
    }

    void insert (Character character){
        RoomDB.databaseWriteExecutor.execute(()->{
            mCharacterDAO.insert(character);
        });
    }
}
