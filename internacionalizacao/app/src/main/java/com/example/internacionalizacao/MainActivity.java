package com.example.internacionalizacao;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.internacionalizacao.R;

public class MainActivity extends AppCompatActivity {

    RadioButton radioRegularSim, radioRegularNao, radioBolsaSim, radioBolsaNao;
    CheckBox checkBD3, checkCM, checkAuto, checkPSW;
    EditText editValorBolsa;
    TextView textResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //radiobuttons
        radioRegularSim = findViewById(R.id.radioRegularSim);
        radioRegularNao = findViewById(R.id.radioRegularNao);
        radioBolsaSim = findViewById(R.id.radioBolsaSim);
        radioBolsaNao = findViewById(R.id.radioBolsaNao);

        //checkboxes
        checkBD3 = findViewById(R.id.checkBD3);
        checkCM = findViewById(R.id.checkCM);
        checkAuto = findViewById(R.id.checkAuto);
        checkPSW = findViewById(R.id.checkPSW);

        //editexts
        editValorBolsa = findViewById(R.id.editValorBolsa);

        //evento que dispara quando o usuario modifica algo no edittext (teoricamente)
        editValorBolsa.setOnKeyListener(new EditText.OnKeyListener() {
            @Override
            //quando o usuario modificar algo no campo da bolsa, manda recalcular o valor final
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                calcular();
                return false;
            }
        });
        //textviews
        textResultado = findViewById(R.id.textResultado);
    }

    public void clickSimBolsa(View v){
        //ao clicar no radio sim, modifica-se a visibilidade do campo de texto
        //onde se digita o valor da bolsa para visivel
        editValorBolsa.setVisibility(View.VISIBLE);
        calcular();//recalcula

    }

    public void clickNaoBolsa(View v){
        //ao clicar no radio nao, modifica-se a visibilidade do campo de texto
        //onde se digita o valor da bolsa para GONE (invisivel e sem ocupar espaço)
        editValorBolsa.setVisibility(View.GONE);
        editValorBolsa.setText("");

        calcular();//recalcula
    }

    public void clickNaoRegular(View v){
        radioBolsaNao.setChecked(true);//marca o radio bolsa não
        radioBolsaSim.setEnabled(false);//desabilita o radio bolsa sim
        editValorBolsa.setVisibility(View.GONE);//esconde o campo de digitar bolsa

        calcular();//recalcula
    }

    public void clickSimRegular(View v){
        radioBolsaSim.setEnabled(true);//habilita o radio bolsa sim

        calcular();//recalcula
    }

    public void calcular(){
        double valorHora = 4.14, qtdHoras = 0, valorFinal = 0;

        //primeiro verifica quais disciplinas estão marcadas
        if(checkBD3.isChecked()){
            qtdHoras+=51;
        }
        if(checkCM.isChecked()){
            qtdHoras+=68;
        }
        if(checkAuto.isChecked()){
            qtdHoras+=34;
        }
        if(checkPSW.isChecked()){
            qtdHoras+=68;
        }
        valorFinal = qtdHoras*valorHora;

        //verifica se tem bolsa
        String strValorBolsa = editValorBolsa.getText().toString();
        //testa se tem algo digitado no desconto
        if(!strValorBolsa.equals("")){
            double valorBolsa = Double.parseDouble(strValorBolsa);
            if(valorBolsa > 100) valorBolsa = 100;
            valorFinal = valorFinal - (valorFinal * valorBolsa/100);
            if(valorFinal < 0 ) valorFinal = 0; //para erros de precisão
        }

        //testa se é aluno regular ou não
        if(radioRegularNao.isChecked()){
            valorFinal = valorFinal * 2;
        }
        textResultado.setText("R$"+valorFinal);
    }
    public void clickCalcular(View v){
        calcular();
    }
}
