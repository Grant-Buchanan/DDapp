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
        mAllCharacters = getAllCharacters();
        mContext = application.getApplicationContext();
        repo = this;
    }

    //Get an instance of the Repository
    public static CharacterRepository getInstance(Context context) {
        if (repo == null) {
            return new CharacterRepository((Application) context.getApplicationContext());
        } else {
            return repo;
        }
    }

    //Method for getting a the list of Characters from the database.
    public LiveData<List<Character>> getAllCharacters(){
        if(mAllCharacters != null){return  mAllCharacters;}
        else{
            mAllCharacters = mCharacterDAO.getAlphabetizedChars();
        }
        return mAllCharacters;

    }

    //Insert a character into the database.
    void insert (Character character){
        RoomDB.databaseWriteExecutor.execute(()->{
            mCharacterDAO.insert(character);
        });
    }

    //Delete a character from the database.
    void delete (Character character){
        RoomDB.databaseWriteExecutor.execute(()->{
            mCharacterDAO.delete(character);
        });
    }

    //Update a character in the database.
    void update (Character character){
        RoomDB.databaseWriteExecutor.execute(()->{
            mCharacterDAO.update(character.getId(), character.getName(), character.getLevel(), character.getRace(), character.getClas(), character.getSize());
        });
    }
}
