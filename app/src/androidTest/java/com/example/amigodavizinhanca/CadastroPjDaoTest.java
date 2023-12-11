package com.example.amigodavizinhanca;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import bancodedados.CadastroPjDao;
import model.CadastroPJ;

public class CadastroPjDaoTest extends TestCase {

    private CadastroPjDao cadastroPjDao;
    CadastroPJ cadastroPJTeste = new CadastroPJ();

    @Before
    public void setUp() {
        Context context = ApplicationProvider.getApplicationContext();
        cadastroPjDao = new CadastroPjDao(context);

        cadastroPJTeste.setRazaoSocial("Instituição 1");
        cadastroPJTeste.setCpnj("1223178237287312");
        cadastroPJTeste.setEmail("admin@gmail.com");
        cadastroPJTeste.setCep("74290-045");
        cadastroPJTeste.setLogradouro("Avenida teste");
        cadastroPJTeste.setLocalidade("Goiânia");
        cadastroPJTeste.setUf("Goiás");
        cadastroPJTeste.setNumero("1");
        cadastroPJTeste.setComplemento("Casa 2");
    }

    @Test
    public void testaInserirPessoaJuridica() {

        // inicializa o objeto
//        CadastroPJ cadastroPJTeste = new CadastroPJ();
//        cadastroPJTeste.setRazaoSocial("Instituição 1");
//        cadastroPJTeste.setCpnj("1223178237287312");
//        cadastroPJTeste.setEmail("admin@gmail.com");
//        cadastroPJTeste.setCep("74290-045");
//        cadastroPJTeste.setLogradouro("Avenida teste");
//        cadastroPJTeste.setLocalidade("Goiânia");
//        cadastroPJTeste.setUf("Goiás");
//        cadastroPJTeste.setNumero("1");
//        cadastroPJTeste.setComplemento("Casa 2");

        long id = cadastroPjDao.inserir(cadastroPJTeste);

        List<CadastroPJ> empresasNoBanco = cadastroPjDao.listar();

        CadastroPJ cadastroPjDoBanco = null;
        for (CadastroPJ cadastro : empresasNoBanco) {
            if (cadastro.getId() == id) {
                cadastroPjDoBanco = cadastro;
                break;
            }
        }

        assert  id != -1;

        assert cadastroPjDoBanco != null;
        assert cadastroPjDoBanco.getRazaoSocial().equals("Instituição 1");
        assert cadastroPjDoBanco.getCpnj().equals("1223178237287312");
        assert cadastroPjDoBanco.getEmail().equals("admin@gmail.com");
        assert cadastroPjDoBanco.getCep().equals("74290-045");
//        assert cadastroPjDoBanco.getCep().equals("74290-045");
    }

    @Test
    public void testaExcluirPessoaJuridica() {
        // inicializa o objeto
        CadastroPJ cadastroPJTeste = new CadastroPJ();
        cadastroPJTeste.setRazaoSocial("Instituição 1");
        cadastroPJTeste.setCpnj("1223178237287312");
        cadastroPJTeste.setEmail("admin@gmail.com");
        cadastroPJTeste.setCep("74290-045");
        cadastroPJTeste.setLogradouro("Avenida teste");
        cadastroPJTeste.setLocalidade("Goiânia");
        cadastroPJTeste.setUf("Goiás");
        cadastroPJTeste.setNumero("1");
        cadastroPJTeste.setComplemento("Casa 2");
        cadastroPjDao.inserir(cadastroPJTeste);
        cadastroPjDao.excluir(cadastroPJTeste);
        List<CadastroPJ> empresasNoBanco = cadastroPjDao.listar();
        assert (empresasNoBanco.isEmpty());
    }
}


