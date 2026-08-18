package Exemplos.Runnable;

public class MinhaTarefa  implements Runnable{
    public void run (){
        System.out.println("Executando na thread" + Thread.currentThread().getName());
    }
}

   class Principal{
    public static void main(String[] args) {
        Thread t = new Thread(new MinhaTarefa(), "Tarefa 1");
        t.start();
    }
}