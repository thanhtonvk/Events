package com.example.events;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.events.models.Booking;

import java.util.Random;

import static com.example.events.adapters.PlaceAdapter.getPlace;

public class BookingActivity extends AppCompatActivity {

    EditText edtFullName, edtEmail, edtPhoneNumber, edtQuantity, edtTime, edtCalendar;
    TextView txtCost;
    Random random = new Random();
    public static Booking booking;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        init();
        txtCost.setText(getPlace.getMinCost() + "đ");
        findViewById(R.id.btnContinue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                (String id, String fullName, String email, String phoneNumber, int quantity, String time, String calendar, int cost, String place, String discount, String payment
                booking = new Booking(String.valueOf(random.nextInt()
                ), edtFullName.getText().toString(), edtEmail.getText().toString(), edtPhoneNumber.getText().toString(), Integer.parseInt(edtQuantity.getText().toString().trim()), edtTime.getText().toString(), edtCalendar.getText().toString(), getPlace.getMinCost(), getPlace.getName());

                startActivity(new Intent(getApplicationContext(), ConfirmActivity.class));
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
        edtFullName = findViewById(R.id.edtFullName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPhoneNumber = findViewById(R.id.edtPhoneNumber);
        edtQuantity = findViewById(R.id.edtQuantity);
        edtTime = findViewById(R.id.edtTime);
        edtCalendar = findViewById(R.id.edtCalendar);
        txtCost = findViewById(R.id.txtCost);
    }
}