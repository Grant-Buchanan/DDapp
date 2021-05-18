package com.example.ddapp;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DetailsViewModel extends ViewModel {


    private MutableLiveData<String> Details_Id;

    public MutableLiveData<String> getDetails_Id(){
        if (Details_Id == null) {
            Details_Id = new MutableLiveData<>();
        }
        return Details_Id;
    }
}
