package fiuba.algo3.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.Calendario;
import fiuba.algo3.modelo.NombreYaExistenteException;
import fiuba.algo3.modelo.RecursoOcupadoException;

public class CalendarioOtrosTests {
	
	@Test(expected=NombreYaExistenteException.class)
	public void test01agregarPersonasConMismoNombreDebeDevolverError(){
		String nombre1 = "Martin";
		String nombre2 = "Martin";
		Calendario calendario = new Calendario();
		
		calendario.agregarPersona(nombre1);
		calendario.agregarPersona(nombre2);
	}
	
	@Test(expected=NombreYaExistenteException.class)
	public void test02agregarRecursoConMismoNombreDebeDevolverError(){
		String nombre1 = "Martillo";
		String nombre2 = "Martillo";
		Calendario calendario = new Calendario();
		
		calendario.agregarRecurso(nombre1);
		calendario.agregarRecurso(nombre2);
	}
	
	@Test(expected=NombreYaExistenteException.class)
	public void test03agregarPersonaYRecursoDeMismoNombreDebeDevolverError(){
		String nombre1 = "Marcador";
		String nombre2 = "Marcador";
		Calendario calendario = new Calendario();
		
		calendario.agregarPersona(nombre1);
		calendario.agregarRecurso(nombre2);
	}
	
	@Test
	public void test04agregarEventoConRecursoOcupadoDaErrorPeroLasDemasAgendasContienenElEvento(){
		Calendario calendario = new Calendario();
		
		String persona1 = "Charles Manson";
		String recurso1 = "AK47";
		String recurso2 = "Perro";
		String persona2 = "Varg Vikernes";
		
		calendario.agregarPersona(persona1);
		calendario.agregarPersona(persona2);
		calendario.agregarRecurso(recurso1);
		calendario.agregarRecurso(recurso2);
		
		List<String> invitados = new ArrayList<>();
		List<String> listaRecurso = new ArrayList<>();
		invitados.add(persona1);
		invitados.add(recurso1);
		listaRecurso.add(recurso1);
		invitados.add(recurso2);
		invitados.add(persona2);
		
		calendario.agregarEvento("evento1", listaRecurso, 2016, 12, 14, 12);
		Assert.assertTrue(calendario.estaOcupado(recurso1, 2016, 12, 14, 12));
		
		try{
			calendario.agregarEvento("evento2", invitados, 2016,12, 14, 12);
			Assert.assertTrue(false);
		}
		catch(RecursoOcupadoException e){
			Assert.assertTrue(calendario.estaOcupado(persona1, 2016, 12, 14, 12));
			Assert.assertTrue(calendario.estaOcupado(recurso2, 2016, 12, 14, 12));
			Assert.assertTrue(calendario.estaOcupado(persona2, 2016, 12, 14, 12));
		}
		
	}
}
