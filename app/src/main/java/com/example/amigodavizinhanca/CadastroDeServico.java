    package com.example.amigodavizinhanca;

    import static android.content.ContentValues.TAG;

    import androidx.appcompat.app.AppCompatActivity;

    import android.content.Intent;
    import android.os.Bundle;
    import android.text.style.MaskFilterSpan;
    import android.util.Log;
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
            initializeComponents();

            Intent intent = getIntent();

            if (intent != null && intent.hasExtra("obj") && intent.hasExtra("acao")) {
                acao = intent.getStringExtra("acao");

                if ("Inserir".equals(acao)) {
                    Log.i(TAG, "Objeto Dao Criado");
                    dao = new VagaDao(this);
                }

                if (intent.getExtras() != null) {
                    vaga = (Vaga) intent.getSerializableExtra("obj");

                    if (vaga != null) {
                        populateFields();
                    } else {
                        Toast.makeText(this, "Vaga is null", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                } else {
                    Toast.makeText(this, "Extras are null", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        }

        private void initializeComponents() {
            btnCadastrarVagas = findViewById(R.id.btnCadastrar);
            btnCadastrarVagas.setOnClickListener(this);
            edtNomeVaga = findViewById(R.id.edtNomeVaga);
            edtEndereco = findViewById(R.id.edtEndereco);
            edtTelefone = findViewById(R.id.edtFone);
            edtEmail = findViewById(R.id.edtEmail);
            edtDescricao = findViewById(R.id.edtDescricao);
        }

        private void populateFields() {
            edtNomeVaga.setText(vaga.getNome());
            edtEndereco.setText(vaga.getEndereco());
            edtTelefone.setText(vaga.getTelefone());
            edtEmail.setText(vaga.getEmail());
            edtDescricao.setText(vaga.getDescricao());
        }

        @Override
        public void onClick(View view) {
            try {
                Log.v(TAG, "Método onClick executado");
                if (view == btnCadastrarVagas) {
                    if (validateInputs()) {
                        vaga.setNome(edtNomeVaga.getText().toString());
                        vaga.setEndereco(edtEndereco.getText().toString());
                        vaga.setTelefone(edtTelefone.getText().toString());
                        vaga.setEmail(edtEmail.getText().toString());
                        vaga.setDescricao(edtDescricao.getText().toString());

                        if ("Inserir".equals(acao) && dao != null) {
                            long id = dao.inserir(vaga);
                            Toast.makeText(this, "Vaga " + vaga.getNome() + " foi inserida com o id = " + id, Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Alguma variável é nula", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                Log.e(TAG, "Erro no botão OnClick", e);
            }
        }

        private boolean validateInputs() {
            return vaga != null && edtNomeVaga != null && dao != null && acao != null;
        }
    }
