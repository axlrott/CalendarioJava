package fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Date;

abstract class Evento {
	String nombreDelEvento;
	ArrayList<Date> fechas;
	
	protected Evento(String nombre){
		this.nombreDelEvento = nombre;
	}
	
	public String getNombre(){
		return (this.nombreDelEvento);
	}
	
	abstract ArrayList<Date> getFechas();

}
