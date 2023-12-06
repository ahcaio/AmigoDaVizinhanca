package bancodedados;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import Model.Vaga;

@androidx.room.Database(entities = {Vaga.class}, version = 1)
public abstract class Database extends RoomDatabase {

    public abstract InterfaceVagaDao vagaDao();
    private static Database INSTANCE;

    public static Database getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    Database.class, "app_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }



}
