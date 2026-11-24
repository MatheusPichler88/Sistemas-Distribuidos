package controller;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IConsultaSessao extends Remote {
    public String consultarSessao(String numeroCelular) throws RemoteException;
}
