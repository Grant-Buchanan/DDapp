package com.example.ddapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CharacterViewHolder extends RecyclerView.ViewHolder{

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

    static CharacterViewHolder create(ViewGroup parent) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);

        return new CharacterViewHolder(view);
    }

}
