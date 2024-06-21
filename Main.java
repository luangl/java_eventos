import java.io.IOException;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GerenciamentoEventos gerenciamento = new GerenciamentoEventos();
        Scanner scanner = new Scanner(System.in);

        try {
            Persistencia.carregarDados(gerenciamento.getEventos(), gerenciamento.getParticipantes(), "eventos.txt", "participantes.txt");
        } catch (IOException e) {
            System.out.println("Erro ao carregar dados: " + e.getMessage());
        }

        boolean executando = true;

        while (executando) {
            System.out.println("1. Cadastrar Evento");
            System.out.println("2. Cadastrar Participante");
            System.out.println("3. Inscrever Participante em Evento");
            System.out.println("4. Registrar Check-in");
            System.out.println("5. Gerar Relatório de Participação");
            System.out.println("6. Exibir Estatísticas");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Descrição: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Data: ");
                    String data = scanner.nextLine();
                    System.out.print("Local: ");
                    String local = scanner.nextLine();
                    System.out.print("Capacidade Máxima: ");
                    int capacidade = scanner.nextInt();
                    scanner.nextLine();  // Consumir a nova linha

                    Evento evento = new Evento(titulo, descricao, data, local, capacidade);
                    gerenciamento.cadastrarEvento(evento);
                    break;

                case 2:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();

                    Participante participante = new Participante(nome, email, telefone);
                    gerenciamento.cadastrarParticipante(participante);
                    break;

                case 3:
                    System.out.print("Título do Evento: ");
                    String tituloEventoInscricao = scanner.nextLine();
                    System.out.print("Email do Participante: ");
                    String emailParticipanteInscricao = scanner.nextLine();

                    Evento eventoInscricao = gerenciamento.getEventos().stream()
                            .filter(e -> e.getTitulo().equals(tituloEventoInscricao))
                            .findFirst()
                            .orElse(null);

                    Participante participanteInscricao = gerenciamento.getParticipantes().stream()
                            .filter(p -> p.getEmail().equals(emailParticipanteInscricao))
                            .findFirst()
                            .orElse(null);

                    if (eventoInscricao != null && participanteInscricao != null) {
                        eventoInscricao.inscreverParticipante(participanteInscricao);
                        System.out.println("Participante inscrito com sucesso.");
                    } else {
                        System.out.println("Evento ou Participante não encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Título do Evento: ");
                    String tituloEventoCheckin = scanner.nextLine();
                    System.out.print("Email do Participante: ");
                    String emailParticipanteCheckin = scanner.nextLine();
                    System.out.print("Data do Check-in: ");
                    String dataCheckin = scanner.nextLine();

                    Evento eventoCheckin = gerenciamento.getEventos().stream()
                            .filter(e -> e.getTitulo().equals(tituloEventoCheckin))
                            .findFirst()
                            .orElse(null);

                    Participante participanteCheckin = gerenciamento.getParticipantes().stream()
                            .filter(p -> p.getEmail().equals(emailParticipanteCheckin))
                            .findFirst()
                            .orElse(null);

                    if (eventoCheckin != null && participanteCheckin != null) {
                        Checkin checkin = new Checkin(eventoCheckin, participanteCheckin, dataCheckin);
                        gerenciamento.registrarCheckin(checkin);
                    } else {
                        System.out.println("Evento ou Participante não encontrado.");
                    }
                    break;

                case 5:
                    System.out.print("Título do Evento: ");
                    String tituloRelatorio = scanner.nextLine();

                    Evento eventoRelatorio = gerenciamento.getEventos().stream()
                            .filter(e -> e.getTitulo().equals(tituloRelatorio))
                            .findFirst()
                            .orElse(null);

                    if (eventoRelatorio != null) {
                        List<Checkin> relatorio = gerenciamento.gerarRelatorioParticipacao(eventoRelatorio);
                        System.out.println("Relatório de Participação:");
                        for (Checkin c : relatorio) {
                            System.out.println("Participante: " + c.getParticipante().getNome() + ", Data: " + c.getDataCheckin());
                        }
                    } else {
                        System.out.println("Evento não encontrado.");
                    }
                    break;

                case 6:
                    gerenciamento.exibirEstatisticas();
                    break;

                case 7:
                    try {
                        Persistencia.salvarDados(gerenciamento.getEventos(), gerenciamento.getParticipantes(), "eventos.txt", "participantes.txt");
                    } catch (IOException e) {
                        System.out.println("Erro ao salvar dados: " + e.getMessage());
                    }
                    executando = false;
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        scanner.close();
    }
}
