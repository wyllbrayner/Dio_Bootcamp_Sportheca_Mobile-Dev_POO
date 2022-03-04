public abstract class conta implements iConta {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected cliente cliente;

    public conta(cliente nomeCliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = nomeCliente;
    }

    @Override
    public boolean sacar(double valor) {
        if (this.saldo > valor) {
            this.saldo -= valor;
            System.out.println("Saque no valor de " + valor + " realizado com sucesso na conta " + this.getNumero() + ".");
            return true;
        } else {
            System.out.println("Saldo insuficiente para realizar o saque desejado.");            
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
        ///        System.out.println("Agencia: " + this.agencia);
        System.out.println("Numero:  " + this.numero);
        System.out.println("Saldo:   " + this.saldo);
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

/*
    public void sacar() {
        
    }
    public void depositar() {

    }
    public void transferir() {

    }
*/
}
