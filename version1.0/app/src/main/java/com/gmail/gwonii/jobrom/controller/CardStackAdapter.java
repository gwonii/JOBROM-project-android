package com.gmail.gwonii.jobrom.controller;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.gmail.gwonii.jobrom.R;
import com.gmail.gwonii.jobrom.model.CardStackModel;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CardStackAdapter extends RecyclerView.Adapter<CardStackAdapter.CardStackViewHolder> {


    private ArrayList<CardStackModel> cards;
    private ViewGroup viewGroup;

    private CardStackAdapter.OnListItemSelectedInterface mListener;

    public interface OnListItemSelectedInterface {
        void onItemSelected(View v, int position);
    }

    public CardStackAdapter(ArrayList<CardStackModel> cards) {
        this.cards = cards;
    }


    public class CardStackViewHolder extends RecyclerView.ViewHolder {

        protected TextView name;
        protected TextView city;
        protected ImageView image;

        public CardStackViewHolder(View view) {
            super(view);

            this.name = view.findViewById(R.id.item_name);
            this.city = view.findViewById(R.id.item_city);
            this.image = view.findViewById(R.id.item_image);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("Recyclerview", "position = "+ getAdapterPosition());
                }
            });
        }


    }



    @NonNull
    @Override
    public CardStackViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        this.viewGroup = viewGroup;

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.job_card_list, viewGroup, false);

        CardStackViewHolder viewHolder = new CardStackViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CardStackViewHolder viewHolder, int position) {

        CardStackModel card = cards.get(position);

        viewHolder.name.setText(card.getName());
        viewHolder.city.setText(card.getCity());
        Glide.with(viewHolder.image.getContext())
                .load(card.getUrl())
                .into(viewHolder.image);
    }

    @Override
    public int getItemCount() {
        return 3;
    }



    // basic method

    public void setCards(ArrayList<CardStackModel> cards) {
        this.cards = cards;
    }

    public ArrayList<CardStackModel> getCards() {
        return cards;
    }



}
