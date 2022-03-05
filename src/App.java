public class App {
    public static void main(String[] args) throws Exception {
        cliente c1 = new cliente();
        c1.setNome("Fulano de Tal");
        c1.setCpf("01234567891");
        cliente c2 = new cliente();
        c2.setNome("Beltrano o Tal");
        c2.setCpf("2345678910");
        c2.setCpf("23456789100");
        c2.setCpf("23456781001");
        c2.setNome("Ciclano o Tal");

        contaCorrente ccorr1 = new contaCorrente(c1);
        contaPoup cpoup1 = new contaPoup(c1);
        contaCorrente ccorr2 = new contaCorrente(c2);
        ccorr1.setTpConta("");
        ccorr1.setTpConta(" ");
        ccorr1.setTpConta("Cor");
        ccorr1.setTpConta("Corrente");
        ccorr2.setTpConta("Corrente");
        cpoup1.setTpConta("Poupanca");
        ccorr1.depositar(100);
        ccorr1.transferir(80, cpoup1);
        
        ccorr1.imprimirExtrato();
        cpoup1.imprimirExtrato();
        ccorr2.imprimirExtrato();
        
        cpoup1.transferir(100, ccorr1);
        cpoup1.transferir(5, ccorr2);
        ccorr1.transferir(5, ccorr2);
        ccorr2.sacar(200);
        cpoup1.sacar(10);
        ccorr1.sacar(20);
        ccorr1.sacar(15);

        ccorr1.imprimirExtrato();
        cpoup1.imprimirExtrato();
        ccorr2.imprimirExtrato();
    }
}
