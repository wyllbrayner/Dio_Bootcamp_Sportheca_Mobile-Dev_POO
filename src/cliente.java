public class cliente {
    private String nome;    

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        if (this.nome != null) {
            System.out.println("Não é possível reatribuir uma conta já criada.");
        } else {
            this.nome = nome;
        }
    }
}
