package com.example.jogo_da_velha;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //buttons jogo da velha
    Button button1,button2,button3,button4,button5,button6,button7,button8,button9;

    //turn player
    TextView viewTurnPlayer,winStatus;

    RadioButton playerVsPlayer, playerVsPc;

    RadioGroup gameMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();//hide name of app

        //choices game mode
        playerVsPlayer = findViewById(R.id.playerVsPlayer);
        playerVsPc = findViewById(R.id.playerVsPc);

        //turn player
        viewTurnPlayer = findViewById(R.id.turnPlayer);
        winStatus = findViewById(R.id.winStatus);

        //buttons jogo da velha
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        button5 = (Button)findViewById(R.id.button5);
        button6 = (Button)findViewById(R.id.button6);
        button7 = (Button)findViewById(R.id.button7);
        button8 = (Button)findViewById(R.id.button8);
        button9 = (Button)findViewById(R.id.button9);


    }

    int choiceGameMode;
    int controlPlayers = 0 ;

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.playerVsPlayer:
                if (checked)
                    choiceGameMode = 1;
                break;
            case R.id.playerVsPc:
                if (checked)
                    choiceGameMode = 2;
                break;
        }
    }

    //set X or O
    public void textButton(Button btn){
        if(controlPlayers % 2 == 1){
            btn.setText("O");
            testWinner("O");
        }
        if(controlPlayers % 2 == 0){
            btn.setText("X");
            testWinner("X");
        }
    }

    public void clickButton(View view) {
        switch(view.getId()) {
            case R.id.button1:
                textButton(button1);
                controlPlayers++;
                button1.setClickable(false);
                break;
            case R.id.button2:
                textButton(button2);
                controlPlayers++;
                button1.setClickable(false);
                break;
            case R.id.button3:
                textButton(button3);
                controlPlayers++;
                button1.setClickable(false);
                break;
            case R.id.button4:
                textButton(button4);
                controlPlayers++;
                button1.setClickable(false);
                break;
            case R.id.button5:
                textButton(button5);
                controlPlayers++;
                button1.setClickable(false);
                break;
            case R.id.button6:
                textButton(button6);
                controlPlayers++;
                button1.setClickable(false);
                break;
            case R.id.button7:
                textButton(button7);
                controlPlayers++;
                button1.setClickable(false);
                break;
            case R.id.button8:
                textButton(button8);
                controlPlayers++;
                button1.setClickable(false);
                break;
            case R.id.button9:
                textButton(button9);
                controlPlayers++;
                button1.setClickable(false);
                break;
        }
    }

    public void startGame(View view){
        //Test if game mode not selected
        if(!playerVsPc.isChecked() && !playerVsPlayer.isChecked()){
            Toast.makeText(getApplicationContext(), "Selecione um modo de jogo.", Toast.LENGTH_SHORT).show();
        }else{
            playerVsPlayer.setEnabled(false);
            playerVsPc.setEnabled(false);
            if(choiceGameMode == 1){

            }else if (choiceGameMode == 2){

            }
        }
    }

    public void testWinner (String player){

        if(button1.getText() == player && button2.getText() == player && button3.getText() == player){
            Toast.makeText(getApplicationContext(), "Jogador "+player+" VENCEU!", Toast.LENGTH_SHORT).show();
        }
        if(button4.getText() == player && button5.getText() == player && button6.getText() == player){
            Toast.makeText(getApplicationContext(), "Jogador "+player+" VENCEU!", Toast.LENGTH_SHORT).show();
        }
        if(button7.getText() == player && button8.getText() == player && button9.getText() == player){
            Toast.makeText(getApplicationContext(), "Jogador "+player+" VENCEU!", Toast.LENGTH_SHORT).show();
        }
        if(button1.getText() == player && button5.getText() == player && button9.getText() == player){
            Toast.makeText(getApplicationContext(), "Jogador "+player+" VENCEU!", Toast.LENGTH_SHORT).show();
        }
        if(button3.getText() == player && button5.getText() == player && button7.getText() == player){
            Toast.makeText(getApplicationContext(), "Jogador "+player+" VENCEU!", Toast.LENGTH_SHORT).show();
        }
        if(button1.getText() == player && button4.getText() == player && button7.getText() == player){
            Toast.makeText(getApplicationContext(), "Jogador "+player+" VENCEU!", Toast.LENGTH_SHORT).show();
        }
        if(button2.getText() == player && button5.getText() == player && button8.getText() == player){
            Toast.makeText(getApplicationContext(), "Jogador "+player+" VENCEU!", Toast.LENGTH_SHORT).show();
        }
        if(button3.getText() == player && button6.getText() == player && button9.getText() == player){
            Toast.makeText(getApplicationContext(), "Jogador "+player+" VENCEU!", Toast.LENGTH_SHORT).show();
        }
    }
}

