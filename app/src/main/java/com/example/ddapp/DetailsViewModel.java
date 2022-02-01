package com.example.ddapp;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class DetailsViewModel extends AndroidViewModel {


    private CharacterRepository mRepository;
    private final LiveData<List<Character>> mAllCharacters;

    //The ViewModel holds an reference to the repository, and every character in the repository for easier access from the fragments.
    public DetailsViewModel(Application application) {
        super(application);
        mRepository = new CharacterRepository(application);
        mAllCharacters = mRepository.getAllCharacters();
    }

    //Return the list of characters
    LiveData<List<Character>> getAllCharacters(){return mAllCharacters;}

    //Insert a character by calling the repository's insert method. These three methods in particular allow modification of the database from the view.
    public void insert(Character character){mRepository.insert(character);}

    //Delete a character by calling the repository's delete method.
    public void delete(Character character){mRepository.delete(character);}

    //Update a character by calling the repository's update method.
    public void update(Character character){
        mRepository.update(character);
    }

}
