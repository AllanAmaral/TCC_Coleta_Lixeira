package Business;

import Business.Objects.CaminhaoLixeira;
import DAO.CaminhaoLixeiraRepository;

/**
 *
 * @author Allan.Amaral
 */
public class CaminhaoLixeiraController {

    private final CaminhaoLixeiraRepository repository;
    
    public CaminhaoLixeiraController() {
        repository = new CaminhaoLixeiraRepository();
    }

    public void registrar(CaminhaoLixeira caminhaoLixeira) throws Exception {
        repository.registrar(caminhaoLixeira);
    }

    public void editar(CaminhaoLixeira caminhaoLixeira) throws Exception {
        repository.editar(caminhaoLixeira);
    }

    public void excluir(Integer id) throws Exception {
        repository.excluir(id);
    }

    public CaminhaoLixeira buscarCaminhaoLixeira(Integer id) {
        return repository.buscarCaminhaoLixeira(id);
    }
    
    public CaminhaoLixeira buscarCaminhaoLixeiraIdLixeira(Integer idLixeira) {
        return repository.buscarCaminhaoLixeiraIdLixeira(idLixeira);
    }
}
