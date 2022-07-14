package fiuba.algo3.tests;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.EventoSemanal;

public class EventoSemanalTests {
	
	@Test
	public void test01CrearEventoSemanal(){
		ArrayList<Date> fechaEsperada = new ArrayList<Date>();
		GregorianCalendar calendario = new GregorianCalendar(2016,0,21,12,0);
		Date fecha = calendario.getTime();
		fechaEsperada.add(fecha);
		calendario = new GregorianCalendar(2016,0,28,12,0);
		fecha = calendario.getTime();
		fechaEsperada.add(fecha);
		calendario = new GregorianCalendar(2016,1,4,12,0);
		fecha = calendario.getTime();
		fechaEsperada.add(fecha);
		
		EventoSemanal evento = new EventoSemanal("Prueba",3,2016,1,21,12,0);
		ArrayList<Date> listaFechas = evento.getFechas();
		Assert.assertEquals(listaFechas, fechaEsperada);
	}
	
	@Test
	public void test02CrearEventoSemanalConNombre(){
		EventoSemanal evento = new EventoSemanal("EventoSemanal",2,2016,2,17,12,0);
		Assert.assertEquals(evento.getNombre(),"EventoSemanal");
	}

}
