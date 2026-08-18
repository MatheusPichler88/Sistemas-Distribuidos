public class ExemploBasico extends Thread {
    public void run() {
        System.out.println("Thread executando!");
    }
    
}

class Main {
    public static void main(String[] args) {
        ExemploBasico t = new ExemploBasico();
        t.start();
    }
}
