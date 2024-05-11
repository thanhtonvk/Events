package com.example.events;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.events.adapters.PlaceAdapter.getPlace;

import com.bumptech.glide.Glide;

public class PlaceDetailsActivity extends AppCompatActivity {
    TextView txtName, txtTitle, txtArea, txtCost, txtDescription1, txtDescription2, txtDescription3;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);
        findViewById(R.id.btnBook).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), BookingActivity.class));
            }
        });

        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        init();
        setDetails();

    }

    private void init() {
        txtName = findViewById(R.id.txtName);
        txtTitle = findViewById(R.id.txtTitle);
        txtArea = findViewById(R.id.txtArea);
        txtCost = findViewById(R.id.txtCost);
        txtDescription1 = findViewById(R.id.txtDescription1);
        txtDescription2 = findViewById(R.id.txtDescription2);
        txtDescription3 = findViewById(R.id.txtDescription3);
        img = findViewById(R.id.img);
    }

    @SuppressLint("SetTextI18n")
    private void setDetails() {
        txtName.setText(getPlace.getName());
        txtTitle.setText(getPlace.getName());
        txtArea.setText(getPlace.getArea());
        txtCost.setText(getPlace.getMinCost() + " - " + getPlace.getMaxCost() + "đ");
        txtDescription1.setText("Event type: " + getPlace.getEventType());
        txtDescription2.setText("Quantity: " + getPlace.getQuantity());
        txtDescription3.setText(getPlace.getOther());
        Glide.with(getApplicationContext())
                .load(getPlace.getImage())
                .centerCrop()
                .into(img);

    }

}