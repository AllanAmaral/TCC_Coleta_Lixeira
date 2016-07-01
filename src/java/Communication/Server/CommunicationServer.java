package Communication.Server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 *
 * @author Allan.Amaral
 * 
 * Cria a instância de um objeto que terá os métodos chamados remotamente
 */
public class CommunicationServer {

    public static void main(String[] args) {
        try {
                java.rmi.registry.LocateRegistry.createRegistry(1099);
                System.out.println("RMI registry ready.");

        } catch (RemoteException e) {
                System.out.println("RMI registry already running.");
        }

        try {
                Naming.rebind ("TCC_Coleta_Lixo_RMI", new CommunicationImpl());
                System.out.println ("CommunicationServer is ready.");

        } catch (RemoteException | MalformedURLException e) {
                System.out.println ("CommunicationServer failed:" + e.getMessage());
        }
    }
}