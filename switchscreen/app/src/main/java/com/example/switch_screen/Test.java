package com.example.switch_screen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Test extends AppCompatActivity {

    TextView Vname, Vgender, VmaritalStatus, VtypeDrink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        getSupportActionBar().hide();

        Intent it = getIntent();

        String name = it.getStringExtra("name");
        String gender = it.getStringExtra("gender");
        String maritalStatus = it.getStringExtra("maritalStatus");
        String typeDrink = it.getStringExtra( "typeDrink");

        Vname = findViewById(R.id.viewName);
        Vgender = findViewById(R.id.viewGender);
        VmaritalStatus = findViewById(R.id.viewMaritalSatus);
        VtypeDrink = findViewById(R.id.viewTypeDrink);


        if (maritalStatus.equals("Casado(a)")){
            Toast.makeText(this, "A aplicação só permite pessoas solteiras.", Toast.LENGTH_SHORT).show();
            finish();
        }

        Vname.setText("Nome: "+name);
        Vgender.setText("Gênero: "+gender);
        VmaritalStatus.setText("Status relacionamento: "+maritalStatus);
        VtypeDrink.setText("Bebida favorita: "+typeDrink);
    }

    public void sendHomeScreen(View v){
        finish();
    }
}
