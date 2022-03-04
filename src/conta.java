public abstract class conta implements iConta {
    private static final String AGENCIA_PADRAO = "0001";
    private static int SEQUENCIAL = 1;
    protected String agencia;
    protected int numero;
    protected double saldo;
    protected cliente cliente;

    public conta(cliente nomeCliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = nomeCliente;
    }

/*
    Melhorias:
    01 - Antes de realizar o saque, testamos se o saldo da conta possui o valor desejado.
    02 - Criamos mensagens personalizadas para informar se a transação foi executada.
*/

    @Override
    public boolean sacar(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            System.out.println("Saque no valor de " + valor + " realizado com sucesso na conta " + this.getNumero() + ".");
            return true;
        } else {
            System.out.println("Saldo atual de R$ " + this.saldo + " é insuficiente para realizar o saque de R$ " + valor + " desejado.");         
            return false;          
        }
    }
    
    @Override
    public void depositar(double valor) {
        this.saldo += valor;
        System.out.println("Depósito no valor de " + valor + " realizado com sucesso na conta " + this.getNumero() + ".");
    }

    @Override
    public void transferir(double valor, conta contaDestino) {        
        boolean SAC = this.sacar(valor);
        if (SAC) {
            contaDestino.depositar(valor);
        }
    }

    protected void imprimirInfoComuns() {
        System.out.println("Titular: " + this.cliente.getNome());
        System.out.println("Agencia: " + this.agencia);
        System.out.println("Numero:  " + this.numero);
        System.out.println("Saldo:   " + this.saldo);
    }

    public String getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }
}
