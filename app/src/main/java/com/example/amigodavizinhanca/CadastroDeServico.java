package com.example.amigodavizinhanca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.style.MaskFilterSpan;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import Model.Vaga;
import bancodedados.VagaDao;

public class CadastroDeServico extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    ListView lstVagas;
    Button btnCadastrarVagas;

    List<Vaga> listaVagas = new ArrayList<>();
    ListAdapter listAdapter;
    int indice;
    VagaDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_de_servico);

        btnCadastrarVagas = findViewById(R.id.btnCadastrar);
        btnCadastrarVagas.setOnClickListener(this);

        lstVagas = findViewById(R.id.)


    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}