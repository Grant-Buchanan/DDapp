package com.example.ddapp;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class DetailsViewModel extends AndroidViewModel {


    private CharacterRepository mRepository;
    private final LiveData<List<Character>> mAllCharacters;

    public DetailsViewModel(Application application) {
        super(application);
        mRepository = new CharacterRepository(application);
        mAllCharacters = mRepository.getAllCharacters();
    }

    //Return the list of characters
    LiveData<List<Character>> getAllCharacters(){return mAllCharacters;}

    //Insert a character
    public void insert(Character character){mRepository.insert(character);}

    //Delete a character
    public void delete(Character character){mRepository.delete(character);}

    //Update a character
    public void update(Character character){
        mRepository.update(character);
    }

}
