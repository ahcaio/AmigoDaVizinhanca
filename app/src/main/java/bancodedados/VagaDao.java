package bancodedados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Model.Vaga;

public class VagaDao {
    private final String TABELA = "vagas";
    private final String[] CAMPOS = {"id", "nome", "endereco", "telefone", "email", "descricao"};
    private Conexao conexao;
    private SQLiteDatabase banco;

    public VagaDao(Context context) {
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    private ContentValues preencherValores(Vaga vaga) {
        ContentValues values = new ContentValues();

        values.put("nome", vaga.getNome());
        values.put("endereco", vaga.getEndereco());
        values.put("telefone", vaga.getTelefone());
        values.put("email", vaga.getEmail());
        values.put("descricao", vaga.getDescricao());

        return values;
    }

    public long inserir(Vaga vaga) {
        ContentValues values = preencherValores(vaga);
        return banco.insertOrThrow(TABELA, null, values);
    }

    public long alterar(Vaga vaga) {
        ContentValues values = preencherValores(vaga);
        return banco.update(TABELA,
                values,
                "id = ?",
                new String[]{vaga.getId().toString()});
    }

    public long excluir(Vaga vaga) {
        return banco.delete(TABELA,
                "id = ?",
                new String[]{vaga.getId().toString()});
    }

    public List<Vaga> listar() {
        Cursor c = banco.query(TABELA, CAMPOS, null, null,
                null, null, null);

        List<Vaga> lista = new ArrayList<>();
        while (c.moveToNext()) {
            Vaga vaga = new Vaga();
            vaga.setId(c.getLong(0));
            vaga.setNome(c.getString(1));
            vaga.setEndereco(c.getString(2));
            vaga.setTelefone(c.getString(3));
            vaga.setEmail(c.getString(4));
            vaga.setDescricao(c.getString(5));
            lista.add(vaga);
        }
        return lista;
    }

}