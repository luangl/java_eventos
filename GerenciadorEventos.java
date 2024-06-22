import java.util.ArrayList;
import java.util.List;

public class GerenciadorEventos {
    private List<Evento> eventos;

    public GerenciadorEventos() {
        this.eventos = new ArrayList<>();
    }

    public void adicionarEvento(Evento evento) {
        eventos.add(evento);
    }

    public void removerEvento(Evento evento) {
        eventos.remove(evento);
    }

    public List<Evento> listarEventos() {
        return eventos;
    }

    public Evento buscarEventoPorNome(String nome) {
        for (Evento evento : eventos) {
            if (evento.getNome().equals(nome)) {
                return evento;
            }
        }
        return null;
    }
}
