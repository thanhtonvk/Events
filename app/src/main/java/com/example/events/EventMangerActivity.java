package com.example.events;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EventMangerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_manger);
        findViewById(R.id.moreIcon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogMoreOptions();
            }
        });
    }

    private void showDialogMoreOptions() {
        Dialog dialog = new Dialog(EventMangerActivity.this);
        dialog.setContentView(R.layout.dialog_more_options);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.findViewById(R.id.btn_location).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                showDialogLocation();
            }
        });


        dialog.show();

    }

    private void showDialogLocation() {
        Dialog dialog = new Dialog(EventMangerActivity.this);
        dialog.setContentView(R.layout.dialog_location);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.findViewById(R.id.btn_findlocation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                startActivity(new Intent(EventMangerActivity.this, FindPlaceActivity.class));
            }
        });

        dialog.findViewById(R.id.btn_map).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                startActivity(new Intent(EventMangerActivity.this, MapsActivity.class));
            }
        });

        dialog.show();
    }
}