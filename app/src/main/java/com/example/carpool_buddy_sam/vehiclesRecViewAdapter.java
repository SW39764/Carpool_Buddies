package com.example.carpool_buddy_sam;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carpool_buddy_sam.Vehicles.Vehicle;

import java.util.ArrayList;

public class vehiclesRecViewAdapter extends RecyclerView.Adapter<vehicleRecyclerViewViewHolder>{

//    ArrayList<Vehicle> vehicles;
    ArrayList<String> type;
    ArrayList<String> model;
    ArrayList<Integer> capacity;

    private OnNoteListener mOnNoteListener;

    public vehiclesRecViewAdapter(ArrayList<String> model, ArrayList<String> type, ArrayList<Integer> capacity, OnNoteListener monNoteListener) {
        this.model = model;
        this.type = type;
        this.capacity = capacity;
        this.mOnNoteListener = monNoteListener;
    }





    @NonNull
    @Override
    public vehicleRecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vehicle_row_view, parent, false);

        vehicleRecyclerViewViewHolder viewHolder = new vehicleRecyclerViewViewHolder(view, mOnNoteListener);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull vehicleRecyclerViewViewHolder holder, int position) {
        holder.vehicleModel.setText("Model : " + model.get(position).toString());
        holder.vehicleType.setText("Type : " + type.get(position).toString());
        holder.vehicleCapacity.setText("Capacity : " + capacity.get(position).toString());

    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public interface OnNoteListener {
        void onNoteClick(int position);
    }

    public interface OnVehicleListener {
        void onVehicleClick(int position);

    }

}
