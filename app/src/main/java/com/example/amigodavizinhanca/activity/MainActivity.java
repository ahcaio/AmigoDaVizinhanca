package com.example.amigodavizinhanca.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.amigodavizinhanca.CadastroPF;
import com.example.amigodavizinhanca.R;

public class MainActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_cadastro_pf);
        Intent intent = new Intent(MainActivity.this, CadastroPF.class);
        edtNome = (EditText) findViewById(R.id.edtNome);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtCPF = (EditText) findViewById(R.id.edtCPF);
        edtCEP = (EditText) findViewById(R.id.edtCEP);
        edtLogradouro = (EditText) findViewById(R.id.edtLogradouro);
        edtLocalidade = (EditText) findViewById(R.id.edtLocalidade);
        edtUF = (EditText) findViewById(R.id.edtUF);
        edtNumero = (EditText) findViewById(R.id.edtNumero);
        edtComplemento = (EditText) findViewById(R.id.edtComplemento);

    }
    public void ClickSalvar (View view){
        Toast.makeText(MainActivity.this,"Cadastro Realizado",Toast.LENGTH_LONG).show();
    }
}