package Business;

import Business.Objects.HistoricoColeta;
import DAO.HistoricoColetaRepository;

/**
 *
 * @author Allan.Amaral
 */
public class HistoricoColetaController {

    private final HistoricoColetaRepository repository;
    
    public HistoricoColetaController() {
        repository = new HistoricoColetaRepository();
    }

    public void registrar(HistoricoColeta historicoColeta) throws Exception {
        repository.registrar(historicoColeta);
    }

    public void editar(HistoricoColeta historicoColeta) throws Exception {
        repository.editar(historicoColeta);
    }

    public void excluir(Integer id) throws Exception {
        repository.excluir(id);
    }

    public HistoricoColeta buscarHistoricoColeta(Integer id) {
        return repository.buscarHistoricoColeta(id);
    }
}
