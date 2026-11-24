package com.mycompany.socketsudp.udp;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class RecebedorUDP {
    DatagramSocket socket;

    public RecebedorUDP() {
        criaServerSocket();
    }

    private void criaServerSocket() {
        try {
            socket = new DatagramSocket(1234);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //aguarda um pacote datagrama chegar de um cliente pela porta 1234
    public DatagramPacket recebe() {
        return ComunicadorUDP.recebeMensagem(socket);
    }

    //envia a resposta para o mesmo ip e porta de quem mandou o pacote
    public void responde(String resposta, DatagramPacket pacoteRecebido) {
        DatagramPacket pacote = ComunicadorUDP.montaMensagem(resposta, pacoteRecebido.getAddress().getHostAddress(), pacoteRecebido.getPort());
        ComunicadorUDP.enviaMensagem(socket, pacote);
    }
}
