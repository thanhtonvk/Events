package com.example.events.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.events.BookingActivity;
import com.example.events.FindPlaceDetailsListActivity;
import com.example.events.PlaceDetailsActivity;
import com.example.events.R;
import com.example.events.models.Place;

import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder> {
    private Context context;
    private List<Place> placeList;
    public static Place getPlace;

    public PlaceAdapter(Context context, List<Place> placeList) {
        this.context = context;
        this.placeList = placeList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_place, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Place place = placeList.get(position);
        holder.txtName.setText(place.getName());
        holder.txtPrice.setText(String.valueOf(place.getMinCost()) + " - " + String.valueOf(place.getMaxCost()) + "đ");
        Glide.with(context)
                .load(place.getImage())
                .centerCrop()
                .into(holder.img);
        holder.btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPlace = place;
                context.startActivity(new Intent(context, BookingActivity.class));
            }
        });
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPlace = place;
                context.startActivity(new Intent(context, PlaceDetailsActivity.class));

            }
        });


    }

    @Override
    public int getItemCount() {
        return placeList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtPrice;
        ImageView img;
        Button btnBook;

        public ViewHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            img = itemView.findViewById(R.id.img);
            btnBook = itemView.findViewById(R.id.btnBook);
        }
    }
}
