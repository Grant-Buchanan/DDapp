package com.example.ddapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

public class DetailsFragment extends Fragment {

    private static String charId;

    public static DetailsFragment setInstance(Bundle bundle) {
        charId = bundle.getString("id");
        return new DetailsFragment();
    }
}
