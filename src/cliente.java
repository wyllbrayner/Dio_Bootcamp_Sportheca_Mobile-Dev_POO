public class cliente {
    private String nome;    
    private String cpf;    

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        if (this.nome != null) {
        System.out.println("Não é possível reatribuir o nome " + nome + " para a conta " + getNome()+" já criada.");
        } else {
            this.nome = nome;
            System.out.println("Atribuição do cliente " + this.nome + " realizada com sucesso.");
        }
    }
    public String getCpf() {
        return this.cpf;
    }
    public void setCpf(String cpf) {
        if (this.cpf != null) {
            System.out.println("Não é possível reatribuir um CPF" + cpf + " a uma conta já criada " + getNome()+ ".");
        } else if (cpf.length() == 11) {
            this.cpf = cpf;
            System.out.println("Atribuição do CPF " + this.cpf + " ao cliente " + getNome() + " realizada com sucesso.");
        } else {
            System.out.println("Confirme o CPF informado " + cpf + " ao cliente " + getNome() + ".");
        }
    }
}
