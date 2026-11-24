package com.mycompany.socketsudp.udp;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class EnviadorUDP {
    DatagramSocket socket;
    String ipServidor = "localhost";
    int portaServidor = 1234;

    public EnviadorUDP() {
        criaClientSocket();
    }

    private void criaClientSocket() {
        try {
            socket = new DatagramSocket();
            socket.setSoTimeout(3000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String enviaEEspera(String mensagem) {
        DatagramPacket pacote = ComunicadorUDP.montaMensagem(mensagem, ipServidor, portaServidor);
        ComunicadorUDP.enviaMensagem(socket, pacote);

        DatagramPacket resposta = ComunicadorUDP.recebeMensagem(socket);
        if (resposta == null) {
            return null;
        }
        return new String(resposta.getData(), 0, resposta.getLength());
    }
}
