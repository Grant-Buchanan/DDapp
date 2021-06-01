package com.example.ddapp;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class DetailsViewModel extends AndroidViewModel {


    private CharacterRepository mRepository;
    private final LiveData<List<Character>> mAllCharacters;
    private MutableLiveData<String> Details_Id;

    public DetailsViewModel(Application application) {
        super(application);
        mRepository = new CharacterRepository(application);
        mAllCharacters = mRepository.getAllCharacters();
    }

    LiveData<List<Character>> getmAllCharacters() {return mAllCharacters;}

    public void insert(Character character){mRepository.insert(character);}

    public MutableLiveData<String> getDetails_Id(){
        if (Details_Id == null) {
            Details_Id = new MutableLiveData<>();
        }
        return Details_Id;
    }
}
