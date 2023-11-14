package com.example.amigodavizinhanca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtTextEmailAddress;
    EditText edtTextPassword;
    Button btnLogin;
    TextView txtView;

    private String usuarioTeste = "admin";
    private String passwordTeste = "admin123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtTextEmailAddress = findViewById(R.id.edtTextEmailAddress);
        edtTextPassword = findViewById(R.id.edtTextPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
        txtView = findViewById(R.id.edtTxtResposta);
    }

    @Override
    public void onClick(View view) {
        String email = edtTextEmailAddress.getText().toString();
        String password = edtTextPassword.getText().toString();

        if (usuarioTeste == email && passwordTeste == password) {
            txtView.setText("Login realizado com sucesso");
        } else if (usuarioTeste != email && passwordTeste == password) {
            txtView.setText("O usuário está incorreto. Favor tentar novamente com outro usuário.");
        } else if (usuarioTeste == email && passwordTeste != password) {
            txtView.setText("A senha está incorreta. Favor tentar novamente.");
        } else {
            txtView.setText("A senha e o usuário estão incorretos. Favor tentar novamente.");
        }
    }
}