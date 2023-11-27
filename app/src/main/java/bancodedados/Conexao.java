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

    private static final String SQL_CREATE = "create table vagas ( "
            + "id integer PRIMARY KEY AUTOINCREMENT,"
            + "nome VARCHAR(100), "
            + "endereco VARCHAR(200), "
            + "telefone VARCHAR(20), "
            + "email VARCHAR(50), "
            + "descricao text );";

    // Construtor
    public Conexao(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}