package com.example.amigodavizinhanca;

import androidx.appcompat.app.AppCompatActivity;

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

    public void criarComp() {
        btnCadastrarVagas = findViewById(R.id.btnCadastrar);
        btnCadastrarVagas.setOnClickListener(this);
        btnCadastrarVagas.setText(acao);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_de_servico);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("acao")) {
                acao = extras.getString("acao");
            }
            dao = new VagaDao(this);
            criarComp();

            if (extras.getSerializable("obj") != null) {
                vaga = (Vaga) extras.getSerializable("obj");
                edtNomeVaga.setText(vaga.getNome());
                edtEndereco.setText(vaga.getEndereco());
                edtTelefone.setText(vaga.getTelefone());
                edtEmail.setText(vaga.getEmail());
                edtDescricao.setText(vaga.getDescricao());
            }
        } else {
            // Handle the case when extras are null
            // You may want to show an error message or finish the activity
            Toast.makeText(this, "Extras are null", Toast.LENGTH_SHORT).show();
            finish(); // Finish the activity
        }
//        acao = Objects.requireNonNull(Objects.requireNonNull(getIntent().getExtras()).getString("acao"));
//        dao = new VagaDao(this);
//        criarComp();
//
//        if (getIntent().getExtras() != null && getIntent().getExtras().getSerializable("obj") != null) {
//            vaga = (Vaga) getIntent().getExtras().getSerializable("obj");
//            assert vaga != null;
//            edtNomeVaga.setText(vaga.getNome());
//            edtEndereco.setText(vaga.getEndereco());
//            edtTelefone.setText(vaga.getTelefone());
//            edtEmail.setText(vaga.getEmail());
//            edtDescricao.setText(vaga.getDescricao());
//        } else {
//            // Handle the case when extras are null
//            // You may want to show an error message or finish the activity
//            Toast.makeText(this, "Extras are null",
//                    Toast.LENGTH_SHORT).show();
//            finish(); // Finish the activity
//        }

    }

    @Override
    public void onClick(View v) {
        if (v == btnCadastrarVagas) {
            vaga.setNome(edtNomeVaga.getText().toString());
            vaga.setEndereco(edtEndereco.getText().toString());
            vaga.setTelefone(edtTelefone.getText().toString());
            vaga.setEmail(edtEmail.getText().toString());
            vaga.setDescricao(edtDescricao.getText().toString());
        }
        if (acao.equals("Inserir")) {
            long id = dao.inserir(vaga);
            Toast.makeText(this, "Vaga" + vaga.getNome() + " foi inserido com o id = " + id, Toast.LENGTH_LONG).show();
        }
    }
}