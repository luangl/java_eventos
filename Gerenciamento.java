
import java.util.List;

public interface Gerenciamento {
    void cadastrarEvento(Evento evento);
    void cadastrarParticipante(Participante participante);
    void registrarCheckin(Checkin checkin);
    List<Checkin> gerarRelatorioParticipacao(Evento evento);
    void exibirEstatisticas();
}