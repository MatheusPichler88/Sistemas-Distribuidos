package Banco;

public class CaixaEletronico implements Runnable{
    private ContaBancaria conta;

    public CaixaEletronico(ContaBancaria conta) {
        this.conta = conta;
    }

    @Override
    public void run() {
        conta.sacar(400);
    }

}
