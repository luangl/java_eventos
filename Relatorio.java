import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Relatorio {
    private GerenciadorCheckIns gerenciadorCheckIns;

    public Relatorio(GerenciadorCheckIns gerenciadorCheckIns) {
        this.gerenciadorCheckIns = gerenciadorCheckIns;
    }

    public void gerarRelatorioParticipacao() {
        Map<Evento, Integer> participacaoPorEvento = new HashMap<>();
        for (CheckIn checkIn : gerenciadorCheckIns.listarCheckIns()) {
            Evento evento = checkIn.getEvento();
            participacaoPorEvento.put(evento, participacaoPorEvento.getOrDefault(evento, 0) + 1);
        }

        for (Map.Entry<Evento, Integer> entry : participacaoPorEvento.entrySet()) {
            System.out.println("Evento: " + entry.getKey().getNome() + " - Participações: " + entry.getValue());
        }
    }

    public void gerarRelatorioFrequencia() {
        Map<Participante, Integer> frequenciaPorParticipante = new HashMap<>();
        for (CheckIn checkIn : gerenciadorCheckIns.listarCheckIns()) {
            Participante participante = checkIn.getParticipante();
            frequenciaPorParticipante.put(participante, frequenciaPorParticipante.getOrDefault(participante, 0) + 1);
        }

        for (Map.Entry<Participante, Integer> entry : frequenciaPorParticipante.entrySet()) {
            System.out.println("Participante: " + entry.getKey().getNome() + " - Frequência: " + entry.getValue());
        }
    }

    public void gerarEstatisticasEngajamento() {
        Map<Evento, Integer> participacaoPorEvento = new HashMap<>();
        Map<Participante, Integer> frequenciaPorParticipante = new HashMap<>();

        for (CheckIn checkIn : gerenciadorCheckIns.listarCheckIns()) {
            Evento evento = checkIn.getEvento();
            Participante participante = checkIn.getParticipante();

            participacaoPorEvento.put(evento, participacaoPorEvento.getOrDefault(evento, 0) + 1);
            frequenciaPorParticipante.put(participante, frequenciaPorParticipante.getOrDefault(participante, 0) + 1);
        }

        System.out.println("\n--- Estatísticas de Engajamento ---");

        for (Map.Entry<Evento, Integer> entry : participacaoPorEvento.entrySet()) {
            System.out.println("Evento: " + entry.getKey().getNome() + " - Participações: " + entry.getValue());
        }

        for (Map.Entry<Participante, Integer> entry : frequenciaPorParticipante.entrySet()) {
            System.out.println("Participante: " + entry.getKey().getNome() + " - Frequência: " + entry.getValue());
        }
    }
}
