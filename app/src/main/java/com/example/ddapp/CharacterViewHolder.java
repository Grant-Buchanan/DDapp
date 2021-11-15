package com.example.ddapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CharacterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    TextView textName;
    TextView textLevel;
    TextView textRace;
    TextView textClas;
    static CharacterListAdapter.OnClickListener mOnClickListener;

    public CharacterViewHolder(@NonNull View itemView) {
        super(itemView);
        textName = itemView.findViewById(R.id.textName);
        textLevel = itemView.findViewById(R.id.textLevel);
        textRace = itemView.findViewById(R.id.textRace);
        textClas = itemView.findViewById(R.id.textClass);
        itemView.setOnClickListener(this);
    }

    static CharacterViewHolder create(ViewGroup parent, CharacterListAdapter.OnClickListener listener) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);

        mOnClickListener = listener;
        return new CharacterViewHolder(view);
    }

    @Override
    public void onClick(View v) {
        int position = getAdapterPosition();
        mOnClickListener.onCharacterClick(position);
    }
}
