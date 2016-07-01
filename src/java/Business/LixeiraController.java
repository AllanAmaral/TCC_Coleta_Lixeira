package Business;

import Business.Objects.Lixeira;
import DAO.LixeiraRepository;
import java.math.BigDecimal;

/**
 *
 * @author Allan.Amaral
 */
public class LixeiraController {

    private final LixeiraRepository repository;
    
    public LixeiraController() {
        repository = new LixeiraRepository();
    }

    public void registrar(BigDecimal capacidadeLixeiraKg, BigDecimal capacidadeLixeiraLt,
            BigDecimal coletadoLixeiraKg, BigDecimal coletadoLixeiraLt,
            BigDecimal latitude, BigDecimal longitude) throws Exception {
        Lixeira lixeira = new Lixeira(capacidadeLixeiraKg, capacidadeLixeiraLt, coletadoLixeiraKg, 
                coletadoLixeiraLt, latitude, longitude);
        repository.registrar(lixeira);
    }

    public void editar(Lixeira lixeira) throws Exception {
        repository.editar(lixeira);
    }

    public void excluir(Integer id) throws Exception {
        repository.excluir(id);
    }

    public Lixeira buscarLixeira(Integer id) {
        return repository.buscarLixeira(id);
    }
    
    public void enviarStatus(BigDecimal coletadoLixeiraKg, BigDecimal coletadoLixeiraLt) {
        
    }
}
