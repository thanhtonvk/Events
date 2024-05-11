package com.example.events;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import static com.example.events.FindPlaceActivity.findPlace;

import com.example.events.adapters.PlaceAdapter;
import com.example.events.models.Place;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FindPlaceDetailsListActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Places");
    RecyclerView recyclerView;
    PlaceAdapter placeAdapter;
    List<Place> placeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_place_details_list);

        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        init();
        loadPlaceDetails();
    }

    private void init() {
        recyclerView = findViewById(R.id.rcv_places);
        placeAdapter = new PlaceAdapter(this, placeList);
        recyclerView.setAdapter(placeAdapter);
    }

    private void loadPlaceDetails() {
        myRef.addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                placeList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Place place = dataSnapshot.getValue(Place.class);
                    assert place != null;
                    if (place.getArea().toLowerCase().contains(findPlace.area.toLowerCase()) || place.getEventType().toLowerCase().contains(findPlace.eventype.toLowerCase())
                            || place.getConvenient().toLowerCase().contains(findPlace.convenient.toLowerCase()) || place.getOther().toLowerCase().contains(findPlace.requirements.toLowerCase())) {
                        placeList.add(place);
                        placeAdapter.notifyDataSetChanged();
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}