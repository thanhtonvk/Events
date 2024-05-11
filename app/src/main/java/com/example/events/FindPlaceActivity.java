package com.example.events;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

class FindPlace {
    public String area;
    public String eventype;
    public String quantity;
    public String convenient;
    public String requirements;
}

public class FindPlaceActivity extends AppCompatActivity {
    EditText edtArea, edtEventype, edtQuantity, edtConvenient, edtRequirements;
    Button btnFind;
    public static FindPlace findPlace = new FindPlace();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_place);

        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        init();
        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findPlace.area = edtArea.getText().toString();
                findPlace.eventype = edtEventype.getText().toString();
                findPlace.quantity = edtQuantity.getText().toString();
                findPlace.convenient = edtConvenient.getText().toString();
                findPlace.requirements = edtRequirements.getText().toString();
                startActivity(new Intent(FindPlaceActivity.this, FindPlaceDetailsListActivity.class));
            }
        });
    }

    private void init() {
        edtArea = findViewById(R.id.edtArea);
        edtConvenient = findViewById(R.id.edtConvenient);
        edtEventype = findViewById(R.id.edtEventType);
        edtQuantity = findViewById(R.id.edtQuantity);
        edtRequirements = findViewById(R.id.edtRequirements);
        btnFind = findViewById(R.id.btn_tim);
    }
}