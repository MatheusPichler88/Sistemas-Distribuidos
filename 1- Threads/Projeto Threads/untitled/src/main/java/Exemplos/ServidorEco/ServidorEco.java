package Exemplos.ServidorEco;

import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class ServidorEco {
    public static void main(String[] args) throws IOException {
        int porta = 12345;
        ExecutorService pool = Executors.newFixedThreadPool(3);
        ServerSocket serverSocket = new ServerSocket(porta);
        System.out.println("Servidor rodando na porta " + porta);

        while (true) {
            Socket clienteSocket = serverSocket.accept();
            pool.execute(() -> tratarCliente(clienteSocket));
        }
    }

    private static void tratarCliente(Socket socket) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            String linha;
            while ((linha = in.readLine()) != null) {
                System.out.println(Thread.currentThread().getName() + " recebeu: " + linha);
                out.println("Eco: " + linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}