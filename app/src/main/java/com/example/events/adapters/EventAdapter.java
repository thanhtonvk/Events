package com.example.events.adapters;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.events.FindPlaceActivity;
import com.example.events.MapsActivity;
import com.example.events.R;
import com.example.events.models.Event;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {
    private List<Event> eventList;
    private Context context;

    public EventAdapter(List<Event> eventList, Context context) {
        this.eventList = eventList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Event event = eventList.get(position);
        holder.txtName.setText(event.getName());
        holder.txtDate.setText(event.getTime());
        Glide.with(context)
                .load(event.getImage())
                .centerCrop()
                .into(holder.img);
        holder.more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogMoreOptions();
            }
        });
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    private void showDialogMoreOptions() {
        Dialog dialog = new Dialog(context);
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
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_location);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.findViewById(R.id.btn_findlocation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                context.startActivity(new Intent(context, FindPlaceActivity.class));
            }
        });

        dialog.findViewById(R.id.btn_map).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                context.startActivity(new Intent(context, MapsActivity.class));
            }
        });

        dialog.show();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtDate;
        ImageView img;
        ImageView schedules, tasks, guest, more;

        public ViewHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txt_name);
            txtDate = itemView.findViewById(R.id.txt_time);
            img = itemView.findViewById(R.id.img);
            schedules = itemView.findViewById(R.id.schedules);
            tasks = itemView.findViewById(R.id.tasks);
            guest = itemView.findViewById(R.id.guest);
            more = itemView.findViewById(R.id.more);
        }
    }
}
