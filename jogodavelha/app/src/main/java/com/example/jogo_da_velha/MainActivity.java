package com.example.jogo_da_velha;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //buttons jogo da velha
    Button button1,button2,button3,button4,button5,button6,button7,button8,button9;
    Button startGame,restart;

    //turn player
    TextView viewTurnPlayer,winStatus;

    //radio button game mode
    RadioButton playerVsPlayer, playerVsPc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getSupportActionBar().hide();//hide name of app
        if(savedInstanceState != null){

        }

        //choices game mode
        playerVsPlayer = findViewById(R.id.playerVsPlayer);
        playerVsPc = findViewById(R.id.playerVsPc);

        //turn player
        viewTurnPlayer = findViewById(R.id.turnPlayer);
        //winStatus = findViewById(R.id.winStatus);

        //button start game
        startGame = findViewById(R.id.buttonStart);
        restart = findViewById(R.id.buttonRestart);

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

        //start game with buttons not clickable
        changeStateButtons(false);
        restart.setClickable(false);

    }

    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(this, "onStart executado: ", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(this, "onResume executado: ", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onPause(){
        super.onPause();
        Toast.makeText(this, "onPause executado: ", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop(){
        super.onStop();
        Toast.makeText(this, "onStop executado: ", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Toast.makeText(this, "onRestart executado: ", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Toast.makeText(this, "onDestroy executado: ", Toast.LENGTH_LONG).show();
    }

    int choiceGameMode;
    int controlPlayers = 0 ;

    //choice game mode
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
        if(controlPlayers % 2 == 0){
            btn.setText("X");
            testWinner("X",1);
            viewTurnPlayer.setText("Vez do jogador 2");
        }
        if(controlPlayers % 2 == 1 && choiceGameMode == 1) {
            btn.setText("O");
            testWinner("O", 2);
            viewTurnPlayer.setText("Vez do jogador 1");
        }
    }

    public void playComputer(){

        boolean flag = false;
        Random r = new Random();
        Button getButton;
        if(controlPlayers >= 9){
            Toast.makeText(getApplicationContext(), "EMPATE!", Toast.LENGTH_SHORT).show();
            changeStateButtons(false);
            restart.setClickable(true);
        }else {

        while (!flag){

            int numberButton = r.nextInt(9)+1;
            System.out.println(numberButton);
            int resId = getResources().getIdentifier("button" + numberButton, "id", getPackageName());
            getButton = (Button) findViewById(resId);

                if(getButton.getText().equals("X") || getButton.getText().equals("O")){
                    flag = false;
                }else{
                    flag = true;
                    getButton.setText("O");
                    controlPlayers++;
                    getButton.setClickable(false);
                    testWinner("O", 2);
                }

            }
        }

    }

    public void clickButton(View view) {
        switch(view.getId()) {
            case R.id.button1:
                textButton(button1);
                controlPlayers++;
                button1.setClickable(false);
                if(choiceGameMode == 2){
                    playComputer();
                }
                break;
            case R.id.button2:
                textButton(button2);
                controlPlayers++;
                button2.setClickable(false);
                if(choiceGameMode == 2){
                    playComputer();
                }
                break;
            case R.id.button3:
                textButton(button3);
                controlPlayers++;
                button3.setClickable(false);
                if(choiceGameMode == 2){
                    playComputer();
                }
                break;
            case R.id.button4:
                textButton(button4);
                controlPlayers++;
                button4.setClickable(false);
                if(choiceGameMode == 2){
                    playComputer();
                }
                break;
            case R.id.button5:
                textButton(button5);
                controlPlayers++;
                button5.setClickable(false);
                if(choiceGameMode == 2){
                    playComputer();
                }
                break;
            case R.id.button6:
                textButton(button6);
                controlPlayers++;
                button6.setClickable(false);
                if(choiceGameMode == 2){
                    playComputer();
                }
                break;
            case R.id.button7:
                textButton(button7);
                controlPlayers++;
                button7.setClickable(false);
                if(choiceGameMode == 2){
                    playComputer();
                }
                break;
            case R.id.button8:
                textButton(button8);
                controlPlayers++;
                button8.setClickable(false);
                if(choiceGameMode == 2){
                    playComputer();
                }
                break;
            case R.id.button9:
                textButton(button9);
                controlPlayers++;
                button9.setClickable(false);
                if(choiceGameMode == 2){
                    playComputer();
                }
                break;
        }
    }

    public void changeStateButtons(boolean state){
        button1.setClickable(state);
        button2.setClickable(state);
        button3.setClickable(state);
        button4.setClickable(state);
        button5.setClickable(state);
        button6.setClickable(state);
        button7.setClickable(state);
        button8.setClickable(state);
        button9.setClickable(state);
    }

    public void testWinner (String player, int numberPLayer){

        if(controlPlayers >= 9){
            Toast.makeText(getApplicationContext(), "EMPATE!", Toast.LENGTH_SHORT).show();
            changeStateButtons(false);
            restart.setClickable(true);
            restart.setVisibility(View.VISIBLE);
        }
        if(button1.getText() == player && button2.getText() == player && button3.getText() == player){
            Toast.makeText(getApplicationContext(), "Jogador "+numberPLayer+" VENCEU!", Toast.LENGTH_SHORT).show();
            changeStateButtons(false);
            restart.setClickable(true);
            restart.setVisibility(View.VISIBLE);
        }
        if(button4.getText() == player && button5.getText() == player && button6.getText() == player){
            Toast.makeText(getApplicationContext(), "Jogador "+numberPLayer+" VENCEU!", Toast.LENGTH_SHORT).show();
            changeStateButtons(false);
            restart.setClickable(true);
            restart.setVisibility(View.VISIBLE);
        }
        if(button7.getText() == player && button8.getText() == player && button9.getText() == player){
            Toast.makeText(getApplicationContext(), "Jogador "+numberPLayer+" VENCEU!", Toast.LENGTH_SHORT).show();
            changeStateButtons(false);
            restart.setClickable(true);
            restart.setVisibility(View.VISIBLE);
        }
        if(button1.getText() == player && button5.getText() == player && button9.getText() == player){
            Toast.makeText(getApplicationContext(), "Jogador "+numberPLayer+" VENCEU!", Toast.LENGTH_SHORT).show();
            changeStateButtons(false);
            restart.setClickable(true);
            restart.setVisibility(View.VISIBLE);
        }
        if(button3.getText() == player && button5.getText() == player && button7.getText() == player){
            Toast.makeText(getApplicationContext(), "Jogador "+numberPLayer+" VENCEU!", Toast.LENGTH_SHORT).show();
            changeStateButtons(false);
            restart.setClickable(true);
            restart.setVisibility(View.VISIBLE);
        }
        if(button1.getText() == player && button4.getText() == player && button7.getText() == player){
            Toast.makeText(getApplicationContext(), "Jogador "+numberPLayer+" VENCEU!", Toast.LENGTH_SHORT).show();
            changeStateButtons(false);
            restart.setClickable(true);
            restart.setVisibility(View.VISIBLE);
        }
        if(button2.getText() == player && button5.getText() == player && button8.getText() == player){
            Toast.makeText(getApplicationContext(), "Jogador "+numberPLayer+" VENCEU!", Toast.LENGTH_SHORT).show();
            changeStateButtons(false);
            restart.setClickable(true);
            restart.setVisibility(View.VISIBLE);
        }
        if(button3.getText() == player && button6.getText() == player && button9.getText() == player){
            Toast.makeText(getApplicationContext(), "Jogador "+numberPLayer+" VENCEU!", Toast.LENGTH_SHORT).show();
            changeStateButtons(false);
            restart.setClickable(true);
            restart.setVisibility(View.VISIBLE);
        }

    }

    public void restart(View v){
        //set all buttons clickable
        changeStateButtons(false);
        startGame.setClickable(true);
        startGame.setVisibility(View.VISIBLE);

        restart.setClickable(false);
        restart.setVisibility(View.INVISIBLE);

        button1.setText("");
        button2.setText("");
        button3.setText("");
        button4.setText("");
        button5.setText("");
        button6.setText("");
        button7.setText("");
        button8.setText("");
        button9.setText("");

        playerVsPlayer.setChecked(false);
        playerVsPc.setChecked(false);

        playerVsPlayer.setEnabled(true);
        playerVsPc.setEnabled(true);

        viewTurnPlayer.setText("Vez do jogador 1");

        controlPlayers = 0;

        choiceGameMode = 1;
    }

    public void startGame(View view){
        //Test if game mode not selected
        if(!playerVsPc.isChecked() && !playerVsPlayer.isChecked()){
            Toast.makeText(getApplicationContext(), "Selecione um modo de jogo.", Toast.LENGTH_SHORT).show();
        }else{
            startGame.setClickable(false);
            startGame.setVisibility(View.INVISIBLE);
            playerVsPlayer.setEnabled(false);
            playerVsPc.setEnabled(false);

            changeStateButtons(true);
            if(choiceGameMode == 1){
                viewTurnPlayer.setText("Vez do jogador 1");
                viewTurnPlayer.setVisibility(View.VISIBLE);
            }else if (choiceGameMode == 2){
                viewTurnPlayer.setText("");
                viewTurnPlayer.setVisibility(View.INVISIBLE);
            }
        }
    }

}