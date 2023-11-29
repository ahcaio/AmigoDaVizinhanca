package com.example.amigodavizinhanca;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    // instancia o Firebase para autenticar o usuário
    private FirebaseAuth mAuth;
    EditText edtTextEmailAddress;
    EditText edtTextPassword;
    Button btnLogin;
    TextView txtView;

//    private String usuarioTeste = "admin";
//    private String passwordTeste = "admin123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //inicializa a instância do firebaseauth
        mAuth = FirebaseAuth.getInstance();

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

//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Login");

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(getApplicationContext(), "Login realizado com sucesso", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Falha no login", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
//
//        if (Objects.equals(usuarioTeste, email) && Objects.equals(passwordTeste, password)) {
//            builder.setMessage("Login realizado com sucesso");
//        } else if (!Objects.equals(usuarioTeste, email) && Objects.equals(passwordTeste, password)) {
//            builder.setMessage("O usuário está incorreto. Favor tentar novamente com outro usuário.");
//        } else if (Objects.equals(usuarioTeste, email) && !Objects.equals(passwordTeste, password)) {
//            builder.setMessage("A senha está incorreta. Favor tentar novamente.");
//        } else {
//            builder.setMessage("A senha e o usuário estão incorretos. Favor tentar novamente.");
//        }
//
//        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int id) {
//                // Código a ser executado quando o usuário clica em OK
//                dialog.dismiss(); // Fechar o diálogo
//            }
//        });
//
//        builder.create().show();
//    }
}