package com.example.ddapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import static android.app.Activity.RESULT_OK;



public class DetailsFragment extends Fragment {

    //Request code for starting a new EditCharacter activity
    private static final int EDIT_CHARACTER_ACTIVITY_REQUEST_CODE = 1;

    //Empty instances of needed variables
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
    static Integer armorClass;
    static Integer speed;
    static Integer prof;

    static Character character;

    //Instances of needed TextViews
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
    TextView detailsArmorClass;
    TextView detailsSpeed;
    TextView detailsProf;
    TextView detailsArco;
    TextView detailsAH;
    TextView detailsArc;
    TextView detailsAth;
    TextView detailsDecept;
    TextView detailsHist;
    TextView detailsIns;
    TextView detailsIntimi;
    TextView detailsInvest;
    TextView detailsMed;
    TextView detailsNat;
    TextView detailsPerc;
    TextView detailsPerf;
    TextView detailsPers;
    TextView detailsRelig;
    TextView detailsSoH;
    TextView detailsSteal;
    TextView detailsSurv;

    //Character class ImageView.
    ImageButton detailsImage;

    //Reference to the view model.
    private DetailsViewModel mDetailsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.details_fragment, container, false);

        //Set view model provider.
        mDetailsViewModel = new ViewModelProvider(this).get(DetailsViewModel.class);

        //Find references to TextViews and...
        detailsName = view.findViewById(R.id.detailsName);
        detailsLevel = view.findViewById(R.id.detailsLevel);
        detailsRace = view.findViewById(R.id.detailsRace);
        detailsClas = view.findViewById(R.id.detailsClass);
        detailsSize = view.findViewById(R.id.detailsSize);
        detailsBackground = view.findViewById(R.id.detailsBackground);
        detailsAlignment = view.findViewById(R.id.detailsAlignment);
        detailsInit = view.findViewById(R.id.detailsInit);
        detailsStr = view.findViewById(R.id.detailsStrNum);
        detailsDex = view.findViewById(R.id.detailsDexNum);
        detailsCon = view.findViewById(R.id.detailsConNum);
        detailsInt = view.findViewById(R.id.detailsIntNum);
        detailsWis = view.findViewById(R.id.detailsWisNum);
        detailsChr = view.findViewById(R.id.detailsChrNum);
        detailsHP = view.findViewById(R.id.detailsHP);
        detailsArmorClass = view.findViewById(R.id.detailsArmorClass);
        detailsSpeed = view.findViewById(R.id.detailsSpeed);
        detailsProf = view.findViewById(R.id.detailsProf);

        detailsArco = view.findViewById(R.id.detailsAcro);
        detailsAH = view.findViewById(R.id.detailsAH);
        detailsArc = view.findViewById(R.id.detailsArc);
        detailsAth = view.findViewById(R.id.detailsAth);
        detailsDecept = view.findViewById(R.id.detailsDecept);
        detailsHist = view.findViewById(R.id.detailsHist);
        detailsIns = view.findViewById(R.id.detailsIns);
        detailsIntimi = view.findViewById(R.id.detailsIntimi);
        detailsInvest = view.findViewById(R.id.detailsInvest);
        detailsMed = view.findViewById(R.id.detailsMed);
        detailsNat = view.findViewById(R.id.detailsNat);
        detailsPerc = view.findViewById(R.id.detailsPerc);
        detailsPerf = view.findViewById(R.id.detailsPerf);
        detailsPers = view.findViewById(R.id.detailsPers);
        detailsRelig = view.findViewById(R.id.detailsRelig);
        detailsSoH = view.findViewById(R.id.detailsSoH);
        detailsSteal = view.findViewById(R.id.detailsSteal);
        detailsSurv = view.findViewById(R.id.detailsSurv);


        //...set each field appropriately based on data passed from selected item in recyclerView.
        detailsName.setText(name);
        detailsLevel.setText("Level " + level);
        detailsRace.setText(race);
        detailsClas.setText(clas);
        detailsSize.setText(size);
        detailsBackground.setText(background);
        detailsAlignment.setText("(" + alignment + ")");
        detailsInit.setText("INIT " + init);
        detailsStr.setText(Integer.toString(str));
        detailsDex.setText(Integer.toString(dex));
        detailsCon.setText(Integer.toString(con));
        detailsInt.setText(Integer.toString(intelligence));
        detailsWis.setText(Integer.toString(wis));
        detailsChr.setText(Integer.toString(chr));
        detailsHP.setText(HP + "/" + HP + " HP");
        armorClass = (10 + (dex - 10)/2);
        detailsArmorClass.setText("AC "+ armorClass);
        detailsSpeed.setText("Speed 30 ft");
        prof = (2 + (level - 1)/4);
        detailsProf.setText("Prof " + prof);
        detailsArco.setText(calculateModifier(dex));
        detailsAH.setText(calculateModifier(wis));
        detailsArc.setText(calculateModifier(intelligence));
        detailsAth.setText(calculateModifier(str));
        detailsDecept.setText(calculateModifier(chr));
        detailsHist.setText(calculateModifier(intelligence));
        detailsIns.setText(calculateModifier(wis));
        detailsIntimi.setText(calculateModifier(chr));
        detailsInvest.setText(calculateModifier(intelligence));
        detailsMed.setText(calculateModifier(wis));
        detailsNat.setText(calculateModifier(intelligence));
        detailsPerc.setText(calculateModifier(wis));
        detailsPerf.setText(calculateModifier(chr));
        detailsPers.setText(calculateModifier(chr));
        detailsRelig.setText(calculateModifier(intelligence));
        detailsSoH.setText(calculateModifier(dex));
        detailsSteal.setText(calculateModifier(dex));
        detailsSurv.setText(calculateModifier(wis));



        //Set the ImageView based on which class the character is.
        //TODO: allow users to upload their own images to serve as profile pictures. I'll likely keep this code section in to serve as a default image even after this is done.
        detailsImage = view.findViewById(R.id.detailsImage);

        switch(clas){
            case"Barbarian":
                detailsImage.setImageResource(R.drawable.lorc_barbarian);
                break;
            case"Cleric":
                detailsImage.setImageResource(R.drawable.lorc_cleric);
                break;
            case"Druid":
                detailsImage.setImageResource(R.drawable.lorc_druid);
                break;
            case"Fighter":
                detailsImage.setImageResource(R.drawable.lorc_fighter);
                break;
            case"Monk":
                detailsImage.setImageResource(R.drawable.lorc_monk);
                break;
            case"Paladin":
                detailsImage.setImageResource(R.drawable.lorc_paladin);
                break;
            case"Ranger":
                detailsImage.setImageResource(R.drawable.lorc_ranger);
                break;
            case"Rogue":
                detailsImage.setImageResource(R.drawable.lorc_rogue);
                break;
            case"Sorcerer":
                detailsImage.setImageResource(R.drawable.lorc_sorcerer);
                break;
            case"Warlock":
                detailsImage.setImageResource(R.drawable.lorc_warlock);
                break;
            case"Wizard":
                detailsImage.setImageResource(R.drawable.lorc_wizard);
                break;
            default:
                detailsImage.setImageResource(R.drawable.lorc_rogue);
                break;
        }

        //Lets the fragment know that it has an options menu in the action bar that it needs to be paying attention to (tracking clicks, refreshing menus)
        setHasOptionsMenu(true);

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
                //Todo: Change this to be just the character ID instead of making an entirely new character in order to tell the database what to delete
                character = new Character(id,name,level,race,clas,size,background,alignment,init,str,dex,con,intelligence,wis,chr,HP);
                mDetailsViewModel.delete(character);
                getActivity().getSupportFragmentManager().popBackStack();
                return true;

            case R.id.action_edit:
                //Edit a character. Add all current character variables to a new Intent with EditCharacterActivity.
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

                //Start a new EditCharacterActivity with a request code.
                startActivityForResult(intent, EDIT_CHARACTER_ACTIVITY_REQUEST_CODE);
                return true;
        }
        return true;
    }

    //Called when returning from EditCharacterActivity.
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        //If the correct request and result codes are given, proceed with editing the character.
        if (requestCode == EDIT_CHARACTER_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK){
            //Create a new character.
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
            //Replace the existing character with the new character.
            mDetailsViewModel.update(character);
            getActivity().getSupportFragmentManager().popBackStack();

        } else {
            //Or let the user know that the edit operation failed.
            //Todo: make this message more helpful to the user
            Toast.makeText(
                    getActivity().getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();

        }
    }

    //Helper function to calculate ability modifiers
    public String calculateModifier(int value){
        value = ((value - 10) / 2);
        if (value < 0){
            String result = Integer.toString(value);
            return result;
        }
        else{
            String result = "+" + value;
            return result;
        }

    }

}

