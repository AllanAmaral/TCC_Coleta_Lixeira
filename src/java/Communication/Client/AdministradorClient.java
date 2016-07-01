package Communication.Client;

import Business.FacadeBusiness;
import Business.Objects.Caminhao;
import Business.Objects.CaminhaoMotorista;
import Business.Objects.Lixeira;
import Business.Objects.Motorista;
import java.awt.HeadlessException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import Communication.Server.CommunicationInterface;
import DAO.CaminhaoMotoristaRepository;
import DAO.CaminhaoRepository;
import DAO.MotoristaRepository;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Allan.Amaral
 * 
 * Responsável pela interação entre usuário e processo­servidor
 */
public class AdministradorClient {                                                                      

    private static FacadeBusiness facade;
    
    public static void main(String[] args) throws Exception {
        try {
            CommunicationInterface communicationInterface = (CommunicationInterface) Naming.lookup("//localhost/TCC_Coleta_Lixo_RMI");
            facade = new FacadeBusiness();
            
            /*CaminhaoRepository cr = new CaminhaoRepository();
            Caminhao caminhao = new Caminhao("ILZ3456", BigDecimal.ZERO, BigDecimal.ZERO, 
                    BigDecimal.ZERO, BigDecimal.ZERO);
            cr.registrar(caminhao);
            //Caminhao caminhao = cr.buscarCaminhao("ILZ3456");
            
            MotoristaRepository mr = new MotoristaRepository();
            Motorista motorista = new Motorista(123, "allan");
            mr.registrar(motorista);
            //Motorista motorista = mr.buscarMotorista(123);
            
            CaminhaoMotorista cm = new CaminhaoMotorista(caminhao, motorista, new Date());
            CaminhaoMotoristaRepository cmr = new CaminhaoMotoristaRepository();
            cmr.registrar(cm);
            
            CaminhaoMotorista result = cmr.buscarCaminhaoMotoristaIdCaminhao("ILZ3456");
            */
            Thread.sleep(5000);
            
        } catch (NotBoundException | MalformedURLException | RemoteException | HeadlessException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void cadastrarMotorista(Integer matricula, String nomeMotorista) {
        try {
            facade.cadastrarMotorista(matricula, nomeMotorista);
            System.out.println("Motorista cadastrado com sucesso");
            
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    public void cadastrarCaminhao(String placa, BigDecimal capacidadeCaminhaoKg, BigDecimal capacidadeCaminhaoLt, 
            BigDecimal coletadoCaminhaoKg, BigDecimal coletadoCaminhaoLt) {
        try {
            facade.cadastrarCaminhao(placa, capacidadeCaminhaoKg, capacidadeCaminhaoLt, 
                    coletadoCaminhaoKg, coletadoCaminhaoLt);
            System.out.println("Caminhão cadastrado com sucesso");
            
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    public void cadastrarLixeira(BigDecimal capacidadeLixeiraKg, BigDecimal capacidadeLixeiraLt,
            BigDecimal coletadoLixeiraKg, BigDecimal coletadoLixeiraLt,
            BigDecimal latitude, BigDecimal longitude) {
        try {
            facade.cadastrarLixeira(capacidadeLixeiraKg, capacidadeLixeiraLt, 
                    coletadoLixeiraKg, coletadoLixeiraLt, latitude, longitude);
            System.out.println("Lixeira cadastrada com sucesso");
            
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    public void iniciarDiaDeTrabalho(Integer idMotorista, String placaCaminhao, List<Lixeira> listaLixeiras) {
        try {
            facade.iniciarDiaDeTrabalho(idMotorista, placaCaminhao, listaLixeiras);
            System.out.println("Dia de trabalho iniciado com sucesso");
            
        } catch (Exception e){
            System.err.println(e.getMessage());
        } 
    }
    
    public List<Lixeira> gerarRota() {
        try {
            return facade.gerarRota();
            
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
        return null;
    }
}