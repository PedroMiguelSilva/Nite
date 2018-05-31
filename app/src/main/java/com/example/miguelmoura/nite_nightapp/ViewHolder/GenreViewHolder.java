package com.example.miguelmoura.nite_nightapp.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.miguelmoura.nite_nightapp.Interface.ItemClickListener;
import com.example.miguelmoura.nite_nightapp.R;


public class GenreViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView txtGenreName;
    public ImageView imageView;
    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public GenreViewHolder(View itemView) {
        super(itemView);

        txtGenreName = itemView.findViewById(R.id.genre_name);
        imageView =  itemView.findViewById(R.id.genre_image);

        itemView.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(), false);


    }
}
