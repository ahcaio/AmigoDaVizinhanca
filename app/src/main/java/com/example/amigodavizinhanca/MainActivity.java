package com.example.amigodavizinhanca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton btnSobre;
    ImageButton btnSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSobre = findViewById(R.id.btnSobre);
        btnSobre.setOnClickListener(this);
        btnSair = findViewById(R.id.btnSair);
        btnSair.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnSobre) {
            // Crie um Intent para iniciar a nova atividade
            Intent intent = new Intent(MainActivity.this, SobreActivity.class);
            // Inicie a nova atividade
            startActivity(intent);
        }
        if (v == btnSair) {
            // Crie um Intent para iniciar a nova atividade
            finish();
        }
    }
}