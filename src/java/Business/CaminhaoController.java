package Business;

import Business.Objects.Caminhao;
import DAO.CaminhaoRepository;
import java.math.BigDecimal;

/**
 *
 * @author Allan.Amaral
 */
public class CaminhaoController {

    private final CaminhaoRepository repository;
    
    public CaminhaoController() {
        repository = new CaminhaoRepository();
    }

    public void registrar(String placa, BigDecimal capacidadeCaminhaoKg, BigDecimal capacidadeCaminhaoLt, 
            BigDecimal coletadoCaminhaoKg, BigDecimal coletadoCaminhaoLt) throws Exception {
        Caminhao caminhao = new Caminhao(placa, capacidadeCaminhaoKg, capacidadeCaminhaoLt, 
                coletadoCaminhaoKg, coletadoCaminhaoLt);
        repository.registrar(caminhao);
    }

    public void editar(Caminhao caminhao) throws Exception {
        repository.editar(caminhao);
    }

    public void excluir(Integer id) throws Exception {
        repository.excluir(id);
    }

    public Caminhao buscarCaminhao(String id) {
        return repository.buscarCaminhao(id);
    }
}
