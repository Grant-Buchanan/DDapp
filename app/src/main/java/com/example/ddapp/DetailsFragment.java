package com.example.ddapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class DetailsFragment extends Fragment {

    private static String id;
    private DetailsViewModel mDetailsViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.details_fragment, container, false);

        mDetailsViewModel = new ViewModelProvider(this).get(DetailsViewModel.class);

        mDetailsViewModel.getDetailsId().setValue(id);


        TextView textView2 = root.findViewById(R.id.textView2);
        textView2.setText(id);
        return root;

    }
    public static DetailsFragment setInstance (Bundle bundle){
        id = bundle.getString("id");
        return new DetailsFragment();
    }

}
