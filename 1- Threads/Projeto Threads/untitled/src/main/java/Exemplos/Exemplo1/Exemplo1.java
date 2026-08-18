package Exemplos.Exemplo1;

public class Exemplo1 {
    public static void main(String[] args) {
        System.out.println("Thread principal iniciando: " + Thread.currentThread().getName());

        Thread minhaThread = new Thread(() -> {
            System.out.println("Rodando dentro da thread: " + Thread.currentThread().getName());
        });

        minhaThread.start();

        System.out.println("Thread principal terminou de disparar a thread!");
    }
}