package com.example.ddapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditCharacterActivity extends AppCompatActivity {

    public static final String ID_REPLY = "com.example.android.idlistsql.REPLY";
    public static final String NAME_REPLY = "com.example.android.characterlistsql.REPLY";
    public static final String LEVEL_REPLY = "com.example.android.levellistsql.REPLY";
    public static final String RACE_REPLY = "com.example.android.racelistsql.REPLY";
    public static final String CLAS_REPLY = "com.example.android.claslistsql.REPLY";

    private EditText mEditCharacterView;
    private EditText mEditLevelView;
    private EditText mEditRaceView;
    private EditText mEditClasView;
    private Bundle mCharacterBundle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_new_character);
        mEditCharacterView = findViewById(R.id.edit_word);
        mEditLevelView = findViewById(R.id.edit_word2);
        mEditRaceView = findViewById(R.id.edit_word3);
        mEditClasView = findViewById(R.id.edit_word4);

        mEditCharacterView.setText(getIntent().getExtras().getString("EDIT_NAME"));
        int level1 = getIntent().getExtras().getInt("EDIT_LEVEL");
        mEditLevelView.setText(String.valueOf(level1));
        mEditRaceView.setText(getIntent().getExtras().getString("EDIT_RACE"));
        mEditClasView.setText(getIntent().getExtras().getString("EDIT_CLAS"));
        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(mEditCharacterView.getText()) || TextUtils.isEmpty(mEditLevelView.getText()) || TextUtils.isEmpty(mEditRaceView.getText()) || TextUtils.isEmpty(mEditClasView.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                int id = getIntent().getExtras().getInt("EDIT_ID");
                String name = mEditCharacterView.getText().toString();
                int level = Integer.parseInt(mEditLevelView.getText().toString());
                String race = mEditRaceView.getText().toString();
                String clas = mEditClasView.getText().toString();

                replyIntent.putExtra(ID_REPLY,id);
                replyIntent.putExtra(NAME_REPLY, name);
                replyIntent.putExtra(LEVEL_REPLY, level);
                replyIntent.putExtra(RACE_REPLY, race);
                replyIntent.putExtra(CLAS_REPLY, clas);

                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }
}