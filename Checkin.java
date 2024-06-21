public class Checkin {
    private Evento evento;
    private Participante participante;
    private String dataCheckin;

    public Checkin(Evento evento, Participante participante, String dataCheckin) {
        this.evento = evento;
        this.participante = participante;
        this.dataCheckin = dataCheckin;
    }

    // Getters e Setters

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public String getDataCheckin() {
        return dataCheckin;
    }

    public void setDataCheckin(String dataCheckin) {
        this.dataCheckin = dataCheckin;
    }
}
