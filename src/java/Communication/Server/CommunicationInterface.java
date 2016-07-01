package Communication.Server;

import Business.Objects.Caminhao;
import Business.Objects.Lixeira;
import Business.Objects.Motorista;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Allan.Amaral
 * 
 * Declara os métodos que serão invocados remotamente
 */
public interface CommunicationInterface extends Remote {

    //Inicio Motorista
    
    public int registrarMotorista(Motorista motorista) throws RemoteException;
    
    public boolean editarMotorista(Motorista motorista) throws RemoteException;
    
    public boolean excluirMotorista(Motorista motorista) throws RemoteException;
    
    public Motorista buscarMotorista(String nomeMotorista) throws RemoteException;

    //Fim Motorista
    
    //Inicio Caminhao
    
    public int registraCaminhao(Caminhao caminhao) throws RemoteException;
    
    public boolean editarCaminhao(Caminhao caminhao) throws RemoteException;
    
    public boolean excluirCaminhao(Caminhao caminhao) throws RemoteException;
    
    //Fim Caminhao
    
    //Inicio Lixeira
    
    public int registraLixeira(Lixeira lixeira) throws RemoteException;
    
    public boolean editarLixeira(Lixeira lixeira) throws RemoteException;
    
    public boolean excluirLixeira(Lixeira lixeira) throws RemoteException;
    
    //Fim Lixeira
}