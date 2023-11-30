package com.example.amigodavizinhanca;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;

    private static final int RC_SIGN_IN = 9001;
    EditText edtTextEmailAddress;
    EditText edtTextPassword;
    Button btnLogin;
    TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent signInIntent = AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(Arrays.asList(
                        new AuthUI.IdpConfig.EmailBuilder().build(),
                        new AuthUI.IdpConfig.GoogleBuilder().build()))
                .build();

        signInLauncher.launch(signInIntent);
//        setContentView(R.layout.activity_login);
//        startActivityForResult(AuthUI.getInstance()
//                        .createSignInIntentBuilder()
//                        .setAvailableProviders(Arrays.asList(
//                                new AuthUI.IdpConfig.EmailBuilder().build(),
//                                new AuthUI.IdpConfig.GoogleBuilder().build()))
//                        .build(),
//                RC_SIGN_IN);
//
//
//        mAuth = FirebaseAuth.getInstance();
//
//        List<AuthUI.IdpConfig> providers = Arrays.asList(
//                new AuthUI.IdpConfig.EmailBuilder().build(),
//                new AuthUI.IdpConfig.GoogleBuilder().build());

//        edtTextEmailAddress = findViewById(R.id.edtTextEmailAddress);
//        edtTextPassword = findViewById(R.id.edtTextPassword);
//        btnLogin = findViewById(R.id.btnLogin);
//        btnLogin.setOnClickListener(this);
//        txtView = findViewById(R.id.edtTxtResposta);
    }

    @Override
    public void onClick(View view) {
        Intent signInIntent = AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(Arrays.asList(
                        new AuthUI.IdpConfig.EmailBuilder().build(),
                        new AuthUI.IdpConfig.GoogleBuilder().build()))
                .build();

        signInLauncher.launch(signInIntent);
    }


    private final ActivityResultLauncher<Intent> signInLauncher = registerForActivityResult(
            new FirebaseAuthUIActivityResultContract(),
            new ActivityResultCallback<FirebaseAuthUIAuthenticationResult>() {
                // registra o resultado do login
                @Override
                public void onActivityResult(FirebaseAuthUIAuthenticationResult result) {
                    IdpResponse response = result.getIdpResponse();
                    if (result.getResultCode() == RESULT_OK) {
                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                        Toast.makeText(getApplicationContext(), "Login realizado com sucesso", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Falha no login", Toast.LENGTH_LONG).show();
                    }
                }
            }
    );

    // método que liga com o resultado de login, verificando se foi bem-sucedido ou se falhou
    private void onSignInResult(FirebaseAuthUIAuthenticationResult result) {
        IdpResponse response = result.getIdpResponse();
        if (result.getResultCode() == RESULT_OK) {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            Toast.makeText(getApplicationContext(), "Login realizado com sucesso", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Falha no login", Toast.LENGTH_LONG).show();
        }
    }
}