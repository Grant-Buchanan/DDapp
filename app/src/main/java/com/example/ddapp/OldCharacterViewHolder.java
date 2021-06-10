package com.example.ddapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class OldCharacterViewHolder extends RecyclerView.ViewHolder {
    private final TextView characterItemView;

    OldCharacterViewHolder(View itemView){
        super(itemView);
        characterItemView = itemView.findViewById(R.id.textName);
    }

    public void bind(int text){
        characterItemView.setText(text);
    }

    static OldCharacterViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new OldCharacterViewHolder(view);
    }
}
