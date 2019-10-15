package com.example.telas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    String[] status = new String[] {"Solteiro(a)","Casado(a)","Separado(a)","Viúvo(a)"};
    String[] typeDrink = new String[] {"Vinho","Cerveja","Refrigerante"};

    Spinner spinnerMaritalStatus, spinnerTypeDrink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        //spinners
        spinnerMaritalStatus = findViewById(R.id.spinnerMaritalStatus);
        spinnerTypeDrink = findViewById(R.id.spinnerTypeDrink);

        ArrayAdapter<String> adapterMaritalStatus = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, status);
        adapterMaritalStatus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMaritalStatus.setAdapter(adapterMaritalStatus);

        ArrayAdapter<String> adapterTypeDrink = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, typeDrink);
        adapterTypeDrink.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTypeDrink.setAdapter(adapterTypeDrink);
    }
    public void login(){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        //Intent it = new Intent(this, Teste.class);
        //startActivity(it);
    }
}
