public abstract class conta implements iConta {
    private static final String AGENCIA_PADRAO = "0001";
    private static int SEQUENCIAL = 1;
    protected String numAgencia;
    protected int numConta;
    protected double saldo;
    protected cliente cliente;
    protected String tpConta;
    private boolean valid = false;

    public conta(cliente nomeCliente) {
        this.numAgencia = AGENCIA_PADRAO;
        this.numConta = SEQUENCIAL++;
        this.cliente = nomeCliente;
    }

/*
    Melhorias:
    01 - Antes de realizar o saque, testamos se o saldo da conta possui o valor desejado.
    02 - Criamos mensagens personalizadas para informar se a transação foi executada.
    03 - Acrescentamos um novo campo para inserir o tipo de conta criada \"Poupanca\" ou \"Corrente\".
    04 - Criamos os métodos get e set para melhor trabalhar com o tipo de conta. 

    Regra de negócio:
    Conta Poupança não permite saque direto da conta.
*/

    @Override
    public boolean sacar(double valor) {
        if (this.getTpConta() == "Poupanca" && !valid) {
            System.out.println("Transacao não autorizada para conta do tipo " + getTpConta() + ".");
            System.out.println(valid + " " + this.getTpConta());
            return false;
        } else if (this.getTpConta() == "Poupanca" || this.getTpConta() == "Corrente") {
            if (this.saldo >= valor) {
                this.saldo -= valor;
                System.out.println("Saque no valor de " + valor + " realizado com sucesso na conta " + this.getNumero() + ".");
                System.out.println(valid + " " + this.getTpConta());
                return true;
            }   else {
                System.out.println("Saldo atual de R$ " + this.saldo + " é insuficiente para realizar o saque de R$ " + valor + " desejado.");
                return false;
            }
        }
        return true;
    }
    
    @Override
    public void depositar(double valor) {
        this.saldo += valor;
        System.out.println("Depósito no valor de " + valor + " realizado com sucesso na conta " + this.getNumero() + ".");
    }

    @Override
    public void transferir(double valor, conta contaDestino) {    
        valid = true;
        boolean SAC = this.sacar(valor);
        if (SAC) {
            contaDestino.depositar(valor);
        }
        valid = false;
    }

    protected void imprimirInfoComuns() {
        System.out.println("Tipo Conta : " + this.getTpConta());
        System.out.println("Titular    : " + this.cliente.getNome());
        System.out.println("Agencia    : " + this.numAgencia);
        System.out.println("Numero     : " + this.numConta);
        System.out.println("Saldo      : " + this.saldo);
    }
    
    public String getAgencia() {
        return numAgencia;
    }

    public int getNumero() {
        return numConta;
    }
    
    public double getSaldo() {
        return saldo;
    }

    public void setTpConta(String tpConta) {
        if (tpConta.isEmpty() || tpConta.isBlank() || tpConta == null) {
            System.out.println("São permitidos apenas os tipo de contas \"Poupanca\" ou \"Corrente\".");
        } else if (tpConta.equals("Corrente") || tpConta.equals("Poupanca")) {
            this.tpConta = tpConta;
        } else {
            System.out.println("São permitidos apenas os tipo de contas \"Poupanca\" ou \"Corrente\".");
        }
    }
/*
    public void setTpConta(String tpConta) {
        if (tpConta.equals("Corrente") || tpConta.equals("Poupanca")) {
            this.tpConta = tpConta;
        } else {
            System.out.println("São permitidos apenas os tipo de contas \"Poupanca\" ou \"Corrente\".");
        }
    }
*/
    public String getTpConta() {
        return this.tpConta;
    }
}
