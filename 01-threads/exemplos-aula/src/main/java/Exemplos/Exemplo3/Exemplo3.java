package Exemplos.Exemplo3;

public class Exemplo3 {
    private static int contador = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable incrementar = () -> {
            for (int i = 0; i < 100000; i++) {
                contador++; // operação NÃO atômica: ler, somar, escrever
            }
        };

        Thread t1 = new Thread(incrementar);
        Thread t2 = new Thread(incrementar);

        t1.start();
        t2.start();

        t1.join(); // espera t1 terminar
        t2.join(); // espera t2 terminar

        System.out.println("Valor final do contador: " + contador);
        System.out.println("Valor esperado: 200000");
    }
}