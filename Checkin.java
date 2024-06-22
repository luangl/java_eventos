public class CheckIn {
    private Participante participante;
    private Evento evento;
    private String dataCheckIn;

    public CheckIn(Participante participante, Evento evento, String dataCheckIn) {
        this.participante = participante;
        this.evento = evento;
        this.dataCheckIn = dataCheckIn;
    }

    public Participante getParticipante() {
        return participante;
    }

    public Evento getEvento() {
        return evento;
    }

    public String getDataCheckIn() {
        return dataCheckIn;
    }
}
