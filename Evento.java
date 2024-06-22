import java.util.ArrayList;
import java.util.List;

public class Evento {
    private String nome;
    private String data;
    private List<Participante> participantes;

    public Evento(String nome, String data) {
        this.nome = nome;
        this.data = data;
        this.participantes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getData() {
        return data;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void adicionarParticipante(Participante participante) {
        participantes.add(participante);
    }

    public void removerParticipante(Participante participante) {
        participantes.remove(participante);
    }
}
