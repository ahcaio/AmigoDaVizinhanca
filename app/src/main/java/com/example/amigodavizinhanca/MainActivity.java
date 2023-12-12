package com.example.amigodavizinhanca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import bancodedados.CadastroPjDao;
import model.CadastroPJ;
import model.Vaga;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    ImageButton btnSobre, btnSair, btnAddVaga, btnVagas, btnCadastroPj;
    Vaga vaga;
    CadastroPJ cadastroPJ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSobre = findViewById(R.id.btnSobre);
        btnSobre.setOnClickListener(this);
        btnSair = findViewById(R.id.btnSair);
        btnSair.setOnClickListener(this);
        btnAddVaga = findViewById(R.id.btnAddVaga);
        btnAddVaga.setOnClickListener(this);
        btnVagas = findViewById(R.id.btnVagas);
        btnVagas.setOnClickListener(this);
        btnCadastroPj= findViewById(R.id.btnCadastroPj);
        btnCadastroPj.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == btnSobre) {
            // Crie um Intent para iniciar a nova atividade
            Intent intent = new Intent(MainActivity.this, SobreActivity.class);
            // Inicie a nova atividade
            startActivity(intent);
        }
        if (v == btnVagas) {
            // Crie um Intent para iniciar a nova atividade
            Intent intent = new Intent(MainActivity.this, ListaVagas.class);
            // Inicie a nova atividade
            startActivity(intent);
        }
        if (v == btnCadastroPj) {
            cadastroPJ = new CadastroPJ();
            // Crie um Intent para iniciar a nova atividade
            Intent intent = new Intent(MainActivity.this, AtvCadastroPJ.class);
            intent.putExtra("acao", cadastroPJ);
            // Inicie a nova atividade
            startActivity(intent);
        }
        if (v == btnAddVaga) {
            vaga = new Vaga();
            // Crie um Intent para iniciar a nova atividade
            Intent intent = new Intent(MainActivity.this, CadastroDeServico.class);
            intent.putExtra("obj", vaga);
            // Inicie a nova atividade
            startActivity(intent);
        }
        if (v == btnSair) {
            // Crie um Intent para iniciar a nova atividade
            finish();
        }
    }
}



