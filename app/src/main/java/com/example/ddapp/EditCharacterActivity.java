package com.example.ddapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditCharacterActivity extends AppCompatActivity {

    //Key identifiers for adding edited data to replyIntent.
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

        setContentView(R.layout.activity_new_character);

        //Set views
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
        //Retrieve character data from intent and set the current values in the EditText fields
        mEditCharacterView.setText(getIntent().getExtras().getString("EDIT_NAME"));
        int level1 = getIntent().getExtras().getInt("EDIT_LEVEL");
        mEditLevelView.setText(String.valueOf(level1));
        mEditRaceView.setText(getIntent().getExtras().getString("EDIT_RACE"));
        mEditClasView.setText(getIntent().getExtras().getString("EDIT_CLAS"));
        mEditSizeView.setText(getIntent().getExtras().getString("EDIT_SIZE"));
        mEditBackgroundView.setText(getIntent().getExtras().getString("EDIT_BACKGROUND"));
        mEditAlignmentView.setText(getIntent().getExtras().getString("EDIT_ALIGNMENT"));
        int init1 = getIntent().getExtras().getInt("EDIT_INIT");
        mEditInitView.setText(String.valueOf(init1));
        int str1 = getIntent().getExtras().getInt("EDIT_STR");
        mEditStrView.setText(String.valueOf(str1));
        int dex1 = getIntent().getExtras().getInt("EDIT_DEX");
        mEditDexView.setText(String.valueOf(dex1));
        int con1 = getIntent().getExtras().getInt("EDIT_CON");
        mEditConView.setText(String.valueOf(con1));
        int int1 = getIntent().getExtras().getInt("EDIT_INT");
        mEditIntView.setText(String.valueOf(int1));
        int wis1 = getIntent().getExtras().getInt("EDIT_WIS");
        mEditWisView.setText(String.valueOf(wis1));
        int chr1 = getIntent().getExtras().getInt("EDIT_CHR");
        mEditChrView.setText(String.valueOf(chr1));
        int HP1 = getIntent().getExtras().getInt("EDIT_HP");
        mEditHPView.setText(String.valueOf(HP1));

        //Button for saving edited data
        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(view -> {
            //New Intent for edited data
            Intent replyIntent = new Intent();
            //If certain fields are empty, cancel the activity
            if (TextUtils.isEmpty(mEditCharacterView.getText()) || TextUtils.isEmpty(mEditLevelView.getText()) || TextUtils.isEmpty(mEditRaceView.getText()) || TextUtils.isEmpty(mEditClasView.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                //Get the current EditText values and set to new variables
                int id = getIntent().getExtras().getInt("EDIT_ID");
                String name = mEditCharacterView.getText().toString();
                int level = Integer.parseInt(mEditLevelView.getText().toString());
                String race = mEditRaceView.getText().toString();
                String clas = mEditClasView.getText().toString();
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

                //Add the new variables to Intent
                replyIntent.putExtra(ID_REPLY,id);
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
}