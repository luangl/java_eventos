import java.util.Scanner;

public abstract class Pessoa {
    private String nome;
    private String email;

    public Pessoa(String nome, String email) {
        this.nome = nome;
        while (!validarEmail(email)) {
            System.out.println("Email inválido! Insira um email válido:");
            Scanner scanner = new Scanner(System.in);
            email = scanner.nextLine();
        }
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public abstract void exibirDetalhes();

    private boolean validarEmail(String email) {
        // Verifica se o email contém pelo menos um '@'
        return email != null && email.contains("@");
    }
}
