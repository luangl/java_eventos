import java.io.*;
import java.util.List;

public class Persistencia {
    public static void salvarEventos(List<Evento> eventos, String arquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
            for (Evento evento : eventos) {
                writer.write(evento.getNome() + ";" + evento.getData());
                writer.newLine();
            }
        }
    }

    public static void carregarEventos(GerenciadorEventos gerenciadorEventos, String arquivo) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                Evento evento = new Evento(dados[0], dados[1]);
                gerenciadorEventos.adicionarEvento(evento);
            }
        }
    }

    public static void salvarParticipantes(List<Participante> participantes, String arquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
            for (Participante participante : participantes) {
                writer.write(participante.getNome() + ";" + participante.getEmail());
                writer.newLine();
            }
        }
    }

    public static void carregarParticipantes(GerenciadorParticipantes gerenciadorParticipantes, String arquivo) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                Participante participante = new Participante(dados[0], dados[1]);
                gerenciadorParticipantes.adicionarParticipante(participante);
            }
        }
    }

    public static void salvarCheckIns(List<CheckIn> checkIns, String arquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
            for (CheckIn checkIn : checkIns) {
                writer.write(checkIn.getEvento().getNome() + ";" + checkIn.getParticipante().getNome() + ";" + checkIn.getDataCheckIn());
                writer.newLine();
            }
        }
    }

    public static void carregarCheckIns(GerenciadorCheckIns gerenciadorCheckIns, GerenciadorEventos gerenciadorEventos, GerenciadorParticipantes gerenciadorParticipantes, String arquivo) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                Evento evento = gerenciadorEventos.buscarEventoPorNome(dados[0]);
                Participante participante = gerenciadorParticipantes.buscarParticipantePorNome(dados[1]);
                CheckIn checkIn = new CheckIn(participante, evento, dados[2]);
                gerenciadorCheckIns.registrarCheckIn(checkIn);
            }
        }
    }
}
