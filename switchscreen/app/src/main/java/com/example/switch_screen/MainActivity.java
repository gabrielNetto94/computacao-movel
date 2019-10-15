package com.example.switch_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] status = new String[] {"Solteiro(a)","Casado(a)","Separado(a)","Viúvo(a)"};
    String[] typeDrink = new String[] {"Vinho","Cerveja","Refrigerante"};

    Spinner spinnerMaritalStatus, spinnerTypeDrink;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getSupportActionBar().hide();

        //button
        login = findViewById(R.id.idLogin);

        //spinners
        spinnerMaritalStatus = findViewById(R.id.spinnerMaritalStatus);
        spinnerTypeDrink = findViewById(R.id.spinnerTypeDrink);

        ArrayAdapter<String> adapterMaritalStatus = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, status);
        adapterMaritalStatus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMaritalStatus.setAdapter(adapterMaritalStatus);

        ArrayAdapter<String> adapterTypeDrink = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, typeDrink);
        adapterTypeDrink.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTypeDrink.setAdapter(adapterTypeDrink);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }



    public void login() {
        Intent intent = new Intent(this, Test.class);

        RadioGroup RadioGender = findViewById(R.id.gender);
        RadioButton gender =  findViewById(RadioGender.getCheckedRadioButtonId());
        EditText name  = findViewById(R.id.inputName);

        //Toast.makeText(this, gender.getText(), Toast.LENGTH_SHORT).show();

        intent.putExtra("gender",gender.getText());
        intent.putExtra("name",name.getText().toString());

        //startActivity(intent);
    }

}
