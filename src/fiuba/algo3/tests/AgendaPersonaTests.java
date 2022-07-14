package fiuba.algo3.tests;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.AgendaPersona;
import fiuba.algo3.modelo.EventoSemanal;

public class AgendaPersonaTests {
	
	@Test
	public void test01crearUnaAgendaPersonaConNombre(){
		AgendaPersona agenda = new AgendaPersona("Martin");
		
		Assert.assertEquals("Martin", agenda.getNombre());
	}
	
	@Test
	public void test02crearAgendaPersonaYAsignarleUnEvento(){
		GregorianCalendar calendario = new GregorianCalendar(2016,0,21,12,0);
		Date fecha = calendario.getTime();
		
		EventoSemanal evento = new EventoSemanal("Evento",1,2016,1,21,12,0);
		AgendaPersona agenda = new AgendaPersona("Prototipo");
		
		Assert.assertFalse(agenda.estaOcupadoLaFecha(fecha));
		
		agenda.agregarEvento(evento);
		
		Assert.assertTrue(agenda.estaOcupadoLaFecha(fecha));
	}
	
	@Test
	public void test03crearAgendaPersonaYSuperponerEventos(){
		GregorianCalendar calendario = new GregorianCalendar(2016,0,21,12,0);
		Date fecha = calendario.getTime();
		
		EventoSemanal evento1 = new EventoSemanal("unEvento",1,2016,1,21,12,0);
		EventoSemanal evento2 = new EventoSemanal("otroEvento",1,2016,1,21,12,0);
		AgendaPersona agenda = new AgendaPersona("holaSoyUnaAgenda");
		
		Assert.assertFalse(agenda.estaOcupadoLaFecha(fecha));
		
		agenda.agregarEvento(evento1);
		
		Assert.assertTrue(agenda.estaOcupadoLaFecha(fecha));
		
		agenda.agregarEvento(evento2);
		
		Assert.assertTrue(agenda.estaOcupadoLaFecha(fecha));
	}
}
