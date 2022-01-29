package com.example.ddapp;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import java.util.List;

public class CharacterListAdapter extends ListAdapter<Character, CharacterViewHolder> {

    //Empty list for population later.
    private LiveData<List<Character>> mAllCharacters;
    //Reference to a ClickListener.
    final private OnClickListener mOnClickListener;

    //Constructor for the adapter.
    public  CharacterListAdapter(@NonNull DiffUtil.ItemCallback<Character> diffCallback, CharacterRepository repo, Context context, OnClickListener onClickListener){
        super(diffCallback);
        mAllCharacters = repo.getInstance(context).getAllCharacters();

        //Set the ClickListener from the RecyclerViewFragment's ClickListener
       this.mOnClickListener = onClickListener;
    }

    //On create, return a new custom view holder with the correct ViewGroup and ClickListener
    @Override
    public CharacterViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        return CharacterViewHolder.create(parent, mOnClickListener);
    }


    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        //Set data to be displayed for every list item based on the position of the item. This code is run once for each item in the database.
        Bundle bundle = getCharacterData(position);
        holder.textName.setText(bundle.getString("name"));
        holder.textLevel.setText("Level " + Integer.toString(bundle.getInt("level")));
        holder.textRace.setText(bundle.getString("race"));
        holder.textClas.setText(bundle.getString("clas"));
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

    //Click listener interface.
    public interface OnClickListener{
        void onCharacterClick(int position);
    }

    //Retrieve the data of an item in the database dependant on the position of the item in the list view. This method is called in onBindViewHolder to provide the list with the data it needs to display items.
    public Bundle getCharacterData(int position){

        Character current = getItem(position);
        final int id = current.getId();
        final String name = current.getName();
        final int level = current.getLevel();
        final String race = current.getRace();
        final String clas = current.getClas();
        final String size = current.getSize();
        final String background = current.getBackground();
        final String alignment = current.getAlignment();
        final int init = current.getInit();
        final int str = current.getStr();
        final int dex = current.getDex();
        final int con = current.getCon();
        final int intelligence = current.getIntelligence();
        final int wis = current.getWis();
        final int chr = current.getChr();
        final int HP = current.getHealthPoints();

        //Put all this information into a bundle for easier access.
        Bundle bundle = new Bundle();
        bundle.putInt("id", id);
        bundle.putString("name", name);
        bundle.putInt("level", level);
        bundle.putString("race", race);
        bundle.putString("clas", clas);
        bundle.putString("size", size);
        bundle.putString("background", background);
        bundle.putString("alignment", alignment);
        bundle.putInt("init", init);
        bundle.putInt("str", str);
        bundle.putInt("dex", dex);
        bundle.putInt("con", con);
        bundle.putInt("int", intelligence);
        bundle.putInt("wis", wis);
        bundle.putInt("chr", chr);
        bundle.putInt("HP",HP);

        return bundle;
    }

}
