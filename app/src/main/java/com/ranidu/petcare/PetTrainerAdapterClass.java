package com.ranidu.petcare;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class PetTrainerAdapterClass extends RecyclerView.Adapter<PetTrainerAdapterClass.PetTrainerListViewHolder> {
    Context context;
    List<PetTrainerModalClass> ptmData;
    private PetTrainerListViewHolder.RecycleViewClickListener clickListener;
    public PetTrainerAdapterClass(Context context, List<PetTrainerModalClass> ptmData) {
        this.context = context;
        this.ptmData = ptmData;
    }

    @NonNull
    @Override
    public PetTrainerListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout;
        layout = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        return new PetTrainerListViewHolder(layout, context);
    }

    @Override
    public void onBindViewHolder(@NonNull PetTrainerListViewHolder holder, int position) {
        String name = ptmData.get(position).getName().toString();
        String price = ptmData.get(position).getPrice();
        Integer photo = ptmData.get(position).getPhoto();

        holder.tv_pet_trainer_name.setText(name);
        holder.tv_pet_trainer_price.setText(price);
        holder.iv_pet_trainer_photo.setImageResource(photo);
    }

    @Override
    public int getItemCount() {
        return ptmData.size();
    }

    public static class PetTrainerListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tv_pet_trainer_name, tv_pet_trainer_price;
        ImageView iv_pet_trainer_photo;
        public PetTrainerListViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            tv_pet_trainer_name = itemView.findViewById(R.id.tv_pet_trainer_name);
            tv_pet_trainer_price = itemView.findViewById(R.id.tv_pet_trainer_price);
            iv_pet_trainer_photo = itemView.findViewById(R.id.iv_pet_trainer_photo);
        }

        @Override
        public void onClick(View v) {

        }

        public interface RecycleViewClickListener {
        }
    }
}
