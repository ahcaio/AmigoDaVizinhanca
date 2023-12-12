package bancodedados;

import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;

public class Conexao extends SQLiteOpenHelper {

    //Nome do DataBase
    private static final String DATABASE_NAME = "banco.db";

    // Versão do banco de dados
    private static final int DATABASE_VERSION = 1;


    private static final String SQL_CREATE_VAGA = "create table vagas ( "
            + "id integer PRIMARY KEY AUTOINCREMENT,"
            + "nome VARCHAR(100), "
            + "endereco VARCHAR(200), "
            + "telefone VARCHAR(20), "
            + "email VARCHAR(50), "
            + "descricao text );";


    public static final String SQL_CREATE_PJ = "create table cadastro_pj ( "
            + "id integer PRIMARY KEY AUTOINCREMENT,"
            + "razao_social VARCHAR(100), "
            + "email VARCHAR(100), "
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
        db.execSQL(SQL_CREATE_PJ);
        db.execSQL(SQL_CREATE_VAGA);

//        Cursor cursor = db.rawQuery("SELECT sql FROM sqlite_master WHERE name='vagas'", null);
//        if (cursor.moveToFirst()) {
//            Log.d("Database", "Create Table Query: " + cursor.getString(0));
//        }
//        cursor.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}