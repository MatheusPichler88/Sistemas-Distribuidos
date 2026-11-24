package controller;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;
import model.TabelaHash;

public class Servidor {

    String enderecoServidor = "rmi://localhost/ConsultaSessao";
    ConsultaSessao objetoRemoto;

    public Servidor(TabelaHash hashSessoes) {
        try {
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            objetoRemoto = new ConsultaSessao(hashSessoes);
            Naming.bind(enderecoServidor, objetoRemoto);
            System.out.println("Servidor pronto para atender clientes");
            JOptionPane.showMessageDialog(null, "Servidor em execução e aguardando conexões");
        } catch (MalformedURLException | AlreadyBoundException | RemoteException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao iniciar o servidor: " + ex.getMessage());
        }
    }
}
