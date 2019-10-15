package com.example.switch_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Test extends AppCompatActivity {

    TextView TVname, TVgender, TVmaritalStatus, TVtypeDrink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);



        getSupportActionBar().hide();

        Intent it = getIntent();

        String name = it.getStringExtra("name");
        String gender = it.getStringExtra("gender");
        String maritalStatus = it.getStringExtra("maritalStatus");
        String typeDrink= it.getStringExtra("typeDrink");

        TVname = findViewById(R.id.viewName);
        TVgender = findViewById(R.id.viewGender);
        TVmaritalStatus = findViewById(R.id.viewMaritalSatus);
        TVtypeDrink = findViewById(R.id.viewTypeDrink);

        TVname.setText("Nome: "+name);
        TVgender.setText("Gênero "+gender);
        TVmaritalStatus.setText("Status relacionamento: "+maritalStatus);
        TVtypeDrink.setText("Bebida favorita: "+typeDrink);

    }




}
