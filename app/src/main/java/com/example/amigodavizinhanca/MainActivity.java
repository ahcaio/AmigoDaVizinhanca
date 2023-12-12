package com.example.amigodavizinhanca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
        setContentView(R.layout.activity_cadastro_pj);
        Intent intent = new Intent(MainActivity.this, AtvCadastroPF.class);
    }
    public void ClickSalvar (View view){
        Toast.makeText(MainActivity.this,"Cadastro Realizado",Toast.LENGTH_LONG).show();
    }
}