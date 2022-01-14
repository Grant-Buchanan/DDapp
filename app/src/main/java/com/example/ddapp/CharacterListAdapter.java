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

    private LiveData<List<Character>> mAllCharacters;
    final private OnClickListener mOnClickListener;

    public  CharacterListAdapter(@NonNull DiffUtil.ItemCallback<Character> diffCallback, CharacterRepository repo, Context context, OnClickListener onClickListener){
        super(diffCallback);
        mAllCharacters = repo.getInstance(context).getAllCharacters();
       this.mOnClickListener = onClickListener;
    }

    @Override
    public CharacterViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        return CharacterViewHolder.create(parent, mOnClickListener);
    }


    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
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

    public interface OnClickListener{
        void onCharacterClick(int position);
    }

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
