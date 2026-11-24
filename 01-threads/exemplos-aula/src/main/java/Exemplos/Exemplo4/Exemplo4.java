package Exemplos.Exemplo4;

public class Exemplo4 {
    private static int contador = 0;

    private static synchronized void incrementar() {
        contador++;
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable tarefa = () -> {
            for (int i = 0; i < 100000; i++) {
                incrementar();
            }
        };

        Thread t1 = new Thread(tarefa);
        Thread t2 = new Thread(tarefa);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Valor final do contador: " + contador);
        System.out.println("Valor esperado: 200000");
    }
}