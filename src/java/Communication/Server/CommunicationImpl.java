package Communication.Server;

import Business.Objects.Caminhao;
import Business.Objects.Lixeira;
import Business.Objects.Motorista;
import Communication.Server.CommunicationInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Allan.Amaral
 * 
 * Implementação da interface, estruturas de dados e métodos locais necessários para a resolução do problema
 */
public class CommunicationImpl extends UnicastRemoteObject implements CommunicationInterface {

    protected CommunicationImpl() throws RemoteException {
    }

    @Override
    public int registrarMotorista(Motorista motorista) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editarMotorista(Motorista motorista) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluirMotorista(Motorista motorista) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Motorista buscarMotorista(String nomeMotorista) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int registraCaminhao(Caminhao caminhao) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editarCaminhao(Caminhao caminhao) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluirCaminhao(Caminhao caminhao) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int registraLixeira(Lixeira lixeira) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editarLixeira(Lixeira lixeira) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluirLixeira(Lixeira lixeira) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
}