package bancodedados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;

import model.CadastroPJ;

public class CadastroPjDao {

    private final String TABELA = "cadastro_pj";
    private final String[] CAMPOS = {"id", "razao_social", "email", "cnpj", "cep", "logradouro",
            "localidade", "uf", "numero", "complemento"};
    private Conexao conexao;
    private SQLiteDatabase banco;

    public CadastroPjDao(Context context) {
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
        Log.i("VagaDao", "Banco de dados e tabela criados com sucesso");
    }

    private ContentValues preencherValores(CadastroPJ cadastroPj) {
        ContentValues values = new ContentValues();

        values.put("razao_social", cadastroPj.getRazaoSocial());
        values.put("email", cadastroPj.getEmail());
        values.put("cnpj", cadastroPj.getCpnj());
        values.put("cep", cadastroPj.getCep());
        values.put("logradouro", cadastroPj.getLogradouro());
        values.put("localidade", cadastroPj.getLocalidade());
        values.put("uf", cadastroPj.getUf());
        values.put("numero", cadastroPj.getNumero());
        values.put("complement", cadastroPj.getComplemento());

        return values;
    }

    public long inserir(CadastroPJ cadastroPJ) {
        ContentValues values = preencherValores(cadastroPJ);
        return banco.insertOrThrow(TABELA, null, values);
    }

    public long alterar(CadastroPJ cadastroPJ) {
        ContentValues values = preencherValores(cadastroPJ);
        return banco.update(TABELA,
                values,
                "id = ?",
                new String[]{cadastroPJ.getId().toString()});
    }

    public long excluir(CadastroPJ cadastroPJ) {
        return banco.delete(TABELA,
                "id = ?",
                new String[]{cadastroPJ.getId().toString()});
    }

    public List<CadastroPJ> listar() {
        Cursor c = banco.query(TABELA, CAMPOS, null, null,
                null, null, null);

        List<CadastroPJ> lista = new ArrayList<>();
        while (c.moveToNext()) {
            CadastroPJ cadastroPJ = new CadastroPJ();
            cadastroPJ.setId(c.getLong(0));
            cadastroPJ.setEmail(c.getString(1));
            cadastroPJ.setCpnj(c.getString(2));
            cadastroPJ.setCep(c.getString(3));
            cadastroPJ.setLogradouro(c.getString(4));
            cadastroPJ.setLocalidade(c.getString(5));
            cadastroPJ.setUf(c.getString(6));
            cadastroPJ.setNumero(c.getString(7));
            cadastroPJ.setComplemento(c.getString(8));
            lista.add(cadastroPJ);
        }
        return lista;
    }
}
