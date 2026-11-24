package Banco;

public class ContaBancaria {
    private double saldo = 1000;

    public synchronized void sacar(double valor) {
        if (saldo >= valor) {
            try {
                Thread.sleep(3000);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            saldo -= valor;
            System.out.println(Thread.currentThread().getName() + " sacou R$ " + valor + ", saldo atual: R$ " + saldo);
        }
        else {
            System.out.println(Thread.currentThread().getName() + " saque de R$ " + valor + " negado, saldo restante: R$ " + saldo + "");
        }
    }
}
