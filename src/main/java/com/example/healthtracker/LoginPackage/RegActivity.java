package com.example.healthtracker.LoginPackage;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;

import com.example.healthtracker.R;

public class RegActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        //Log.d("Reg Activity","here i am ");
    }
    public void loginMethod(View view) {
        Intent menuIntent = new Intent(this, MainActivity.class);
        startActivity(menuIntent);
    }
}