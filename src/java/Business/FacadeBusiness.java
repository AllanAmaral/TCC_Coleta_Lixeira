package Business;

import Business.Objects.Caminhao;
import Business.Objects.CaminhaoLixeira;
import Business.Objects.CaminhaoMotorista;
import Business.Objects.HistoricoColeta;
import Business.Objects.Lixeira;
import Business.Objects.Motorista;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Allan.Amaral
 * 
 * Delega para os controladores as chamadas de métodos
 */
@ManagedBean
public class FacadeBusiness {
    
    private MotoristaController motoristaController;
    private CaminhaoController caminhaoController;
    private CaminhaoMotoristaController caminhaoMotoristaController;
    private CaminhaoLixeiraController caminhaoLixeiraController;
    private HistoricoColetaController historicoColetaController;
    private LixeiraController lixeiraController;

    /*
    public FacadeBusiness() {
        motoristaController = new MotoristaController();
        caminhaoController = new CaminhaoController();
        caminhaoMotoristaController = new CaminhaoMotoristaController();
        caminhaoLixeiraController = new CaminhaoLixeiraController();
        historicoColetaController = new HistoricoColetaController();
        lixeiraController = new LixeiraController();
    }
    */
    
    public void cadastrarMotorista(Integer matricula, String nomeMotorista) throws Exception {
        motoristaController.registrar(matricula, nomeMotorista);
    }
    
    public void cadastrarCaminhao(String placa, BigDecimal capacidadeCaminhaoKg, BigDecimal capacidadeCaminhaoLt, 
            BigDecimal coletadoCaminhaoKg, BigDecimal coletadoCaminhaoLt) throws Exception {
        caminhaoController.registrar(placa, capacidadeCaminhaoKg, capacidadeCaminhaoLt, 
                coletadoCaminhaoKg, coletadoCaminhaoLt);
 
    }
    
    public String carregarPontosLixeiras() throws Exception {
        lixeiraController = new LixeiraController();
        lixeiraController.carregarPontosLixeiras();
        return "index";
    }
    
    public void cadastrarLixeira(BigDecimal capacidadeLixeiraKg, BigDecimal capacidadeLixeiraLt,
            BigDecimal coletadoLixeiraKg, BigDecimal coletadoLixeiraLt,
            BigDecimal latitude, BigDecimal longitude) throws Exception {
        lixeiraController.registrar(capacidadeLixeiraKg, capacidadeLixeiraLt, 
                coletadoLixeiraKg, coletadoLixeiraLt, latitude, longitude);
    }
    
    public void iniciarDiaDeTrabalho(Integer idMotorista, String placaCaminhao, 
            List<Lixeira> listaLixeiras) throws Exception {
        Motorista motorista = motoristaController.buscarMotorista(idMotorista);
        Caminhao caminhao = caminhaoController.buscarCaminhao(placaCaminhao);
        
        CaminhaoMotorista caminhaoMotorista = new CaminhaoMotorista(caminhao, motorista, new Date());
        caminhaoMotoristaController.registrar(caminhaoMotorista);
        
        CaminhaoLixeira caminhaoLixeira;
        for (Lixeira lixeira : listaLixeiras) {
            caminhaoLixeira = new CaminhaoLixeira(caminhao, lixeira, new Date());
            caminhaoLixeiraController.registrar(caminhaoLixeira);
        }
    }
    
    public List<Lixeira> gerarRota() {
        return null;
    }
    
    public void enviarStatus(Integer idLixeira, BigDecimal coletadoLixeiraKg, 
            BigDecimal coletadoLixeiraLt) throws Exception {
        if (coletadoLixeiraKg == BigDecimal.ZERO
                && coletadoLixeiraLt == BigDecimal.ZERO)
            gerarHistoricoColeta(idLixeira);
        
        lixeiraController.enviarStatus(coletadoLixeiraKg, coletadoLixeiraLt);
    }
    
    public void gerarHistoricoColeta(Integer idLixeira) throws Exception {
        Lixeira lixeira = lixeiraController.buscarLixeira(idLixeira);
        CaminhaoLixeira caminhaoLixeira = caminhaoLixeiraController
                .buscarCaminhaoLixeiraIdLixeira(idLixeira);
        CaminhaoMotorista caminhaoMotorista = caminhaoMotoristaController
                .buscarCaminhaoMotoristaIdCaminhao(caminhaoLixeira.getCaminhao().getIdCaminhao());
        
        HistoricoColeta historicoColeta = new HistoricoColeta(lixeira, caminhaoMotorista, 
                lixeira.getColetadoLixeiraKg(), lixeira.getColetadoLixeiraLt(), new Date());
        historicoColetaController.registrar(historicoColeta);
    }
}
