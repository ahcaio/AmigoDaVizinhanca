package com.example.amigodavizinhanca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import Model.Vaga;
import bancodedados.VagaDao;


public class ListaVagas extends AppCompatActivity implements View.OnClickListener {

    ListView listVagas;
    Button btnCadastrarVagas;
    EditText edtNomeVaga, edtEndereco, edtTelefone, edtEmail, edtDescricao;
    VagaDao dao;
    String acao;
    Vaga vaga;
    List<Vaga> listaVagasArray = new ArrayList<>();
    ListAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_vagas);

        listVagas = findViewById(R.id.listagemDeVagas);
        btnCadastrarVagas = findViewById(R.id.btnCadastrar);
        btnCadastrarVagas.setOnClickListener(this);
        dao = new VagaDao(this);

        atualizarLista();

    }
    protected void onResume(){
        super.onResume();
        atualizarLista();
    }

    private void atualizarLista(){
        listaVagasArray = dao.listar();
        listAdapter = new ArrayAdapter<Vaga>(this, android.R.layout.simple_list_item_1,
                listaVagasArray);
        listVagas.setAdapter(listAdapter);
    }

    @Override
    public void onClick(View v) {
        if (v == btnCadastrarVagas) {
            vaga = new Vaga();
            vaga.setId(0L);
            abrirCadastro("Inserir", vaga);
        }
    }

    private void abrirCadastro(String acao, Vaga obj) {
        Intent telaVagas = new Intent(this, CadastroDeServico.class);
        Bundle extras = new Bundle();
        extras.putString("acao", acao);
        extras.putSerializable("obj", obj);
        telaVagas.putExtras(extras);
        startActivity(telaVagas);
    }
}
