public class contaPoup extends conta {
    public contaPoup(cliente nomeCliente) {
        super(nomeCliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println(" **** Saldo Conta Poupança **** ");
        super.imprimirInfoComuns();
    }

}
