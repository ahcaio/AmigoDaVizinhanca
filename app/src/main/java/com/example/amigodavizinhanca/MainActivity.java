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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnCadastrarVagas;
    EditText edtNomeVaga, edtEndereco, edtTelefone, edtEmail, edtDescricao;
    VagaDao dao;
    String acao = "Inserir";
    Vaga vaga;

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

        dao = new VagaDao(this);
        vaga = new Vaga();
        Intent intent = new Intent(MainActivity.this, CadastroDeServico.class);
        intent.putExtra("obj", vaga);
        intent.putExtra("dao", dao);
        startActivity(intent);

        btnCadastrarVagas = findViewById(R.id.btnCadastrar);
        btnCadastrarVagas.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.v(TAG,"Método onClick executado");
        if (btnCadastrarVagas == v) {
            vaga.setNome(edtNomeVaga.getText().toString());
            vaga.setEndereco(edtEndereco.getText().toString());
            vaga.setTelefone(edtTelefone.getText().toString());
            vaga.setEmail(edtEmail.getText().toString());
            vaga.setDescricao(edtDescricao.getText().toString());
        }
        if (acao.equals("Inserir")) {
            long id = dao.inserir(vaga);
            Toast.makeText(this, "Vaga" + vaga.getNome() + " foi inserido com o id = " + id,
                    Toast.LENGTH_LONG).show();
        }
    }
}