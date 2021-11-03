package com.example.ddapp;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import java.util.List;

public class CharacterListAdapter extends ListAdapter<Character, CharacterViewHolder> {

    private LiveData<List<Character>> mAllCharacters;

    public  CharacterListAdapter(@NonNull DiffUtil.ItemCallback<Character> diffCallback, CharacterRepository repo, Context context){
        super(diffCallback);
        mAllCharacters = repo.getInstance(context).getAllCharacters();
    }

    @Override
    public CharacterViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        return CharacterViewHolder.create(parent);
    }


    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        Character current = getItem(position);
        final int id = current.getId();
        final String name = current.getName();
        final int level = current.getLevel();
        final String race = current.getRace();
        final String clas = current.getClas();

        holder.textName.setText(name);
        holder.textLevel.setText("Level " + Integer.toString(level));
        holder.textRace.setText(race);
        holder.textClas.setText(clas);
        //replace with getChar later

    }

    static class CharDiff extends DiffUtil.ItemCallback<Character>{

        @Override
        public boolean areItemsTheSame(@NonNull Character oldItem, @NonNull Character newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Character oldItem, @NonNull Character newItem) {
            return oldItem.getName().equals(newItem.getName());
        }
    }
}
