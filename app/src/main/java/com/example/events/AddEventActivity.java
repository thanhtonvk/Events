package com.example.events;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.events.models.Event;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class AddEventActivity extends AppCompatActivity {

    EditText edtEventName, edtTime, edtImage;
    Button btnAddEvent;
    Random random = new Random();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Events");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        init();
        btnAddEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Event event = new Event(String.valueOf(random.nextInt()), edtEventName.getText().toString(), edtTime.getText().toString(), edtImage.getText().toString());
                myRef.child(event.getId()).setValue(event).addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(AddEventActivity.this, "Event added successfully", Toast.LENGTH_SHORT).show();
                        onBackPressed();
                    } else {
                        Toast.makeText(AddEventActivity.this, "Failed to add event", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(e -> {
                    Toast.makeText(AddEventActivity.this, "Failed to add event", Toast.LENGTH_SHORT).show();
                });
            }
        });
        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void init() {
        edtEventName = findViewById(R.id.edt_event_name);
        edtTime = findViewById(R.id.edt_time);
        edtImage = findViewById(R.id.edt_image);
        btnAddEvent = findViewById(R.id.btn_add);
    }
}