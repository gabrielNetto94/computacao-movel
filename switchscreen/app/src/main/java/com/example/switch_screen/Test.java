package com.example.switch_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class Test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Intent it = getIntent();

        String t = it.getStringExtra("name");

        Toast.makeText(this, t, Toast.LENGTH_SHORT).show();

    }
}
