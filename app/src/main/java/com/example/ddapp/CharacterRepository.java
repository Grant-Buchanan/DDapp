package com.example.ddapp;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class CharacterRepository {

    private CharacterDAO mCharacterDAO;
    private MutableLiveData<List<Character>> mAllCharacters;
    private static CharacterRepository repo = null;
    private  Context mContext;
    private RoomDB db;

    protected CharacterRepository(Application application){
        if(db == null) {db = RoomDB.getDatabase(application);}
        mAllCharacters = getFromDatabase();
        mCharacterDAO = db.characterDAO();
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

    public MutableLiveData<List<Character>> getAllCharacters(){
        return mAllCharacters;
    }

    public MutableLiveData<List<Character>> getFromDatabase(){
        if(mAllCharacters != null){return mAllCharacters;}
        mAllCharacters = new MutableLiveData<>();
        mAllCharacters.setValue(db.characterDAO().getAlphabetizedChars());
        return  mAllCharacters;
    }

    void insert (Character character){
        RoomDB.databaseWriteExecutor.execute(()->{
            mCharacterDAO.insert(character);
        });
    }


}
