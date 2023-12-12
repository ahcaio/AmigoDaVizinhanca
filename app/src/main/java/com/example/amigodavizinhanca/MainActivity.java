package com.example.amigodavizinhanca;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.logging.Logger;

import Model.Vaga;
import bancodedados.VagaDao;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Button btnCadastrarVagas;
    EditText edtNomeVaga, edtEndereco, edtTelefone, edtEmail, edtDescricao;
    VagaDao dao;
    String acao = "Inserir";
    Vaga vaga;

    private EditText edtNome;
    private EditText edtEmail;
    private EditText edtCPF;

    private EditText edtCEP;
    private EditText edtLogradouro;

    private EditText edtLocalidade;

    private EditText edtUF;

    private EditText edtNumero;

    private EditText edtComplemento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cadastro_de_servico);

        //inicializa as variáves
        edtNomeVaga = findViewById(R.id.edtNomeVaga);
        edtEndereco = findViewById(R.id.edtEndereco);
        edtTelefone = findViewById(R.id.edtFone);
        edtEmail = findViewById(R.id.edtEmail);
        edtDescricao = findViewById(R.id.edtDescricao);

//        dao = new VagaDao(this);
        vaga = new Vaga();
        Intent intent = new Intent(MainActivity.this, CadastroDeServico.class);
        intent.putExtra("obj", vaga);
//        intent.putExtra("dao", dao);
        startActivity(intent);

//        btnCadastrarVagas = findViewById(R.id.btnCadastrar);
//        btnCadastrarVagas.setOnClickListener(this);

        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_cadastro_pj);
        Intent intent = new Intent(MainActivity.this, AtvCadastroPF.class);
    }
    public void ClickSalvar (View view){
        Toast.makeText(MainActivity.this,"Cadastro Realizado",Toast.LENGTH_LONG).show();

    }

}



