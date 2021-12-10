package com.example.ddapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;


import static android.app.Activity.RESULT_OK;



public class DetailsFragment extends Fragment {

    private static final int EDIT_CHARACTER_ACTIVITY_REQUEST_CODE = 1;
    static Integer id;
    static String name;
    static Integer level;
    static String race;
    static String clas;
    static Character character;
    TextView detailsName;
    TextView detailsLevel;
    TextView detailsRace;
    TextView detailsClas;
    //Reference to the view model
    private DetailsViewModel mDetailsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.details_fragment, container, false);


        //Set view model provider
        mDetailsViewModel = new ViewModelProvider(this).get(DetailsViewModel.class);

        //Find references to textviews, and set each field appropriately
        detailsName = view.findViewById(R.id.detailsName);
        detailsLevel = view.findViewById(R.id.detailsLevel);
        detailsRace = view.findViewById(R.id.detailsRace);
        detailsClas = view.findViewById(R.id.detailsClass);
        detailsName.setText(name);
        detailsLevel.setText(" is a level " + level + " ");
        detailsRace.setText(race + " ");
        detailsClas.setText(clas);

        //Lets the fragment know that it has an options menu in the action bar that it needs to be paying attention to
        setHasOptionsMenu(true);
        Log.d("DETAILS_CREATION", "id is " + id + ", name is " + name + ", level is " + level + ", race is " + race + ", class is " + clas);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        //Invalidate the options menu update to call onCreateOptionsMenu in the MainActivity
        getActivity().invalidateOptionsMenu();

    }
    public void onDestroy() {
        super.onDestroy();

        //Invalidate the options menu when the user navigates back to the RecyclerViewFragment, this is done to hide the options that are only supposed to display while the details fragment is present
        getActivity().invalidateOptionsMenu();

    }

    public static DetailsFragment setInstance (Bundle bundle){
        //This function is used to create a new DetailsFragment from within the RecyclerViewFragment. A bundle of character data is taken as a parameter in order to set the relevant data within the new fragment.
        id = bundle.getInt("id");
        name = bundle.getString("name");
        level = bundle.getInt("level");
        race = bundle.getString("race");
        clas = bundle.getString("clas");
        return new DetailsFragment();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            //Click listener for behavior specific to the DetailsFragment

            case R.id.action_delete:
                //Delete a character
                character = new Character(id,name,level,race,clas);
                mDetailsViewModel.delete(character);
                getActivity().getSupportFragmentManager().popBackStack();
                return true;

            case R.id.action_edit:
                //Edit a character
                Intent intent = new Intent(getContext(), EditCharacterActivity.class);
                intent.putExtra("EDIT_ID",id);
                intent.putExtra("EDIT_NAME",name);
                intent.putExtra("EDIT_LEVEL",level);
                intent.putExtra("EDIT_RACE",race);
                intent.putExtra("EDIT_CLAS",clas);
                startActivityForResult(intent, EDIT_CHARACTER_ACTIVITY_REQUEST_CODE);
                return true;
        }
        return true;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if (requestCode == EDIT_CHARACTER_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK){
            Character character = new Character((data.getIntExtra(EditCharacterActivity.ID_REPLY, 0)), data.getStringExtra(EditCharacterActivity.NAME_REPLY),data.getIntExtra(EditCharacterActivity.LEVEL_REPLY, 0),data.getStringExtra(EditCharacterActivity.RACE_REPLY),data.getStringExtra(EditCharacterActivity.CLAS_REPLY));
            mDetailsViewModel.update(character);
            getActivity().getSupportFragmentManager().popBackStack();

        } else {
            Toast.makeText(
                    getActivity().getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();

        }
    }


}

