package com.example.navegacao_entre_telas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

/*
Nome, estado civil, gênero e tipo de bebida preferida (vinho, cerveja ou refrigerante)
*/
public class MainActivity extends AppCompatActivity {

    String[] items = new String[] {"Solteira","Casado","Separado","Viúvo(a)"};
    Spinner spinner;


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        spinner = findViewById(R.id.spinnerEstadoCivil);

        ArrayAdapter<CharSequence> adaptador2 = ArrayAdapter.createFromResource(this, R.array.nationality, android.R.layout.simple_spinner_item);
        adaptador2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adaptador2);
    }

}
