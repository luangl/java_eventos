import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static GerenciadorEventos gerenciadorEventos = new GerenciadorEventos();
    private static GerenciadorParticipantes gerenciadorParticipantes = new GerenciadorParticipantes();
    private static GerenciadorCheckIns gerenciadorCheckIns = new GerenciadorCheckIns();
    private static Relatorio relatorio = new Relatorio(gerenciadorCheckIns);

    public static void main(String[] args) {
        try {
            Persistencia.carregarEventos(gerenciadorEventos, "eventos.txt");
            Persistencia.carregarParticipantes(gerenciadorParticipantes, "participantes.txt");
            Persistencia.carregarCheckIns(gerenciadorCheckIns, gerenciadorEventos, gerenciadorParticipantes, "checkins.txt");
        } catch (IOException e) {
            System.out.println("Erro ao carregar dados: " + e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Sistema de Gerenciamento de Eventos ---");
            System.out.println("1. Gerenciar Eventos");
            System.out.println("2. Gerenciar Participantes");
            System.out.println("3. Registrar Check-in");
            System.out.println("4. Gerar Relatórios");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            switch (opcao) {
                case 1:
                    gerenciarEventos(scanner);
                    break;
                case 2:
                    gerenciarParticipantes(scanner);
                    break;
                case 3:
                    registrarCheckIn(scanner);
                    break;
                case 4:
                    gerarRelatorios(scanner);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);

        try {
            Persistencia.salvarEventos(gerenciadorEventos.listarEventos(), "eventos.txt");
            Persistencia.salvarParticipantes(gerenciadorParticipantes.listarParticipantes(), "participantes.txt");
            Persistencia.salvarCheckIns(gerenciadorCheckIns.listarCheckIns(), "checkins.txt");
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    private static void gerenciarEventos(Scanner scanner) {
        int opcao;

        do {
            System.out.println("\n--- Gerenciar Eventos ---");
            System.out.println("1. Adicionar Evento");
            System.out.println("2. Listar Eventos");
            System.out.println("3. Remover Evento");
            System.out.println("4. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  

            switch (opcao) {
                case 1:
                    System.out.print("Nome do evento: ");
                    String nomeEvento = scanner.nextLine();
                    System.out.print("Data do evento (DDMMAAAA): ");
                    String dataEvento = scanner.nextLine();
                    Evento evento = new Evento(nomeEvento, dataEvento);
                    gerenciadorEventos.adicionarEvento(evento);
                    System.out.println("Evento adicionado com sucesso.");
                    break;
                case 2:
                    listarEventosOrdenados(scanner);
                    break;
                case 3:
                    System.out.print("Nome do evento a remover: ");
                    String nomeRemover = scanner.nextLine();
                    Evento eventoRemover = gerenciadorEventos.buscarEventoPorNome(nomeRemover);
                    if (eventoRemover != null) {
                        gerenciadorEventos.removerEvento(eventoRemover);
                        System.out.println("Evento removido com sucesso.");
                    } else {
                        System.out.println("Evento não encontrado.");
                    }
                    break;
                case 4:
                System.out.println("Voltando ao menu principal...");
                break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);
    }

    private static void listarEventosOrdenados(Scanner scanner) {
        int opcao;
    
        System.out.println("\n--- Listar Eventos Ordenados ---");
        System.out.println("1. Por Nome");
        System.out.println("2. Por Data");
        System.out.print("Escolha uma opção de ordenação: ");
        opcao = scanner.nextInt();
        scanner.nextLine(); 
    
        switch (opcao) {
            case 1:
                System.out.println("\n--- Lista de Eventos Ordenados por Nome ---");
                gerenciadorEventos.organizarPorNome();
                    System.out.println("Eventos organizados por nome.");
                for (Evento ev : gerenciadorEventos.listarEventos()) {
                    System.out.println("Nome: " + ev.getNome() + ", Data: " + ev.getData());
                }
                break;
            case 2:
                System.out.println("\n--- Lista de Eventos Ordenados por Data ---");
                gerenciadorEventos.organizarPorData();
                    System.out.println("Eventos organizados por data.");
                for (Evento ev : gerenciadorEventos.listarEventos()) {
                    System.out.println("Nome: " + ev.getNome() + ", Data: " + ev.getData());
                }
                break;
            default:
                System.out.println("Opção inválida. Voltando ao menu anterior...");
                break;
        }
    }

    private static void gerenciarParticipantes(Scanner scanner) {
        int opcao;

        do {
            System.out.println("\n--- Gerenciar Participantes ---");
            System.out.println("1. Adicionar Participante");
            System.out.println("2. Listar Participantes");
            System.out.println("3. Remover Participante");
            System.out.println("4. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome do participante: ");
                    String nomeParticipante = scanner.nextLine();
                    System.out.print("Email do participante: ");
                    String emailParticipante = scanner.nextLine();
                    Participante participante = new Participante(nomeParticipante, emailParticipante);
                    gerenciadorParticipantes.adicionarParticipante(participante);
                    System.out.println("Participante adicionado com sucesso.");
                    break;
                case 2:
                    System.out.println("\n--- Lista de Participantes ---");
                    for (Participante p : gerenciadorParticipantes.listarParticipantes()) {
                        System.out.println("Nome: " + p.getNome() + ", Email: " + p.getEmail());
                    }
                    break;
                case 3:
                    System.out.print("Nome do participante a remover: ");
                    String nomeRemover = scanner.nextLine();
                    Participante participanteRemover = gerenciadorParticipantes.buscarParticipantePorNome(nomeRemover);
                    if (participanteRemover != null) {
                        gerenciadorParticipantes.removerParticipante(participanteRemover);
                        System.out.println("Participante removido com sucesso.");
                    } else {
                        System.out.println("Participante não encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);
    }

    private static void registrarCheckIn(Scanner scanner) {
        System.out.print("Nome do participante: ");
        String nomeParticipante = scanner.nextLine();
        Participante participante = gerenciadorParticipantes.buscarParticipantePorNome(nomeParticipante);
        if (participante == null) {
            System.out.println("Participante não encontrado.");
            return;
        }

        System.out.print("Nome do evento: ");
        String nomeEvento = scanner.nextLine();
        Evento evento = gerenciadorEventos.buscarEventoPorNome(nomeEvento);
        if (evento == null) {
            System.out.println("Evento não encontrado.");
            return;
        }

        System.out.print("Data do check-in (DDMMAAAA): ");
        String dataCheckIn = scanner.nextLine();
        CheckIn checkIn = new CheckIn(participante, evento, dataCheckIn);
        gerenciadorCheckIns.registrarCheckIn(checkIn);
        System.out.println("Check-in registrado com sucesso.");
    }

    private static void gerarRelatorios(Scanner scanner) {
        int opcao;

        do {
            System.out.println("\n--- Gerar Relatórios ---");
            System.out.println("1. Relatório de Participação por Evento");
            System.out.println("2. Relatório de Frequência por Participante");
            System.out.println("3. Estatísticas de Engajamento");
            System.out.println("4. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            switch (opcao) {
                case 1:
                    relatorio.gerarRelatorioParticipacao();
                    break;
                case 2:
                    relatorio.gerarRelatorioFrequencia();
                    break;
                case 3:
                    relatorio.gerarEstatisticasEngajamento();
                    break;
                case 4:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);
    }
}
