import java.io.*;
import java.util.List;

public class Persistencia {
    public static void salvarDados(List<Evento> eventos, List<Participante> participantes, String arquivoEventos, String arquivoParticipantes) throws IOException {
        try (BufferedWriter bwEventos = new BufferedWriter(new FileWriter(arquivoEventos));
             BufferedWriter bwParticipantes = new BufferedWriter(new FileWriter(arquivoParticipantes))) {

            for (Evento evento : eventos) {
                bwEventos.write(evento.getTitulo() + "," + evento.getDescricao() + "," + evento.getData() + "," + evento.getLocal() + "," + evento.getCapacidade() + "\n");
            }

            for (Participante participante : participantes) {
                bwParticipantes.write(participante.getNome() + "," + participante.getEmail() + "," + participante.getTelefone() + "\n");
            }
        }
    }

    public static void carregarDados(List<Evento> eventos, List<Participante> participantes, String arquivoEventos, String arquivoParticipantes) throws IOException {
        try (BufferedReader brEventos = new BufferedReader(new FileReader(arquivoEventos));
             BufferedReader brParticipantes = new BufferedReader(new FileReader(arquivoParticipantes))) {

            String linha;
            while ((linha = brEventos.readLine()) != null) {
                String[] dados = linha.split(",");
                Evento evento = new Evento(dados[0], dados[1], dados[2], dados[3], Integer.parseInt(dados[4]));
                eventos.add(evento);
            }

            while ((linha = brParticipantes.readLine()) != null) {
                String[] dados = linha.split(",");
                Participante participante = new Participante(dados[0], dados[1], dados[2]);
                participantes.add(participante);
            }
        }
    }
}
