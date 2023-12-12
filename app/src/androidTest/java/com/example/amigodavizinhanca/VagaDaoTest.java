package com.example.amigodavizinhanca;

import android.content.Context;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import bancodedados.VagaDao;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import java.util.List;

import model.Vaga;

@RunWith(AndroidJUnit4.class)
public class VagaDaoTest {

    private VagaDao vagaDao;

    @Before
    public void setUp() {
        Context context = ApplicationProvider.getApplicationContext();
        vagaDao = new VagaDao(context);
    }

    @After
    public void tearDown() {
        // Limpar recursos após os testes, se necessário
    }

    @Test
    public void testaInserirVaga() {
        // Criar uma instância de Vaga para teste
        Vaga vagaTeste = new Vaga();
        vagaTeste.setNome("Vaga de Teste");
        vagaTeste.setEndereco("Endereço de Teste");
        vagaTeste.setTelefone("123456789");
        vagaTeste.setEmail("teste@example.com");
        vagaTeste.setDescricao("Descrição de Teste");

        // Inserir a Vaga no banco de dados de teste
        long id = vagaDao.inserir(vagaTeste);

        List<Vaga> vagasDoBanco = vagaDao.listar();

        // Procurar pela Vaga específica usando o id
        Vaga vagaDoBanco = null;
        for (Vaga vaga : vagasDoBanco) {
            if (vaga.getId() == id) {
                vagaDoBanco = vaga;
                break;
            }
        }

        // Verificar se a inserção foi bem-sucedida
        assert id != -1; // O id retornado deve ser válido

        // Verificar se os dados inseridos correspondem aos dados lidos do banco de dados
        assert vagaDoBanco != null;
        assert vagaDoBanco.getNome().equals("Vaga de Teste");
        assert vagaDoBanco.getEndereco().equals("Endereço de Teste");
        assert vagaDoBanco.getTelefone().equals("123456789");
        assert vagaDoBanco.getEmail().equals("teste@example.com");
        assert vagaDoBanco.getDescricao().equals("Descrição de Teste");
    }
}