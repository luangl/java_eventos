public class Participante extends Pessoa {
    private String telefone;

    public Participante(String nome, String email, String telefone) {
        super(nome, email);
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Nome: " + getNome() + ", Email: " + getEmail() + ", Telefone: " + telefone);
    }
}