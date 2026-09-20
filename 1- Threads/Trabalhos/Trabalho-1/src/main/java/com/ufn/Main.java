package com.ufn;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Tarefa implements Runnable {
    public static List<Integer> listaNumeros = new ArrayList<>();
    public static Random gerador = new Random();


    Thread t1 = new Thread(parte1);
    Thread t2 = new Thread(parte2);
    Thread t3 = new Thread(parte3);
    Thread t4 = new Thread(parte4);


    public void run() {
    }

    public static List<Integer> geradorNumeros() {
        for (int i = 0; i < 10000; i++) {
            listaNumeros.add(gerador.nextInt(100000));
        }
        return listaNumeros;
    }
}


public class Main {
    public static void main(String[] args) {
        Tarefa.geradorNumeros();
        int tamanhoLista = Tarefa.listaNumeros.size();
        int tamanhoParte = tamanhoLista / 4;

        // Usamos o método subList para criar quatro listas com tamanhos diferentes
        List<Integer> parte1 = Tarefa.listaNumeros.subList(0, tamanhoParte);
        List<Integer> parte2 = Tarefa.listaNumeros.subList(tamanhoParte, tamanhoParte * 2);
        List<Integer> parte3 = Tarefa.listaNumeros.subList(tamanhoParte * 2, tamanhoParte * 3);
        List<Integer> parte4 = Tarefa.listaNumeros.subList(tamanhoParte * 3, tamanhoLista);

        System.out.println(parte1);
    }
}
