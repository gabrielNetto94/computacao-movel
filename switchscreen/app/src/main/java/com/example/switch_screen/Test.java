package com.example.switch_screen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Test extends AppCompatActivity {

    TextView Vname, Vgender, VmaritalStatus, VtypeDrink, Vphone;
    ImageView drinkImage;

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
        Vphone = findViewById(R.id.viewPhone);
        drinkImage = findViewById(R.id.viewImage);


        if (maritalStatus.equals("Casado(a)")){
            Toast.makeText(this, "A aplicação só permite pessoas solteiras.", Toast.LENGTH_SHORT).show();
            finish();
        }

        if(gender.equals("Masculino")){
            Vphone.setText("Telefone da mulher: "+createPhoneNumber());
        }
        if(gender.equals("Feminino")){
            Vphone.setText("Telefone do homem: "+createPhoneNumber());
        }

        if(typeDrink.equals("Refrigerante")){
            drinkImage.setImageResource(R.drawable.refrigerante);
        }
        if(typeDrink.equals("Cerveja")){
            drinkImage.setImageResource(R.drawable.cerveja);
        }
        if(typeDrink.equals("Vinho")){
            drinkImage.setImageResource(R.drawable.vinho);
        }


        Vname.setText("Nome: "+name);
        Vgender.setText("Gênero: "+gender);
        VmaritalStatus.setText("Status relacionamento: "+maritalStatus);
        VtypeDrink.setText("Bebida favorita: "+typeDrink);
    }

    public void sendHomeScreen(View v){
        finish();
    }

    public StringBuilder createPhoneNumber(){

        Random random = new Random();
        StringBuilder phone = new StringBuilder();

        phone.append(9);
        for (int i = 0; i < 8; i++) {
            phone.append(random.nextInt(9) % 9);
        }

        return phone;
    }
}
