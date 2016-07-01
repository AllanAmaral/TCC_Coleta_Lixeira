package Business;

import Business.Objects.CaminhaoMotorista;
import DAO.CaminhaoMotoristaRepository;

/**
 *
 * @author Allan.Amaral
 */
public class CaminhaoMotoristaController {

    private final CaminhaoMotoristaRepository repository;
    
    public CaminhaoMotoristaController() {
        repository = new CaminhaoMotoristaRepository();
    }

    public void registrar(CaminhaoMotorista caminhaoMotorista) throws Exception {
        repository.registrar(caminhaoMotorista);
    }

    public void editar(CaminhaoMotorista caminhaoMotorista) throws Exception {
        repository.editar(caminhaoMotorista);
    }

    public void excluir(Integer id) throws Exception {
        repository.excluir(id);
    }

    public CaminhaoMotorista buscarCaminhaoMotorista(Integer id) {
        return repository.buscarCaminhaoMotorista(id);
    }
    
    public CaminhaoMotorista buscarCaminhaoMotoristaIdCaminhao(String idCaminhao) {
        return repository.buscarCaminhaoMotoristaIdCaminhao(idCaminhao);
    }
}
