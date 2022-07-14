package fiuba.algo3.tests;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.AgendaRecurso;
import fiuba.algo3.modelo.EventoSemanal;
import fiuba.algo3.modelo.RecursoOcupadoException;

public class AgendaRecursoTests {
	
	@Test
	public void test01crearAgendaRecursoConNombre(){
		AgendaRecurso agenda = new AgendaRecurso("soyUnRecurso");
		
		Assert.assertEquals("soyUnRecurso",agenda.getNombre());
		
	}
	@Test
	public void test02crearAgendaRecursoYAsignarleUnEvento(){
		GregorianCalendar calendario = new GregorianCalendar(2016,1,17,22,0);
		Date fecha = calendario.getTime();
		
		AgendaRecurso agenda = new AgendaRecurso("cheSoyUnaRecurso");
		EventoSemanal evento = new EventoSemanal("soyUnEvento",1,2016,2,17,22,0);
		
		Assert.assertFalse(agenda.estaOcupadoLaFecha(fecha));
		
		agenda.agregarEvento(evento);
		
		Assert.assertTrue(agenda.estaOcupadoLaFecha(fecha));
	}
	@Test(expected=RecursoOcupadoException.class)
	public void test03crearAgendaRecursoYComprobarQueLosEventosNoSePuedenSuperponer(){
		GregorianCalendar calendario = new GregorianCalendar(2016,0,10,10,0);
		Date fecha = calendario.getTime();
		
		AgendaRecurso agenda = new AgendaRecurso("recurso");
		EventoSemanal evento1 = new EventoSemanal("eventoPrimero",1,2016,1,10,10,0);
		EventoSemanal evento2 = new EventoSemanal("yoDoyError",1,2016,1,10,10,0);
		
		Assert.assertFalse(agenda.estaOcupadoLaFecha(fecha));
		
		agenda.agregarEvento(evento1);
		
		Assert.assertTrue(agenda.estaOcupadoLaFecha(fecha));
		
		agenda.agregarEvento(evento2);
	}
}
