package Exemplos.Exemplo2;

public class Exemplo2 {
    public static void main(String[] args) {
        Runnable tarefa = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + " -> " + i);
                try {
                    Thread.sleep(100); // simula um trabalho demorado
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(tarefa, "Garçom-1");
        Thread t2 = new Thread(tarefa, "Garçom-2");

        t1.start();
        t2.start();
    }
}