package Banco;

public class Principal {
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria();
        Thread caixa1 = new Thread(new CaixaEletronico(conta), "Caixa 1");
        Thread caixa2 = new Thread(new CaixaEletronico(conta), "Caixa 2");
        Thread caixa3 = new Thread(new CaixaEletronico(conta), "Caixa 3");

        caixa1.start();
        caixa2.start();
        caixa3.start();

    }
}
