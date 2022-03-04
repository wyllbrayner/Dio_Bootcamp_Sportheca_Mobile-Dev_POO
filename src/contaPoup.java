public class contaPoup extends conta {
    public contaPoup(cliente nomeCliente) {
        super(nomeCliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println(" **** Saldo Conta Poupança **** ");
        super.imprimirInfoComuns();
    }

/*    @Override
    public void sacar(double valor) {
        System.out.println("Operação não autorizada neste tipo de conta.");            
    }
*/
}
