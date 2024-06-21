public class Responsavel extends Pessoa {
    public Responsavel(String nome, String email) {
        super(nome, email);
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Nome: " + getNome() + ", Email: " + getEmail());
    }
}
