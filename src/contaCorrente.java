public class contaCorrente extends conta {
    public contaCorrente(cliente nomeCliente) {
        super(nomeCliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println(" **** Saldo Conta Corrente **** ");
        super.imprimirInfoComuns();
    }
}
