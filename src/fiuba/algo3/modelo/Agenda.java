package fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Date;

abstract class Agenda {
	protected String nombre;
	protected ArrayList<Evento> eventosAAsistir;
	
	protected Agenda(String nombre){
		this.nombre = nombre;
		this.eventosAAsistir = new ArrayList<Evento>();
	}
	public String getNombre(){
		return this.nombre;
	}
	
	abstract void agregarEvento(Evento evento);
	
	public boolean estaOcupadoLaFecha(Date unaFecha){
		boolean estaLibre = true;
		for(int i=0; i<= this.eventosAAsistir.size()-1; i++){
			Evento evento = this.eventosAAsistir.get(i);
			ArrayList<Date> listaFechas = evento.getFechas();
			int cantFechas = listaFechas.size();
			for (int j=0; j <= cantFechas-1; j++){
				Date fecha = listaFechas.get(j);
				estaLibre = estaLibre & !(fecha.equals(unaFecha));
			}
		}
		boolean estaOcupado = !estaLibre;
		return estaOcupado;
	}
	
}
