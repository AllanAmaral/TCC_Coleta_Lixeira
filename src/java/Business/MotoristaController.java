package Business;

import Business.Objects.Motorista;
import DAO.MotoristaRepository;
import java.util.List;

/**
 *
 * @author Allan.Amaral
 */
public class MotoristaController {

    private final MotoristaRepository repository;
    
    public MotoristaController() {
        repository = new MotoristaRepository();
    }

    public void registrar(Integer matricula, String nomeMotorista) throws Exception {
        Motorista motorista = new Motorista(matricula, nomeMotorista);
        repository.registrar(motorista);
    }

    public void editar(Motorista motorista) throws Exception {
        repository.editar(motorista);
    }

    public void excluir(Integer id) throws Exception {
        repository.excluir(id);
    }

    public Motorista buscarMotorista(Integer id) {
        return repository.buscarMotorista(id);
    }
    
    public List<Motorista> buscarMotorista(String nome) {
        return repository.buscarMotorista(nome);
    }
}
