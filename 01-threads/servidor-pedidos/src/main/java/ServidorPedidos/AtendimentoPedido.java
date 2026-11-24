package ServidorPedidos;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class AtendimentoPedido implements Runnable{
    private Socket socket;
    private static int contadorPedidos = 0;

    public AtendimentoPedido(Socket socket) {
        this.socket = socket;
    }

    private static synchronized int incrementarContadorPedidos() {
        return ++contadorPedidos;
    }

    @Override
    public void run() {
        try {
            Scanner leitor = new Scanner(socket.getInputStream()); // o leitor recebe o pedido do cliente via socket
            PrintWriter escritor = new PrintWriter(socket.getOutputStream(), true); // o escritor envia a resposta para o cliente via socket
            escritor.println("=== BEM-VINDO AO RESTAURANTE ===");
            escritor.println("Digite o seu pedido:");
            while (leitor.hasNextLine()) {

                String pedido = leitor.nextLine(); // o scanner recebe o pedido do cliente via socket.

                System.out.println("[" + Thread.currentThread().getName() + "] preparando pedido: [" + pedido + "]");
                Thread.sleep(2000);
                int totalPedidos = incrementarContadorPedidos();
                System.out.println("[" + Thread.currentThread().getName() + "] concluiu o pedido: [" + pedido + "] - Total de pedidos no dia: " + totalPedidos + "");
                escritor.println("Pedido de : " + pedido + " confirmado! Tempo estimado: 2s"); // envia a resposta para o cliente via socket
            }


        }
        catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
