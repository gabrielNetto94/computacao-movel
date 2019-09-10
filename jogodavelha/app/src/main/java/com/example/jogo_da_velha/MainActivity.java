package com.example.aulaciclo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int x = 0;

    EditText editText;
    @Override
    protected void onCreate(Bundle estadoSalvo) {
        super.onCreate(estadoSalvo);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        //tem alguma coisa salva no estado da aplicação?
        if(estadoSalvo != null){
            x = estadoSalvo.getInt("xis");
            Toast.makeText(this, "estado recuperado de x: "+x, Toast.LENGTH_LONG).show();
        }
        Toast.makeText(this, "onCreate executado: "+x, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSaveInstanceState(Bundle estadoASerSalvo) {
        // Salva o estado atual da variável x
        estadoASerSalvo.putInt("xis", x);
        super.onSaveInstanceState(estadoASerSalvo);
        Toast.makeText(this, "onSaveInstanceState executado: "+x, Toast.LENGTH_LONG).show();
    }

    public void trocaClick(View v){
        x = Integer.parseInt(editText.getText().toString());
    }
    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(this, "onStart executado: "+x, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(this, "onResume executado: "+x, Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onPause(){
        super.onPause();
        Toast.makeText(this, "onPause executado: "+x, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop(){
        super.onStop();
        Toast.makeText(this, "onStop executado: "+x, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Toast.makeText(this, "onRestart executado: "+x, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Toast.makeText(this, "onDestroy executado: "+x, Toast.LENGTH_LONG).show();
    }

}
