package com.ranidu.petcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class PetTrainerActivity extends AppCompatActivity {
    PetTrainerAdapterClass petTrainerAdapterClass;
    ArrayList<PetTrainerModalClass> ptmData;
    RecyclerView rv_pet_trainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_trainer);

        rv_pet_trainer = findViewById(R.id.rv_pet_trainer);
        getData();
        setPetTrainerDataAdapter();
    }

    private void setPetTrainerDataAdapter() {
        petTrainerAdapterClass = new PetTrainerAdapterClass(PetTrainerActivity.this, ptmData);
        rv_pet_trainer.setAdapter(petTrainerAdapterClass);
        rv_pet_trainer.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getData() {
        ptmData = new ArrayList<>();
        ptmData.add(new PetTrainerModalClass(R.drawable.t1, "$100", "Steven C. Harms"));
        ptmData.add(new PetTrainerModalClass(R.drawable.t2, "$95", "Brian C. Chaney"));
        ptmData.add(new PetTrainerModalClass(R.drawable.t3, "$85", "Robert B. Desmond"));
        ptmData.add(new PetTrainerModalClass(R.drawable.t4, "$75", "Michelle B. Romero"));
        ptmData.add(new PetTrainerModalClass(R.drawable.t5, "$92", "Theodore K. Broom"));
        ptmData.add(new PetTrainerModalClass(R.drawable.t6, "$80", "Anna A. Dalton"));
    }
}