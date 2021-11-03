package com.example.ddapp;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

 class CharacterRepository {

    private CharacterDAO mCharacterDAO;
    private LiveData<List<Character>> mAllCharacters;
    private static CharacterRepository repo = null;
    private  Context mContext;
    private RoomDB db;

    CharacterRepository(Application application){
        if(db == null) {db = RoomDB.getDatabase(application);}
        mCharacterDAO = db.characterDAO();
        mAllCharacters = mCharacterDAO.getAlphabetizedChars();
        mContext = application.getApplicationContext();
        repo = this;
    }

    public static CharacterRepository getInstance(Context context) {
        if (repo == null) {
            return new CharacterRepository((Application) context.getApplicationContext());
        } else {
            return repo;
        }
    }

    public LiveData<List<Character>> getAllCharacters(){
        if(mAllCharacters != null){return  mAllCharacters;}
        else{
            mAllCharacters = mCharacterDAO.getAlphabetizedChars();
        }
        return mAllCharacters;

    }

    void insert (Character character){
        RoomDB.databaseWriteExecutor.execute(()->{
            mCharacterDAO.insert(character);
        });
    }


}
