package bancodedados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Conexao extends SQLiteOpenHelper {

    //Nome do DataBase
    private static final String DATABASE_NAME = "banco.db";

    // Versão do banco de dados
    private static final int DATABASE_VERSION = 1;

    private static final String SQL_CREATE_VAGA = "create table cadastro_pj ( "
            + "id integer PRIMARY KEY AUTOINCREMENT,"
            + "razao_social VARCHAR(100), "
            + "cnpj VARCHAR(200), "
            + "cep VARCHAR(20), "
            + "logradouro VARCHAR(50), "
            + "localidade VARCHAR(50), "
            + "uf VARCHAR(50), "
            + "numero VARCHAR(50), "
            + "complemento VARCHAR(50), "
            + "descricao text );";


    // Construtor
    public Conexao(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_VAGA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}