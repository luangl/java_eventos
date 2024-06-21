import java.util.ArrayList;
import java.util.List;

public class Evento {
    private String titulo;
    private String descricao;
    private String data;
    private String local;
    private int capacidade;
    private List<Participante> participantesInscritos;

    public Evento(String titulo, String descricao, String data, String local, int capacidade) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
        this.local = local;
        this.capacidade = capacidade;
        this.participantesInscritos = new ArrayList<>();
    }

    // Getters e Setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public List<Participante> getParticipantesInscritos() {
        return participantesInscritos;
    }

    public void inscreverParticipante(Participante participante) {
        if (participantesInscritos.size() < capacidade) {
            participantesInscritos.add(participante);
        } else {
            throw new RuntimeException("Capacidade máxima atingida");
        }
    }
}
