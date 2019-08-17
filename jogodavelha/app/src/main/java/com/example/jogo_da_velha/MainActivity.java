package com.example.jogo_da_velha;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //buttons jogo da velha
    Button button1,button2,button3,button4,button5,button6,button7,button8,button9;

    //turn player
    TextView turnPlayer,winStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();//hide name of app

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

    public void startGame(View view){
        
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButton1:
                if (checked)
                    turnPlayer.setText("Player vs Player");
                    break;
            case R.id.radioButton2:
                if (checked)
                    turnPlayer.setText("Player vs PC");

                    break;
        }
    }

}
