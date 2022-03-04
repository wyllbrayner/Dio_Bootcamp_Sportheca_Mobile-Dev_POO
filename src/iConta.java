public interface iConta {
    public boolean sacar(double valor);

    public void depositar(double valor );

    public void transferir(double valor, conta contaDestino);

    public void imprimirExtrato();
}
