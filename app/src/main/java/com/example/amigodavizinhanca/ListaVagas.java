package com.example.amigodavizinhanca;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import Model.Vaga;
import bancodedados.VagaDao;


public class ListaVagas extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    ListView listVagas;
    Button btnCadastrarVagas;
    VagaDao dao;
    Vaga vaga;
    List<Vaga> listaVagasArray = new ArrayList<>();

    private boolean modoExclusao = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_vagas);

        listVagas = findViewById(R.id.listagemDeVagas);
        btnCadastrarVagas = findViewById(R.id.btnCadastrar);
        btnCadastrarVagas.setOnClickListener(this);
        dao = new VagaDao(this);

        listVagas.setOnItemClickListener(this);
        listVagas.setOnItemLongClickListener(this);
        atualizarLista();

    }
    protected void onResume(){
        super.onResume();
        atualizarLista();
    }

    private void atualizarLista(){
        listaVagasArray = dao.listar();
        ArrayAdapter<Vaga> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaVagasArray);
        listVagas.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();  // Notifica o adaptador sobre as mudanças nos dados
    }

    @Override
    public void onClick(View v) {
        if (v == btnCadastrarVagas) {
            vaga = new Vaga();
            vaga.setId(0L);
            abrirCadastro("Inserir", vaga);
        }
    }
    private void abrirCadastro(String acao, Vaga obj) {
        Intent telaVagas = new Intent(this, CadastroDeServico.class);
        Bundle extras = new Bundle();
        extras.putString("acao", acao);
        extras.putSerializable("obj", obj);
        telaVagas.putExtras(extras);
        startActivity(telaVagas);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        if (modoExclusao) {
            // Modo de exclusão ativado
            final Vaga vagaSelecionada = listaVagasArray.get(position);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Confirmação");
            builder.setMessage("Deseja excluir esta vaga?");
            builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dao.excluir(vagaSelecionada);
                    atualizarLista();
                    // Desativar o modo de exclusão após a exclusão
                    modoExclusao = false;
                }
            });
            builder.setNegativeButton("Não", null);
            builder.create().show();
        } else {
            // Modo de edição
            Vaga vagaSelecionada = listaVagasArray.get(position);
            abrirCadastro("Editar", vagaSelecionada);
        }
    }
    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
        // Modo de exclusão ativado
        modoExclusao = true;
        // Atualizar a lista para mostrar que o modo de exclusão está ativado
        atualizarLista();
        // Indica que o evento foi consumido
        return true;
    }
}