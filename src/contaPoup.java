public class contaPoup extends conta {
    public contaPoup(cliente nomeCliente) {
        super(nomeCliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println(" **** Saldo Conta Poupança **** ");
        super.imprimirInfoComuns();
    }

///    Regra de negócio: Conta Poupança não permite saque direto da conta.  
@Override
    public boolean sacar(double valor) {
        System.out.println("Transacao não autorizada para este tipo de conta.");
        return false;
    }

/*
    Melhorias:
    01 - Antes de realizar o saque, testamos se o saldo da conta possui o valor desejado.
    02 - Criamos mensagens personalizadas para informar se a transação foi executada.
*/ 
    @Override
    public void transferir(double valor, conta contaDestino) { 
        boolean SAC;       
        if (this.saldo >= valor) {
            this.saldo -= valor;
            System.out.println("Saque no valor de " + valor + " realizado com sucesso na conta " + this.getNumero() + ".");
            SAC = true;
        } else {
            System.out.println("Saldo atual de R$ " + this.saldo + " é insuficiente para realizar o saque de R$ " + valor + " desejado.");        
            SAC = false;          
        }
        if (SAC) {
            contaDestino.depositar(valor);
        }
    }
}
