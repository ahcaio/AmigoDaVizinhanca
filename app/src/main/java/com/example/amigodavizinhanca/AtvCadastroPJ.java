package com.example.amigodavizinhanca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import bancodedados.CadastroPjDao;
import model.CadastroPJ;

public class AtvCadastroPJ extends AppCompatActivity implements View.OnClickListener {

    // inicializa variáveis
    Button btnCadastrarPj;

    EditText edtRazaoSocial, edtEmail, edtCnpj, edtCep, edtLogradourdo, edtLocalidade,
            edtUf, edtNumero, edtComplemento;
    CadastroPjDao dao;
    String acao;

    CadastroPJ cadastroPJ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pj);

        acao = getIntent().getExtras().getString("acao");
        dao = new CadastroPjDao(this);
        btnCadastrarPj = findViewById(R.id.btnCadastrarPj);
        btnCadastrarPj.setOnClickListener(this);
        edtRazaoSocial = findViewById(R.id.edtRazaoSocial);
        edtEmail = findViewById(R.id.edtEmail);
        edtCnpj = findViewById(R.id.edtCNPJ);
        edtCep = findViewById(R.id.edtCEP);
        edtLogradourdo = findViewById(R.id.edtLogradouro);
        edtLocalidade = findViewById(R.id.edtLocalidade);
        edtUf = findViewById(R.id.edtUF);
        edtNumero = findViewById(R.id.edtNumero);
        edtComplemento = findViewById(R.id.edtComplemento);

        if (getIntent().getExtras().getSerializable("obj") != null) {
            cadastroPJ = (CadastroPJ) (getIntent().getExtras().getSerializable("obj"));

            edtRazaoSocial.setText(cadastroPJ.getRazaoSocial());
            edtCnpj.setText(cadastroPJ.getRazaoSocial());
            edtEmail.setText(cadastroPJ.getCpnj());
            edtCep.setText(cadastroPJ.getCep());
            edtLogradourdo.setText(cadastroPJ.getLogradouro());
            edtLocalidade.setText(cadastroPJ.getLocalidade());
            edtUf.setText(cadastroPJ.getUf());
            edtNumero.setText(cadastroPJ.getNumero());
            edtComplemento.setText(cadastroPJ.getComplemento());
        }


    }

    @Override
    public void onClick(View view) {
        if (view == btnCadastrarPj) {
            cadastroPJ.setRazaoSocial(edtRazaoSocial.getText().toString());
            cadastroPJ.setCpnj(edtCnpj.getText().toString());
            cadastroPJ.setCpnj(edtCnpj.getText().toString());
            cadastroPJ.setEmail(edtEmail.getText().toString());
            cadastroPJ.setCep(edtCep.getText().toString());
            cadastroPJ.setLogradouro(edtLogradourdo.getText().toString());
            cadastroPJ.setLocalidade(edtLocalidade.getText().toString());
            cadastroPJ.setUf(edtUf.getText().toString());
            cadastroPJ.setNumero(edtNumero.getText().toString());
            cadastroPJ.setComplemento(edtComplemento.getText().toString());
            long id = dao.inserir(cadastroPJ);
            Toast.makeText(this, "Instituição" + cadastroPJ.getId() + "foi inserida com sucesso",
                    Toast.LENGTH_LONG).show();
        }


    }
}