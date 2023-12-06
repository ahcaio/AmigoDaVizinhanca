package bancodedados;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import Model.Vaga;

@Dao
public interface InterfaceVagaDao {

    @Insert
    void insertVaga(Vaga vaga);

    @Query("SELECT * FROM Vaga")
    List<Vaga> getAllVagas();

    @Query("SELECT * FROM Vaga WHERE id = :vagaId")
    Vaga getVagaById(long vagaId);

    @Update
    void updateVaga(Vaga vaga);

    @Delete
    void deleteVaga(Vaga vaga);

}
