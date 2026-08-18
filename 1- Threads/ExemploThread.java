
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ExemploThread {
    public static void main(String[] args) {
        
        ArrayList<Integer> listaA = new ArrayList<>();
        ArrayList<Integer> listaB = new ArrayList<>();
        Random gerador = new Random();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                listaA.add(gerador.nextInt(100));
            }
        });
        
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                listaB.add(gerador.nextInt(100));
            }
        });

        ArrayList<Integer> listaC = new ArrayList<>();
        ArrayList<Integer> listaD = new ArrayList<>();

        TarefaPopular 
    }
}