package com.example.events;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.events.models.Place;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Places");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addPlaces();
        startActivity(new Intent(getApplicationContext(), HomePageActivity.class));
    }

    private void addPlaces() {
        List<Place> places = new ArrayList<>();
//        String id, String name, int minCost, int maxCost, String eventType, int quantity, String convenient, String other, String image, String area
        places.add(new Place(
                "1",
                "Trung tam hoi nghi quoc gia",
                15000, 20000,
                "dam cuoi, dam ma", 1000,
                "cach xa 100km", "co cho do xe",
                "https://cdnmedia.baotintuc.vn/Upload/Td3qmSNSjM5mhekL9vM2Q/files/2020/11/360-TrungtamHoinghiQuocgia/360-TTHNQG-12.jpg",
                "Ha Noi"
        ));
        myRef.setValue(places).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
//                if (task.isSuccessful()) {
//                    Toast.makeText(getApplicationContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
//                }
            }
        });
    }
}