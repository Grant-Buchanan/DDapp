package com.example.ddapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

public class NewCharacterActivity extends AppCompatActivity {

    //Key identifiers for adding entered data to replyIntent.
    public static final String ID_REPLY = "com.example.android.idlistsql.REPLY";
    public static final String NAME_REPLY = "com.example.android.characterlistsql.REPLY";
    public static final String LEVEL_REPLY = "com.example.android.levellistsql.REPLY";
    public static final String RACE_REPLY = "com.example.android.racelistsql.REPLY";
    public static final String CLAS_REPLY = "com.example.android.claslistsql.REPLY";
    public static final String SIZE_REPLY = "com.example.android.sizelistsql.REPLY";
    public static final String BACKGROUND_REPLY = "com.example.android.backgroundlistsql.REPLY";
    public static final String ALIGNMENT_REPLY = "com.example.android.alignmentlistsql.REPLY";
    public static final String INIT_REPLY = "com.example.android.initlistsql.REPLY";
    public static final String STR_REPLY = "com.example.android.strlistsql.REPLY";
    public static final String DEX_REPLY = "com.example.android.dexlistsql.REPLY";
    public static final String CON_REPLY = "com.example.android.conlistsql.REPLY";
    public static final String INT_REPLY = "com.example.android.intlistsql.REPLY";
    public static final String WIS_REPLY = "com.example.android.wislistsql.REPLY";
    public static final String CHR_REPLY = "com.example.android.chrlistsql.REPLY";
    public static final String HP_REPLY = "com.example.android.hplistsql.REPLY";

    //Instances of needed EditTexts
    private EditText mEditCharacterView;
    private EditText mEditLevelView;
    private EditText mEditRaceView;
    private EditText mEditClasView;
    private EditText mEditSizeView;
    private EditText mEditBackgroundView;
    private EditText mEditAlignmentView;
    private EditText mEditInitView;
    private EditText mEditStrView;
    private EditText mEditDexView;
    private EditText mEditConView;
    private EditText mEditIntView;
    private EditText mEditWisView;
    private EditText mEditChrView;
    private EditText mEditHPView;
    private Bundle mCharacterBundle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Set views
        setContentView(R.layout.activity_new_character);
        mEditCharacterView = findViewById(R.id.edit_name);
        mEditLevelView = findViewById(R.id.edit_level);
        mEditRaceView = findViewById(R.id.edit_race);
        mEditClasView = findViewById(R.id.edit_class);
        mEditSizeView = findViewById(R.id.edit_size);
        mEditBackgroundView = findViewById(R.id.edit_background);
        mEditAlignmentView = findViewById(R.id.edit_alignment);
        mEditInitView = findViewById(R.id.edit_init);
        mEditStrView = findViewById(R.id.edit_str);
        mEditDexView = findViewById(R.id.edit_dex);
        mEditConView = findViewById(R.id.edit_con);
        mEditIntView = findViewById(R.id.edit_int);
        mEditWisView = findViewById(R.id.edit_wis);
        mEditChrView = findViewById(R.id.edit_chr);
        mEditHPView = findViewById(R.id.edit_hp);

        //Save character button.
        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(view -> {
            //Create a new intent for holding character data.
            Intent replyIntent = new Intent();
            //Cancel adding a character if these fields are empty.
            if (TextUtils.isEmpty(mEditCharacterView.getText()) || TextUtils.isEmpty(mEditLevelView.getText()) || TextUtils.isEmpty(mEditRaceView.getText()) || TextUtils.isEmpty(mEditClasView.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {

                //Retrieve data from EditText boxes.
                String name = capitalizeInput(mEditCharacterView.getText().toString());
                int level = Integer.parseInt(mEditLevelView.getText().toString());
                String race = mEditRaceView.getText().toString();
                String clas = capitalizeInput(mEditClasView.getText().toString());
                String size = mEditSizeView.getText().toString();
                String background = mEditBackgroundView.getText().toString();
                String alignment = mEditAlignmentView.getText().toString();
                int init = Integer.parseInt(mEditInitView.getText().toString());
                int str = Integer.parseInt(mEditStrView.getText().toString());
                int dex = Integer.parseInt(mEditDexView.getText().toString());
                int con = Integer.parseInt(mEditConView.getText().toString());
                int intelligence = Integer.parseInt(mEditIntView.getText().toString());
                int wis = Integer.parseInt(mEditWisView.getText().toString());
                int chr = Integer.parseInt(mEditChrView.getText().toString());
                int hp = Integer.parseInt(mEditHPView.getText().toString());

                //Add data to intent.
                replyIntent.putExtra(NAME_REPLY, name);
                replyIntent.putExtra(LEVEL_REPLY, level);
                replyIntent.putExtra(RACE_REPLY, race);
                replyIntent.putExtra(CLAS_REPLY, clas);
                replyIntent.putExtra(SIZE_REPLY, size);
                replyIntent.putExtra(BACKGROUND_REPLY, background);
                replyIntent.putExtra(ALIGNMENT_REPLY,alignment);
                replyIntent.putExtra(INIT_REPLY, init);
                replyIntent.putExtra(STR_REPLY, str);
                replyIntent.putExtra(DEX_REPLY, dex);
                replyIntent.putExtra(CON_REPLY, con);
                replyIntent.putExtra(INT_REPLY, intelligence);
                replyIntent.putExtra(WIS_REPLY, wis);
                replyIntent.putExtra(CHR_REPLY, chr);
                replyIntent.putExtra(HP_REPLY, hp);

                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }

    //Helper method to capitalize the first letter of user input to enforce grammatical consistency.
    public static String capitalizeInput(String input){
        String output = input;
        try{
            output = input.substring(0,1).toUpperCase() + output.substring(1);
        }
        catch (Exception e){}
        return output;
    }
}