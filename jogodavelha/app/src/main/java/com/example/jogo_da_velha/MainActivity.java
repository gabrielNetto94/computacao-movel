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
    TextView turnPlayer,winStatus;

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
        turnPlayer = findViewById(R.id.turnPlayer);
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

    int choiceGameMode = 0;

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.playerVsPlayer:
                if (checked)
                    //turnPlayer.setText("Player vs Player");
                    choiceGameMode = 1;
                break;
            case R.id.playerVsPc:
                if (checked)
                    //turnPlayer.setText("Player vs PC");
                    choiceGameMode = 2;
                break;
        }
    }

    public void startGame(View view){
        //test if game mode is selected
        if(!playerVsPc.isChecked() && !playerVsPlayer.isChecked()){

        }

        playerVsPlayer.setEnabled(false);
        playerVsPc.setEnabled(false);
        if(choiceGameMode == 1){

        }else if (choiceGameMode == 2){

        }
    }


    public void textButton(Button btn){
        if(btn.getText().equals("")){
            btn.setText("");
        }
    }
    //BEGIN TEST
    public void clickButton(View view) {

        switch(view.getId()) {
            case R.id.button1:
                textButton(button1);
                Toast.makeText(getApplicationContext(), "Button 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                Toast.makeText(getApplicationContext(), "Button 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button3:
                Toast.makeText(getApplicationContext(), "Button 3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button4:
                Toast.makeText(getApplicationContext(), "Button 4", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button5:
                Toast.makeText(getApplicationContext(), "Button 5", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button6:
                Toast.makeText(getApplicationContext(), "Button 6", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button7:
                Toast.makeText(getApplicationContext(), "Button 7", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button8:
                Toast.makeText(getApplicationContext(), "Button 8", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button9:
                Toast.makeText(getApplicationContext(), "Button 9", Toast.LENGTH_SHORT).show();
                break;
        }
    }
    //END TEST
}

