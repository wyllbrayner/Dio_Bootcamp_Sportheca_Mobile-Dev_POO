public class App {
    public static void main(String[] args) throws Exception {
        cliente c1 = new cliente();
        c1.setNome("Fulano de Tal");
        cliente c2 = new cliente();
        c2.setNome("Wyll");

        contaCorrente ccorr1 = new contaCorrente(c1);
        contaPoup cpoup1 = new contaPoup(c1);
        contaCorrente ccorr2 = new contaCorrente(c2);
        ccorr1.depositar(100);
        ccorr1.transferir(80, cpoup1);
        
        ccorr1.imprimirExtrato();
        cpoup1.imprimirExtrato();
        ccorr2.imprimirExtrato();
        
        cpoup1.transferir(100, ccorr1);
        cpoup1.transferir(5, ccorr2);
        ccorr2.sacar(200);
        cpoup1.sacar(10);

        ccorr1.imprimirExtrato();
        cpoup1.imprimirExtrato();
        ccorr2.imprimirExtrato();
    }
}
