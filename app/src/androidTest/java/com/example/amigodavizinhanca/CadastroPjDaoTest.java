package com.example.amigodavizinhanca;

import android.content.Context;
import androidx.test.core.app.ApplicationProvider;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import bancodedados.CadastroPjDao;
import model.CadastroPJ;

public class CadastroPjDaoTest extends TestCase {

    private CadastroPjDao cadastroPjDao;

    @Before
    public void setUp() {
        Context context = ApplicationProvider.getApplicationContext();
        cadastroPjDao = new CadastroPjDao(context);
    }

    @Test
    public void testaInserirPessoaJuridica() {
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

        long id = cadastroPjDao.inserir(cadastroPJTeste);

        List<CadastroPJ> empresasNoBanco = cadastroPjDao.listar();

        CadastroPJ cadastroPjDoBanco = null;
        for (CadastroPJ cadastro : empresasNoBanco) {
            if (cadastro.getId() == id) {
                cadastroPjDoBanco = cadastro;
                break;
            }
        }

        assert id != -1;
        assert cadastroPjDoBanco != null;
        assert cadastroPjDoBanco.getRazaoSocial().equals("Instituição 1");
        assert cadastroPjDoBanco.getCpnj().equals("1223178237287312");
        assert cadastroPjDoBanco.getEmail().equals("admin@gmail.com");
        assert cadastroPjDoBanco.getCep().equals("74290-045");
    }

    @After
    public void limparBanco() {
        cadastroPjDao.limparDados();
    }

    @Test
    public void testaAlterarPessoaJuridica() {
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

        // Inserir um registro para depois alterar
        long id = cadastroPjDao.inserir(cadastroPJTeste);

        // Modificar alguns dados no objeto
        cadastroPJTeste.setRazaoSocial("Nova Razão Social");
        cadastroPJTeste.setEmail("novoemail@gmail.com");

        // Chamar o método de alterar
        long resultado = cadastroPjDao.alterar(cadastroPJTeste);

        // Verificar se o método de alterar retornou 1 (indicando uma alteração bem-sucedida)
        assertEquals(1, resultado);

        // Recuperar o registro alterado do banco de dados
        List<CadastroPJ> empresasNoBanco = cadastroPjDao.listar();
        CadastroPJ cadastroPjDoBanco = null;

        for (CadastroPJ cadastro : empresasNoBanco) {
            if (cadastro.getId() == id) {
                cadastroPjDoBanco = cadastro;
                break;
            }
        }

        // Verificar se os dados foram alterados corretamente
        assert cadastroPjDoBanco != null;
        assertEquals("Nova Razão Social", cadastroPjDoBanco.getRazaoSocial());
        assertEquals("novoemail@gmail.com", cadastroPjDoBanco.getEmail());
    }

    @Test
    public void testaExcluirPessoaJuridica() {
        CadastroPJ cadastroPJTeste1 = new CadastroPJ();
        cadastroPJTeste1.setRazaoSocial("Instituição 1");
        cadastroPJTeste1.setCpnj("1223178237287312");
        cadastroPJTeste1.setEmail("admin@gmail.com");
        cadastroPJTeste1.setCep("74290-045");
        cadastroPJTeste1.setLogradouro("Avenida teste");
        cadastroPJTeste1.setLocalidade("Goiânia");
        cadastroPJTeste1.setUf("Goiás");
        cadastroPJTeste1.setNumero("1");
        cadastroPJTeste1.setComplemento("Casa 2");

        cadastroPjDao.excluir(cadastroPJTeste1);
        List<CadastroPJ> empresasNoBancoTeste = cadastroPjDao.listar();
        assertTrue (empresasNoBancoTeste.isEmpty());
    }
}


//package com.example.amigodavizinhanca;
//
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//
//import androidx.test.core.app.ApplicationProvider;
//
//import junit.framework.TestCase;
//
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.List;
//
//import bancodedados.CadastroPjDao;
//import model.CadastroPJ;
//
//public class CadastroPjDaoTest extends TestCase {
//
//    private CadastroPjDao cadastroPjDao;
//    CadastroPJ cadastroPJTeste = new CadastroPJ();
//
//    @Before
//    public void setUp() {
//        Context context = ApplicationProvider.getApplicationContext();
//        cadastroPjDao = new CadastroPjDao(context);
//
//        cadastroPJTeste.setRazaoSocial("Instituição 1");
//        cadastroPJTeste.setCpnj("1223178237287312");
//        cadastroPJTeste.setEmail("admin@gmail.com");
//        cadastroPJTeste.setCep("74290-045");
//        cadastroPJTeste.setLogradouro("Avenida teste");
//        cadastroPJTeste.setLocalidade("Goiânia");
//        cadastroPJTeste.setUf("Goiás");
//        cadastroPJTeste.setNumero("1");
//        cadastroPJTeste.setComplemento("Casa 2");
//    }
//
//    @Test
//    public void testaInserirPessoaJuridica() {
//
//        long id = cadastroPjDao.inserir(cadastroPJTeste);
//
//        List<CadastroPJ> empresasNoBanco = cadastroPjDao.listar();
//
//        CadastroPJ cadastroPjDoBanco = null;
//        for (CadastroPJ cadastro : empresasNoBanco) {
//            if (cadastro.getId() == id) {
//                cadastroPjDoBanco = cadastro;
//                break;
//            }
//        }
//
//        assert id != -1;
//
//        assert cadastroPjDoBanco != null;
//        assert cadastroPjDoBanco.getRazaoSocial().equals("Instituição 1");
//        assert cadastroPjDoBanco.getCpnj().equals("1223178237287312");
//        assert cadastroPjDoBanco.getEmail().equals("admin@gmail.com");
//        assert cadastroPjDoBanco.getCep().equals("74290-045");
//    }
//
//    @Test
//    public void testaAlterarPessoaJuridica() {
//        // Inserir um registro para depois alterar
//        long id = cadastroPjDao.inserir(cadastroPJTeste);
//
//        // Modificar alguns dados no objeto
//        cadastroPJTeste.setRazaoSocial("Nova Razão Social");
//        cadastroPJTeste.setEmail("novoemail@gmail.com");
//
//        // Chamar o método de alterar
//        long resultado = cadastroPjDao.alterar(cadastroPJTeste);
//
//        // Verificar se o método de alterar retornou 1 (indicando uma alteração bem-sucedida)
//        assertEquals(1, resultado);
//
//        // Recuperar o registro alterado do banco de dados
//        List<CadastroPJ> empresasNoBanco = cadastroPjDao.listar();
//        CadastroPJ cadastroPjDoBanco = null;
//
//        for (CadastroPJ cadastro : empresasNoBanco) {
//            if (cadastro.getId() == id) {
//                cadastroPjDoBanco = cadastro;
//                break;
//            }
//        }
//
//        // Verificar se os dados foram alterados corretamente
//        assert cadastroPjDoBanco != null;
//        assertEquals("Nova Razão Social", cadastroPjDoBanco.getRazaoSocial());
//        assertEquals("novoemail@gmail.com", cadastroPjDoBanco.getEmail());
//    }
//
//    @Test
//    public void testaExcluirPessoaJuridica() {
//        Context context = ApplicationProvider.getApplicationContext();
//        CadastroPjDao cadastroPjDaoTeste = new CadastroPjDao(context);
//        CadastroPJ cadastroPJTeste1 = new CadastroPJ();
//
//        cadastroPJTeste1.setRazaoSocial("Instituição 1");
//        cadastroPJTeste1.setCpnj("1223178237287312");
//        cadastroPJTeste1.setEmail("admin@gmail.com");
//        cadastroPJTeste1.setCep("74290-045");
//        cadastroPJTeste1.setLogradouro("Avenida teste");
//        cadastroPJTeste1.setLocalidade("Goiânia");
//        cadastroPJTeste1.setUf("Goiás");
//        cadastroPJTeste1.setNumero("1");
//        cadastroPJTeste1.setComplemento("Casa 2");
//        cadastroPjDaoTeste.excluir(cadastroPJTeste1);
//        List<CadastroPJ> empresasNoBancoTeste = cadastroPjDaoTeste.listar();
//        assert (empresasNoBancoTeste.isEmpty());
//    }
//}


