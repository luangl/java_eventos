import java.util.ArrayList;
import java.util.List;

public class GerenciadorParticipantes {
    private List<Participante> participantes;

    public GerenciadorParticipantes() {
        this.participantes = new ArrayList<>();
    }

    public void adicionarParticipante(Participante participante) {
        participantes.add(participante);
    }

    public void removerParticipante(Participante participante) {
        participantes.remove(participante);
    }

    public List<Participante> listarParticipantes() {
        return participantes;
    }

    public Participante buscarParticipantePorNome(String nome) {
        for (Participante participante : participantes) {
            if (participante.getNome().equals(nome)) {
                return participante;
            }
        }
        return null;
    }
}
