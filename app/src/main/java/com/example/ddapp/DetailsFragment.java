package com.example.ddapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import static android.app.Activity.RESULT_OK;



public class DetailsFragment extends Fragment {

    private static final int EDIT_CHARACTER_ACTIVITY_REQUEST_CODE = 1;
    static Integer id;
    static String name;
    static Integer level;
    static String race;
    static String clas;
    static String size;
    static String background;
    static String alignment;
    static Integer init;
    static Integer str;
    static Integer dex;
    static Integer con;
    static Integer intelligence;
    static Integer wis;
    static Integer chr;
    static Integer HP;
    static Character character;
    TextView detailsName;
    TextView detailsLevel;
    TextView detailsRace;
    TextView detailsClas;
    TextView detailsSize;
    TextView detailsBackground;
    TextView detailsAlignment;
    TextView detailsInit;
    TextView detailsStr;
    TextView detailsDex;
    TextView detailsCon;
    TextView detailsInt;
    TextView detailsWis;
    TextView detailsChr;
    TextView detailsHP;
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
        detailsSize = view.findViewById(R.id.detailsSize);
        //
        //
        //
        detailsStr = view.findViewById(R.id.detailsStrNum);
        detailsDex = view.findViewById(R.id.detailsDexNum);
        detailsCon = view.findViewById(R.id.detailsConNum);
        detailsInt = view.findViewById(R.id.detailsIntNum);
        detailsWis = view.findViewById(R.id.detailsWisNum);
        detailsChr = view.findViewById(R.id.detailsChrNum);
        detailsName.setText(name);
        detailsLevel.setText("Level " + level);
        detailsRace.setText(race);
        detailsClas.setText(clas);
        detailsSize.setText(size);
        //detailsBackground
        //detailsAlignment
        //detailsInit;
        detailsStr.setText(Integer.toString(str));
        detailsDex.setText(Integer.toString(dex));
        detailsCon.setText(Integer.toString(con));
        detailsInt.setText(Integer.toString(intelligence));
        detailsWis.setText(Integer.toString(wis));
        detailsChr.setText(Integer.toString(chr));

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
        size = bundle.getString("size");
        background = bundle.getString("background");
        alignment = bundle.getString("alignment");
        init = bundle.getInt("init");
        str = bundle.getInt("str");
        dex = bundle.getInt("dex");
        con = bundle.getInt("con");
        intelligence = bundle.getInt("int");
        wis = bundle.getInt("wis");
        chr = bundle.getInt("chr");
        HP = bundle.getInt("HP");

        return new DetailsFragment();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            //Click listener for behavior specific to the DetailsFragment

            case R.id.action_delete:
                //Delete a character
                character = new Character(id,name,level,race,clas,size,background,alignment,init,str,dex,con,intelligence,wis,chr,HP);
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
                intent.putExtra("EDIT_SIZE",size);
                intent.putExtra("EDIT_ALIGNMENT", alignment);
                intent.putExtra("EDIT_BACKGROUND", background);
                intent.putExtra("EDIT_INIT", init);
                intent.putExtra("EDIT_STR", str);
                intent.putExtra("EDIT_DEX", dex);
                intent.putExtra("EDIT_CON", con);
                intent.putExtra("EDIT_INT", intelligence);
                intent.putExtra("EDIT_WIS", wis);
                intent.putExtra("EDIT_CHR", chr);
                intent.putExtra("EDIT_HP", HP);

                startActivityForResult(intent, EDIT_CHARACTER_ACTIVITY_REQUEST_CODE);
                return true;
        }
        return true;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if (requestCode == EDIT_CHARACTER_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK){
            Character character = new Character(
                    (data.getIntExtra(EditCharacterActivity.ID_REPLY, 0)),
                    data.getStringExtra(EditCharacterActivity.NAME_REPLY),
                    data.getIntExtra(EditCharacterActivity.LEVEL_REPLY, 0),
                    data.getStringExtra(EditCharacterActivity.RACE_REPLY),
                    data.getStringExtra(EditCharacterActivity.CLAS_REPLY),
                    data.getStringExtra(EditCharacterActivity.SIZE_REPLY),
                    data.getStringExtra(EditCharacterActivity.BACKGROUND_REPLY),
                    data.getStringExtra(EditCharacterActivity.ALIGNMENT_REPLY),
                    data.getIntExtra(EditCharacterActivity.INIT_REPLY, 0),
                    data.getIntExtra(EditCharacterActivity.STR_REPLY,10),
                    data.getIntExtra(EditCharacterActivity.DEX_REPLY,10),
                    data.getIntExtra(EditCharacterActivity.CON_REPLY,10),
                    data.getIntExtra(EditCharacterActivity.INT_REPLY,10),
                    data.getIntExtra(EditCharacterActivity.WIS_REPLY,10),
                    data.getIntExtra(EditCharacterActivity.CHR_REPLY,10),
                    data.getIntExtra(EditCharacterActivity.HP_REPLY,10));
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

