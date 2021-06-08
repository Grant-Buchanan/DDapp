package com.example.ddapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class CharacterViewHolder extends RecyclerView.ViewHolder {
    private final TextView characterItemView;

    CharacterViewHolder(View itemView){
        super(itemView);
        characterItemView = itemView.findViewById(R.id.textView);
    }

    public void bind(int text){
        characterItemView.setText(text);
    }

    static CharacterViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new CharacterViewHolder(view);
    }
}
