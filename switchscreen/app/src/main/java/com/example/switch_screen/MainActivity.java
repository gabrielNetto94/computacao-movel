package com.example.switch_screen;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String[] status = new String[] {"Solteiro(a)","Casado(a)","Separado(a)","Viúvo(a)"};
    String[] typeDrink = new String[] {"Cerveja","Refrigerante","Vinho"};

    Spinner spinnerMaritalStatus, spinnerTypeDrink;
    Button login;
    RadioButton female;
    RadioButton male;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        Intent it = getIntent();

        int valueMessage = it.getIntExtra("message",9);

        if(valueMessage == 1){
            Toast.makeText(this, valueMessage, Toast.LENGTH_SHORT).show();
        }

        //radioButtons
        female = findViewById(R.id.female);
        male = findViewById(R.id.male);

        //button
        login = findViewById(R.id.idLogin);

        //spinners
        spinnerMaritalStatus = findViewById(R.id.spinnerMaritalStatus);
        spinnerTypeDrink = findViewById(R.id.spinnerTypeDrink);

        //fill spinner
        ArrayAdapter<String> adapterMaritalStatus = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, status);
        adapterMaritalStatus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMaritalStatus.setAdapter(adapterMaritalStatus);

        //fill spinner
        ArrayAdapter<String> adapterTypeDrink = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, typeDrink);
        adapterTypeDrink.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTypeDrink.setAdapter(adapterTypeDrink);

    }

    public void login(View v) {
        Intent intent = new Intent(this, Test.class);
        EditText name  = findViewById(R.id.inputName);

        String genderStr = null;

        if(female.isChecked()){
            genderStr = (String) female.getText();
        }
        if(male.isChecked()){
            genderStr = (String) male.getText();
        }

        if(genderStr != null && name.getText().length() != 0){
            intent.putExtra("maritalStatus",spinnerMaritalStatus.getSelectedItem().toString());
            intent.putExtra("typeDrink",spinnerTypeDrink.getSelectedItem().toString());
            intent.putExtra("gender",genderStr);
            intent.putExtra("name",name.getText().toString());
            startActivity(intent);
        }else {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
        }

    }

}
