package com.example.ddapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import static com.example.ddapp.RecyclerViewFragment.NEW_CHARACTER_ACTIVITY_REQUEST_CODE;

public class MainActivity extends AppCompatActivity {

    private DetailsViewModel mDetailsViewModel;
    private CharacterRepository repo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().setFragmentFactory(Factory);
        repo = CharacterRepository.getInstance(getApplicationContext());


        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            RecyclerViewFragment fragment = new RecyclerViewFragment();
            transaction.replace(R.id.main_frag, fragment);
            transaction.commit();
        }
        mDetailsViewModel= new ViewModelProvider(this).get(DetailsViewModel.class);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener( view ->{
            Intent intent = new Intent(MainActivity.this, NewCharacterActivity.class);
            startActivityForResult(intent, NEW_CHARACTER_ACTIVITY_REQUEST_CODE);


        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if (requestCode == NEW_CHARACTER_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK){
            Character character = new Character(data.getIntExtra(NewCharacterActivity.EXTRA_REPLY, 0), data.getStringExtra(NewCharacterActivity.EXTRA_REPLY),0,"null","null");
            mDetailsViewModel.insert(character);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    FragmentFactory Factory = new FragmentFactory(){

    };
}