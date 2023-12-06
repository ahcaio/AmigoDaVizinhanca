package bancodedados;

import android.content.Context;

import java.util.List;

import Model.Vaga;

public class VagaRepository {

    private InterfaceVagaDao vagaDao;

    public VagaRepository(Context context) {
        // Inicializa o DAO usando a instância do banco de dados
        vagaDao = Database.getInstance(context).vagaDao();
    }

    // Métodos do Repository que utilizam o DAO para interagir com o banco de dados
    public void inserirVaga(Vaga vaga) {
        vagaDao.insertVaga(vaga);
    }

    public List<Vaga> obterTodasVagas() {
        return vagaDao.getAllVagas();
    }

    public Vaga obterVagaPorId(long vagaId) {
        return vagaDao.getVagaById(vagaId);
    }

    public void atualizarVaga(Vaga vaga) {
        vagaDao.updateVaga(vaga);
    }

    public void excluirVaga(Vaga vaga) {
        vagaDao.deleteVaga(vaga);
    }

    // Adicione outros métodos conforme necessário

}
