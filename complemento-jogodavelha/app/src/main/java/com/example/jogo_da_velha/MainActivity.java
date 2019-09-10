package com.example.jogo_da_velha;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity<list> extends AppCompatActivity {

    //buttons jogo da velha
    Button button1,button2,button3,button4,button5,button6,button7,button8,button9;
    Button startGame,restart;

    //turn player
    TextView viewTurnPlayer,winStatus;

    //radio button game mode
    RadioButton playerVsPlayer, playerVsPc;

    int controlPlayers = 0 ;//teste!!!

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //hide name of app
        getSupportActionBar().hide();

        //choose game mode
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

        if(savedInstanceState != null){
            Button getButton;
            usedButtons = savedInstanceState.getParcelableArrayList("usedButtons");
            chooseGameMode = savedInstanceState.getInt("chooseGameMode");
            controlPlayers = savedInstanceState.getInt("controlPlayers");
            System.out.println("controlPlayers atrib -> "+controlPlayers);
            if(usedButtons != null){
                for (int i = 0; i < usedButtons.size(); i++){
                    //get string
                    String stringToSplit = (String) usedButtons.get(i);
                    String[] stringSplited = stringToSplit.split("/");

                    int resId = getResources().getIdentifier("button" +Integer.parseInt(stringSplited[1]) , "id", getPackageName());
                    getButton = (Button) findViewById(resId);
                    getButton.setText( stringSplited[0]);
                }
            }
        }
    }

    ArrayList usedButtons = new ArrayList();
    int chooseGameMode;
    //int controlPlayers = 0 ;



    @Override
    public void onSaveInstanceState(Bundle stateToSave) {
        stateToSave.putParcelableArrayList("usedButtons",usedButtons);
        stateToSave.putInt("chooseGameMode",chooseGameMode);
        stateToSave.putInt("controlPlayer",controlPlayers);
        super.onSaveInstanceState(stateToSave);
    }

    //choose game mode
    public void onRadioButtonClicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.playerVsPlayer:
                if (checked)
                    chooseGameMode = 1;
                break;
            case R.id.playerVsPc:
                if (checked)
                    chooseGameMode = 2;
                break;
        }
    }

    public void playerMove(Button btn, int indexButton){

        if(controlPlayers % 2 == 0){
            btn.setText("X");
            testWinner("X",1);
            viewTurnPlayer.setText("Vez do jogador 2");
            usedButtons.add("X/"+indexButton);//after player execute the move
        }
        if(controlPlayers % 2 == 1 && chooseGameMode == 1) {
            btn.setText("O");
            testWinner("O", 2);
            viewTurnPlayer.setText("Vez do jogador 1");
            usedButtons.add("O/"+indexButton);//after player execute the move
        }
        btn.setClickable(false);
        controlPlayers++;
    }

    public void playComputer(int indexButton){

        boolean flag = false;
        Random r = new Random();
        Button getButton;
        if(controlPlayers >= 9){
            Toast.makeText(getApplicationContext(), "EMPATE!", Toast.LENGTH_SHORT).show();
            changeStateButtons(false);
            restart.setClickable(true);
            restart.setVisibility(View.VISIBLE);
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

                    usedButtons.add("O/"+indexButton);//after player execute the move
                }

            }
        }
    }

    public void clickButton(View view) {
        System.out.println("controlPlayers button -> "+controlPlayers+" @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        switch(view.getId()) {
            case R.id.button1:
                playerMove(button1,1);
                if(chooseGameMode == 2){
                    playComputer(1);
                }
                break;
            case R.id.button2:
                playerMove(button2,2);
                if(chooseGameMode == 2){
                    playComputer(2);
                }
                break;
            case R.id.button3:
                playerMove(button3,3);
                if(chooseGameMode == 2){
                    playComputer(3);
                }
                break;
            case R.id.button4:
                playerMove(button4,4);
                if(chooseGameMode == 2){
                    playComputer(4);
                }
                break;
            case R.id.button5:
                playerMove(button5,5);
                if(chooseGameMode == 2){
                    playComputer(5);
                }
                break;
            case R.id.button6:
                playerMove(button6,6);
                if(chooseGameMode == 2){
                    playComputer(6);
                }
                break;
            case R.id.button7:
                playerMove(button7,7);
                if(chooseGameMode == 2){
                    playComputer(7);
                }
                break;
            case R.id.button8:
                playerMove(button8,8);
                if(chooseGameMode == 2){
                    playComputer(8);
                }
                break;
            case R.id.button9:
                playerMove(button9,9);
                if(chooseGameMode == 2){
                    playComputer(9);
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

        chooseGameMode = 1;
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
            if(chooseGameMode == 1){
                viewTurnPlayer.setText("Vez do jogador 1");
                viewTurnPlayer.setVisibility(View.VISIBLE);
            }else if (chooseGameMode == 2){
                viewTurnPlayer.setText("");
                viewTurnPlayer.setVisibility(View.INVISIBLE);
            }
        }
    }

}