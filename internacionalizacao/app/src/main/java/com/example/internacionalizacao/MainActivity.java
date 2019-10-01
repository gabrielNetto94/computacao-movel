package com.example.internacionalizacao;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String[] items = new String[] {"Brazilian","American","Spanish"};
    Spinner spinner;
    ImageView fieldImageGender;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        spinner = findViewById(R.id.spinnerNationality);
        fieldImageGender = (ImageView)findViewById(R.id.fieldImage);

        ArrayAdapter<CharSequence> adaptador2 = ArrayAdapter.createFromResource(this, R.array.nationality, android.R.layout.simple_spinner_item);
        adaptador2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adaptador2);
    }

    public void changeImageFemale(View v){
        fieldImageGender.setImageResource(R.drawable.femaleicon);
    }
    public void changeImageMale(View v){
        fieldImageGender.setImageResource(R.drawable.maleicon);
    }





}
