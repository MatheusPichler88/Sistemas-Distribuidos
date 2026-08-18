class PrimeiraThread extends Thread {
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("Thread 1 executando!");
        }
    }
}

class SegundaThread extends Thread {
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("Segunda thread executando!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PrimeiraThread t1 = new PrimeiraThread();
        SegundaThread t2 = new SegundaThread();
        t1.start();  // inicia a thread
        t2.start();  // inicia a segunda thread
    }
}

