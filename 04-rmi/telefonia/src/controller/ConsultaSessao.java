package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import model.Sessao;
import model.TabelaHash;

public class ConsultaSessao extends UnicastRemoteObject implements IConsultaSessao {

    TabelaHash hashSessoes;

    public ConsultaSessao(TabelaHash hashSessoes) throws RemoteException {
        this.hashSessoes = hashSessoes;
    }

    @Override
    public String consultarSessao(String numeroCelular) throws RemoteException {
        System.out.println("Cliente pediu a sessão do celular: " + numeroCelular);
        Sessao sessao = hashSessoes.sessoes.get(numeroCelular);
        if (sessao == null) {
            return null;
        }
        return sessao.getDadosSessao();
    }
}
