package com.example.ddapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;


import static com.example.ddapp.RecyclerViewFragment.NEW_CHARACTER_ACTIVITY_REQUEST_CODE;

public class DetailsFragment extends Fragment {

    static Integer id;
    static String name;
    static Integer level;
    static String race;
    static String clas;
    TextView detailsName;
    TextView detailsLevel;
    TextView detailsRace;
    TextView detailsClas;
    private DetailsViewModel mDetailsViewModel;



    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.details_fragment, container, false);
        mDetailsViewModel = new ViewModelProvider(this).get(DetailsViewModel.class);

        detailsName = view.findViewById(R.id.detailsName);
        detailsLevel = view.findViewById(R.id.detailsLevel);
        detailsRace = view.findViewById(R.id.detailsRace);
        detailsClas = view.findViewById(R.id.detailsClass);
        detailsName.setText(name);
        detailsLevel.setText(" is a " + level + " ");
        detailsRace.setText(race + " ");
        detailsClas.setText(clas);

        Log.d("DETAILS_CREATION", "id is " + id + ", name is " + name + ", level is " + level + ", race is " + race + ", class is " + clas);

        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
        if(!((MainActivity)getActivity()).checkState()) {
            FloatingActionButton fab = this.getActivity().findViewById(R.id.fab);
            fab.setOnClickListener(v -> {
                Toast.makeText(
                        getContext(),
                        "FAB change test",
                        Toast.LENGTH_SHORT).show();
            });
        }
    }
    public void onDestroy() {
        super.onDestroy();
        ((MainActivity)getActivity()).setState(true);
        ((MainActivity)getActivity()).setFab();
    }

    public static DetailsFragment setInstance (Bundle bundle){
        id = bundle.getInt("id");
        name = bundle.getString("name");
        level = bundle.getInt("level");
        race = bundle.getString("race");
        clas = bundle.getString("clas");
        return new DetailsFragment();
    }

    public static DetailsFragment updateInstance (Bundle bundle){
        id = bundle.getInt("id");
        name = bundle.getString("name");
        level = bundle.getInt("level");
        race = bundle.getString("race");
        clas = bundle.getString("clas");
        return new DetailsFragment();
    }

}
