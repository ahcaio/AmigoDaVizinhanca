package com.example.amigodavizinhanca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.style.MaskFilterSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;


import java.util.Objects;

import Model.Vaga;
import bancodedados.VagaDao;

public class CadastroDeServico extends AppCompatActivity implements View.OnClickListener {
    Button btnCadastrarVagas;
    EditText edtNomeVaga, edtEndereco, edtTelefone, edtEmail, edtDescricao;
    VagaDao dao;
    String acao;
    Vaga vaga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_de_servico);

        btnCadastrarVagas = findViewById(R.id.btnCadastrar);
        btnCadastrarVagas.setOnClickListener(this);
        edtNomeVaga = findViewById(R.id.edtNomeVaga);
        edtEndereco = findViewById(R.id.edtEndereco);
        edtTelefone = findViewById(R.id.edtFone);
        edtEmail = findViewById(R.id.edtEmail);
        edtDescricao = findViewById(R.id.edtDescricao);
        Intent intent = getIntent();
        if (intent.hasExtra("obj")) {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                if (extras.containsKey("acao")) {
                    acao = extras.getString("acao");
                }

                if (extras.getSerializable("obj") != null) {
                    vaga = (Vaga) extras.getSerializable("obj");
                    assert vaga != null;
                    edtNomeVaga.setText(vaga.getNome());
                    edtEndereco.setText(vaga.getEndereco());
                    edtTelefone.setText(vaga.getTelefone());
                    edtEmail.setText(vaga.getEmail());
                    edtDescricao.setText(vaga.getDescricao());
                }
                dao = new VagaDao(this);
            }

        } else {
            // Handle the case when extras are null
            // You may want to show an error message or finish the activity
            Toast.makeText(this, "Extras are null", Toast.LENGTH_SHORT).show();
            finish(); // Finish the activity
        }
    }

    @Override
    public void onClick(View v) {
        if (v == btnCadastrarVagas) {
            if (vaga != null && edtNomeVaga != null && dao != null && acao != null) {
                vaga.setNome(edtNomeVaga.getText().toString());
                vaga.setEndereco(edtEndereco.getText().toString());
                vaga.setTelefone(edtTelefone.getText().toString());
                vaga.setEmail(edtEmail.getText().toString());
                vaga.setDescricao(edtDescricao.getText().toString());
            }
            assert acao != null;
            if (acao.equals("Inserir")) {
                assert dao != null;
                long id = dao.inserir(vaga);
                Toast.makeText(this, "Vaga " + vaga.getNome() + " foi inserido com o id = " + id, Toast.LENGTH_LONG).show();
            }
        } else {
            // Tratar o caso quando vaga, edtNomeVaga, dao ou acao são nulos
            Toast.makeText(this, "Alguma variável é nula", Toast.LENGTH_SHORT).show();
        }
    }
}