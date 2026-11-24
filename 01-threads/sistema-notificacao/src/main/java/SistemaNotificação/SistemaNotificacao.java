package SistemaNotificação;

class Notificacao implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5 ; i++) {
            System.out.println("Nova notificação recebida! " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Notificação interrompida!");
            }
        }
    }

}

public class SistemaNotificacao {
    public static void main(String[] args) {
        Thread notificacao = new Thread(new Notificacao(), "Thread-Notificação");

        notificacao.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("Usuário navegando no aplicativo Thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrompida!");
            }

        }
    }
    // A saída esperada é a mistura das Threads, onde o usuário estará navegando e pode realizar de uma a duas ações até receber a notificação do aplicativo.
}
