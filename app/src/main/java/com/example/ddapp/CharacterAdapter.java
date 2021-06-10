package com.example.ddapp;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentFactory;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> {


    private FragmentManager mfragmentManager;
    private Context mContext;
    private LiveData<List<Character>> mAllCharacters;
    private DetailsViewModel model;

    public CharacterAdapter(@NonNull CharacterRepository characterRepository, Context context, FragmentManager fragmentManager){

        mContext = context;
        mfragmentManager = fragmentManager;
        mAllCharacters = characterRepository.getInstance(context).getAllCharacters();

    }

    class CharacterViewHolder extends RecyclerView.ViewHolder{

        TextView textName;
        TextView textLevel;
        TextView textRace;
        TextView textClas;

        public CharacterViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.textName);
            textLevel = itemView.findViewById(R.id.textLevel);
            textRace = itemView.findViewById(R.id.textRace);
            textClas = itemView.findViewById(R.id.textClass);
        }
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recyclerview_item, viewGroup, false);

        return new CharacterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        Character character = mAllCharacters.getValue().get(position);
        final int id = character.getId();
        final String name = character.getName();
        final int level = character.getLevel();
        final String race = character.getRace();
        final String clas = character.getClas();

        holder.textName.setText(name);
        holder.textLevel.setText("Level " + Integer.toString(level));
        holder.textRace.setText(race);
        holder.textClas.setText(clas);
        //replace with getChar later

    }

    public int getItemCount() {
        return mAllCharacters.getValue().size();
    }
    //Bundle
    public Bundle getChar(String id){

        Bundle textBundle = new Bundle();
        textBundle.putString("id", id);
        return textBundle;
    }
    FragmentFactory Factory = new FragmentFactory(){

    };


}
