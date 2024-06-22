import java.util.ArrayList;
import java.util.List;

public class GerenciadorCheckIns {
    private List<CheckIn> checkIns;

    public GerenciadorCheckIns() {
        this.checkIns = new ArrayList<>();
    }

    public void registrarCheckIn(CheckIn checkIn) {
        checkIns.add(checkIn);
    }

    public List<CheckIn> listarCheckIns() {
        return checkIns;
    }

    public List<CheckIn> listarCheckInsPorEvento(Evento evento) {
        List<CheckIn> checkInsEvento = new ArrayList<>();
        for (CheckIn checkIn : checkIns) {
            if (checkIn.getEvento().equals(evento)) {
                checkInsEvento.add(checkIn);
            }
        }
        return checkInsEvento;
    }

    public List<CheckIn> listarCheckInsPorParticipante(Participante participante) {
        List<CheckIn> checkInsParticipante = new ArrayList<>();
        for (CheckIn checkIn : checkIns) {
            if (checkIn.getParticipante().equals(participante)) {
                checkInsParticipante.add(checkIn);
            }
        }
        return checkInsParticipante;
    }
}
