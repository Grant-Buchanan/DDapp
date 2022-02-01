package com.example.ddapp;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import static com.example.ddapp.RecyclerViewFragment.NEW_CHARACTER_ACTIVITY_REQUEST_CODE;

public class MainActivity extends AppCompatActivity {

    private DetailsViewModel mDetailsViewModel;
    static FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().setFragmentFactory(Factory);


        setFab();
        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            RecyclerViewFragment fragment = new RecyclerViewFragment();
            transaction.replace(R.id.main_frag, fragment);
            transaction.commit();
        }
        mDetailsViewModel= new ViewModelProvider(this).get(DetailsViewModel.class);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    protected void onResume() {
        super.onResume();

        invalidateOptionsMenu();
    }


    public void setFab(){
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener( view ->{
            Intent intent = new Intent(MainActivity.this, NewCharacterActivity.class);
            startActivityForResult(intent, NEW_CHARACTER_ACTIVITY_REQUEST_CODE);


        });
    }



    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if (requestCode == NEW_CHARACTER_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK){
            Character character = new Character(data.getIntExtra(NewCharacterActivity.NAME_REPLY, 0),
                    data.getStringExtra(NewCharacterActivity.NAME_REPLY),
                    data.getIntExtra(NewCharacterActivity.LEVEL_REPLY, 0),
                    data.getStringExtra(EditCharacterActivity.RACE_REPLY),
                    data.getStringExtra(EditCharacterActivity.CLAS_REPLY),
                    data.getStringExtra(EditCharacterActivity.SIZE_REPLY),
                    data.getStringExtra(EditCharacterActivity.BACKGROUND_REPLY),
                    data.getStringExtra(EditCharacterActivity.ALIGNMENT_REPLY),
                    data.getIntExtra(EditCharacterActivity.INIT_REPLY, 10),
                    data.getIntExtra(EditCharacterActivity.STR_REPLY,10),
                    data.getIntExtra(EditCharacterActivity.DEX_REPLY,10),
                    data.getIntExtra(EditCharacterActivity.CON_REPLY,10),
                    data.getIntExtra(EditCharacterActivity.INT_REPLY,10),
                    data.getIntExtra(EditCharacterActivity.WIS_REPLY,10),
                    data.getIntExtra(EditCharacterActivity.CHR_REPLY,10),
                    data.getIntExtra(EditCharacterActivity.HP_REPLY,10));
            mDetailsViewModel.insert(character);
        } else if (getSupportFragmentManager().findFragmentById(R.id.main_frag) instanceof DetailsFragment) {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.edit_success,
                    Toast.LENGTH_LONG).show();

        }
        else{
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the action bar settings menu
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem itemSettings = menu.findItem(R.id.action_settings);
        MenuItem itemEdit = menu.findItem(R.id.action_edit);
        MenuItem itemDelete = menu.findItem(R.id.action_delete);
        // Check which fragment is currently in focus
        if(checkCurrentFragment(getCurrentFragment()) == 2){
            itemSettings.setVisible(true);
            itemEdit.setVisible(false);
            itemDelete.setVisible(false);
        }
        if(checkCurrentFragment(getCurrentFragment()) == 1){
            itemSettings.setVisible(false);
            itemDelete.setVisible(true);
            itemEdit.setVisible(true);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        Log.d("FRAG","Fragment is " + getSupportFragmentManager().findFragmentById(R.id.main_frag).getClass().getSimpleName());

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Log.d("OPTIONS_SWITCH", "Option settings");
            return true;
        }
        else if(id == R.id.action_edit){
            Log.d("OPTIONS_SWITCH", "Option edit" );
        }
        else{
            Log.d("OPTIONS_SWITCH", "Option delete");
        }

        return super.onOptionsItemSelected(item);
    }

    public Fragment getCurrentFragment(){
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.main_frag);
        return currentFragment;
    }

    public int checkCurrentFragment(Fragment currentFragment){
        if(currentFragment instanceof DetailsFragment){
            return 1;
        }
        return 2;
    }

    FragmentFactory Factory = new FragmentFactory(){

    };
}