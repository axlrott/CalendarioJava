package fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Date;

public class AgendaRecurso extends Agenda {
	public AgendaRecurso(String nombre){
		super(nombre);
	}
	
	@Override
	public void agregarEvento(Evento unEvento){
		ArrayList<Date> listaFechas = unEvento.getFechas();
		int cantidadFechas = listaFechas.size();
		for(int i=0; i <= cantidadFechas-1; i++){
			Date fecha = listaFechas.get(i);
			boolean estaOcupado = this.estaOcupadoLaFecha(fecha);
			if (estaOcupado)
				throw new RecursoOcupadoException();
		this.eventosAAsistir.add(unEvento);
		}
	}
}
