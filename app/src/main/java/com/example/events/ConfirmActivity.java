package com.example.events;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.events.BookingActivity.booking;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConfirmActivity extends AppCompatActivity {

    TextView txtFullName, txtEmail, txtPhoneNumber, txtTime, txtQuantity, txtCost, txtName;
    EditText edtDiscount, edtPaymentMethod;
    Button btnPay;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Booking");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        findViewById(R.id.btnPay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                booking.setDiscount(edtDiscount.getText().toString());
                booking.setPayment(edtPaymentMethod.getText().toString());
                myRef.child(booking.getId()).setValue(booking).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(getApplicationContext(), SuccessActivity.class));
                        } else {
                            Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

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

    @SuppressLint("SetTextI18n")
    private void setDetails() {
        txtFullName.setText(booking.getFullName());
        txtEmail.setText(booking.getEmail());
        txtPhoneNumber.setText(booking.getPhoneNumber());
        txtTime.setText(booking.getTime() + " " + booking.getCalendar());
        txtQuantity.setText(booking.getQuantity() + " persons");
        txtCost.setText(booking.getCost() + " vnd");
        txtName.setText(booking.getPlace());
    }

    private void init() {
        txtFullName = findViewById(R.id.txtFullName);
        txtEmail = findViewById(R.id.txtEmail);
        txtPhoneNumber = findViewById(R.id.txtPhoneNumber);
        txtTime = findViewById(R.id.txtTime);
        txtQuantity = findViewById(R.id.txtQuantity);
        txtCost = findViewById(R.id.txtCost);
        txtName = findViewById(R.id.txtName);
        edtDiscount = findViewById(R.id.edtDiscount);
        edtPaymentMethod = findViewById(R.id.edtPaymentMethod);
        btnPay = findViewById(R.id.btnPay);
    }
}