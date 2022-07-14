package fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class EventoSemanal extends Evento {
	String nombre;
	ArrayList<Date> fechas;

	public EventoSemanal(String nombre, int cantSemanas, int anio, int mes, int dia, int hora, int min) {
		super(nombre);
		this.fechas = new ArrayList<Date>();
		GregorianCalendar calendario = new GregorianCalendar(anio,mes-1,dia,hora,min);
		
		Date fecha = calendario.getTime();
		for(int i=0; i <= cantSemanas-1; i++){
			this.fechas.add(fecha);
			calendario.add((GregorianCalendar.DAY_OF_MONTH), 7);
			fecha = calendario.getTime();
		}
	}
	
	public ArrayList<Date> getFechas() {
		return fechas;
	}

}
