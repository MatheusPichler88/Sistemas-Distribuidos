package ServidorPedidos;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServidorPedidos {
    public static void main(String[] args) throws IOException {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        ServerSocket servidor = new ServerSocket(8080);

        System.out.println("Servidor iniciado");

        while (true) {
            Socket clienteSocket = servidor.accept();
            AtendimentoPedido tarefa = new AtendimentoPedido(clienteSocket); // cria a ficha do pedido
            pool.execute(tarefa); // joga o pedido para a cozinha para ser atendido
        }
    }

}
