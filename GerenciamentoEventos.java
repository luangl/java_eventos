import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GerenciamentoEventos implements Gerenciamento {
    private List<Evento> eventos;
    private List<Participante> participantes;
    private List<Checkin> checkins;

    public GerenciamentoEventos() {
        this.eventos = new ArrayList<>();
        this.participantes = new ArrayList<>();
        this.checkins = new ArrayList<>();
    }

    @Override
    public void cadastrarEvento(Evento evento) {
        eventos.add(evento);
    }

    @Override
    public void cadastrarParticipante(Participante participante) {
        participantes.add(participante);
    }

    @Override
    public void registrarCheckin(Checkin checkin) {
        try {
            Evento evento = checkin.getEvento();
            Participante participante = checkin.getParticipante();
            if (evento.getParticipantesInscritos().contains(participante)) {
                checkins.add(checkin);
            } else {
                throw new Exception("Participante não inscrito no evento.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao registrar check-in: " + e.getMessage());
        }
    }

    @Override
    public List<Checkin> gerarRelatorioParticipacao(Evento evento) {
        return checkins.stream()
                .filter(c -> c.getEvento().equals(evento))
                .collect(Collectors.toList());
    }

    @Override
    public void exibirEstatisticas() {
        System.out.println("Estatísticas de Participação:");
        for (Evento evento : eventos) {
            long count = checkins.stream()
                    .filter(c -> c.getEvento().equals(evento))
                    .count();
            System.out.println("Evento: " + evento.getTitulo() + ", Participantes: " + count);
        }
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }
}
