package com.example.przemek.hsport.myapplication4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchPartA(View view) {
        Intent intent = new Intent(this, ActivityAPart.class);
        startActivity(intent);
    }

    public void launchPartB(View view) {
        Intent intent = new Intent(this, ActivityBPart.class);
        startActivity(intent);
    }
}
