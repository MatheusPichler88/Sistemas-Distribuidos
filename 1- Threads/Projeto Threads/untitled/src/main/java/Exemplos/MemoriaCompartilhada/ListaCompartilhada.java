package Exemplos.MemoriaCompartilhada;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ListaCompartilhada {
    private final List<Integer> numeros = new ArrayList<>();

    public synchronized void adicionarNumero(int numero) {
        numeros.add(numero);
        System.out.println(Thread.currentThread().getName() + " adicionou " + numero);

    }

    public synchronized List<Integer> retornarNumeros() {
        return new ArrayList<>(numeros);
    }
}

class main {
    public static void main(String[] args) {
        ListaCompartilhada lista = new ListaCompartilhada();
        ExecutorService pool = Executors.newFixedThreadPool(5);

        for (int i = 0; i <= 10; i++) {
            final int numero = i;
            pool.execute(() -> lista.adicionarNumero(numero));

        }
        pool.shutdown();
    }
}
