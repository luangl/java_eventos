import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GerenciadorEventos  implements Organizavel {
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

    @Override
    public void organizarPorNome() {
        Collections.sort(eventos, Comparator.comparing(Evento::getNome));
    }

    @Override
    public void organizarPorData() {
        Collections.sort(eventos, Comparator.comparing(Evento::getData));
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
