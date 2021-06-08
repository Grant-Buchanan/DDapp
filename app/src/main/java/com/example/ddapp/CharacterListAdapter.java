package com.example.ddapp;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentTransaction;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CharacterListAdapter extends ListAdapter<Character, CharacterViewHolder> {


    private FragmentManager mfragmentManager;
    private Context mContext;
    private LiveData<List<Character>> mAllCharacters;

    public CharacterListAdapter(@NonNull DiffUtil.ItemCallback<Character> diffCallback, CharacterRepository characterRepository, Context context, FragmentManager fragmentManager){
        super(diffCallback);
        mContext = context;
        mAllCharacters = characterRepository.getInstance(context).getAllCharacters();

    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_frag,parent, false);
        return new CharacterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        Character current = getItem(position);
        //replace with getChar later
        holder.bind(current.getId());
    }

    static class CharacterDiff extends DiffUtil.ItemCallback<Character>{

        @Override
        public boolean areItemsTheSame(@NonNull Character oldItem, @NonNull Character newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Character oldItem, @NonNull Character newItem) {
            return oldItem.getName().equals(newItem.getName());
        }
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
