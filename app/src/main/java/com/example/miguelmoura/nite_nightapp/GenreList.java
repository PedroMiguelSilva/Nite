package com.example.miguelmoura.nite_nightapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.miguelmoura.nite_nightapp.Interface.ItemClickListener;
import com.example.miguelmoura.nite_nightapp.Model.Event;
import com.example.miguelmoura.nite_nightapp.ViewHolder.GenreViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class GenreList extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    private FirebaseDatabase database;
    private DatabaseReference eventList;
    private final String TABLE_EVENT_NAME    = "Event";

    private String categoryId = "";

    private FirebaseRecyclerAdapter<Event,GenreViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre_list);

        database = FirebaseDatabase.getInstance();
        eventList = database.getReference(TABLE_EVENT_NAME);

        recyclerView = findViewById(R.id.recycler_genre);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        if(getIntent() != null)
            categoryId = getIntent().getStringExtra("categoryId");
        if(!categoryId.isEmpty()) {
            loadListEvent(categoryId);
        }
    }

    private void loadListEvent(String categoryId) {
        adapter = new FirebaseRecyclerAdapter<Event, GenreViewHolder>(Event.class,R.layout.genre_item,GenreViewHolder.class,eventList.orderByChild("categoryId").equalTo(categoryId)) {
            @Override
            protected void populateViewHolder(GenreViewHolder viewHolder, Event model, int position) {
                viewHolder.txtGenreName.setText(model.getName());
                Picasso.with(getBaseContext()).load(model.getImage())
                        .into(viewHolder.imageView);
                final Event local = model;

                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        Toast.makeText(GenreList.this, ""+local.getName(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        };
        recyclerView.setAdapter(adapter);
    }
}
