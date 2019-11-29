package com.gmail.gwonii.jobrom.controller;

import androidx.recyclerview.widget.DiffUtil;

import com.gmail.gwonii.jobrom.model.CardStackModel;

import java.util.ArrayList;

public class SpotDiffCallback extends DiffUtil.Callback {

    private ArrayList<CardStackModel> oldCard;
    private ArrayList<CardStackModel> newCard;

    public SpotDiffCallback(ArrayList<CardStackModel> oldCard, ArrayList<CardStackModel> newCard) {
        this.oldCard = oldCard;
        this.newCard = newCard;
    }

    @Override
    public int getOldListSize() {
        return oldCard.size();
    }

    @Override
    public int getNewListSize() {
        return newCard.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {


        return oldCard.get(oldItemPosition).getId() == newCard.get(newItemPosition).getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {

        return oldCard.get(oldItemPosition) == newCard.get(newItemPosition);
    }

}
