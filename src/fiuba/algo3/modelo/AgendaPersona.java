package fiuba.algo3.modelo;

public class AgendaPersona extends Agenda {
	public AgendaPersona(String nombre) {
		super(nombre);
	}

	@Override
	public void agregarEvento(Evento evento){
		this.eventosAAsistir.add(evento);
	}
}
