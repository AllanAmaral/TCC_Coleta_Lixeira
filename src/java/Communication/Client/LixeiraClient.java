package Communication.Client;

import Business.FacadeBusiness;
import java.awt.HeadlessException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import Communication.Server.CommunicationInterface;
import java.math.BigDecimal;

/**
 *
 * @author Allan.Amaral
 * 
 * Responsável pela interação entre usuário e processo­servidor
 */
public class LixeiraClient {

    private static FacadeBusiness facade;
    
    public static void main(String[] args) throws Exception {

        try {
            CommunicationInterface communicationInterface = (CommunicationInterface) Naming.lookup("//localhost/TCC_Coleta_Lixo_RMI");
            facade = new FacadeBusiness();
            
            Thread.sleep(5000);
            
        } catch (NotBoundException | MalformedURLException | RemoteException | HeadlessException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void enviarStatus(Integer idLixeira, BigDecimal coletadoLixeiraKg, BigDecimal coletadoLixeiraLt) {
        try {
            facade.enviarStatus(idLixeira, coletadoLixeiraKg, coletadoLixeiraLt);
            
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}