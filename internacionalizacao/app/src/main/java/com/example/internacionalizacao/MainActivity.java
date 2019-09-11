package com.example.internacionalizacao;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String[] items = new String[] {"Brazilian","American","Spanish"};
    Spinner spinner;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        /*
        spinner = findViewById(R.id.spinnerNationality);
        //crio um adaptador com itens já pré-definidos
        ArrayAdapter<String> adaptador3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
        adaptador3. setDropDownViewResource(android.R.layout.simple_spinner_item);
        //defino o adaptador do spinner
        spinner.setAdapter(adaptador3);
        */

        //crio um adaptador com itens já pré-definidos
        spinner = findViewById(R.id.spinnerNationality);
        ArrayAdapter<CharSequence> adaptador2 = ArrayAdapter.createFromResource(this, R.array.nationality, android.R.layout.simple_spinner_item);
        adaptador2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        //defino o adaptador do spinner
        spinner.setAdapter(adaptador2);
    }




}
