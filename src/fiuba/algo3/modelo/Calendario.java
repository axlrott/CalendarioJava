package fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

public class Calendario {
	private HashMap<String,Agenda> agendas;
	private ArrayList<String> listaPersonas;
	private ArrayList<String> listaRecursos;
	
	public Calendario(){
		this.agendas = new HashMap<String,Agenda>();
		this.listaPersonas = new ArrayList<String>();
		this.listaRecursos = new ArrayList<String>();
	}
	
	private void agregarAAgenda(String nombre,Agenda agenda){
		try{
			this.getAgenda(nombre);
			throw new NombreYaExistenteException();
		}
		catch(AgendaInexistenteException e){
			this.agendas.put(nombre, agenda);
		}
	}
	public void agregarPersona(String nombre){
		AgendaPersona persona = new AgendaPersona(nombre);
		this.agregarAAgenda(nombre,persona);
		this.listaPersonas.add(nombre);
	}
	public void agregarRecurso(String nombre){
		AgendaRecurso recurso = new AgendaRecurso(nombre);
		this.agregarAAgenda(nombre, recurso);
		this.listaRecursos.add(nombre);
	}
	private Agenda getAgenda(String nombre){
		try{
			Agenda agenda = this.agendas.get(nombre);
			agenda.getNombre();
			return agenda;
		}
		catch (NullPointerException e){
			throw new AgendaInexistenteException();
		}
	}
	public boolean existePersona(String nombre){
		boolean existePersona = this.listaPersonas.contains(nombre);
		return existePersona;
	}
	public boolean existeRecurso(String nombre){
		boolean existeRecurso = this.listaRecursos.contains(nombre);
		return existeRecurso;
	}
	private void comprobarExistenciaDeAgendas(List<String> listaNombres){
		for(int i=0;i <= listaNombres.size()-1; i++){
			String nombreAgenda = listaNombres.get(i);
			this.getAgenda(nombreAgenda);
		}
	}
	public boolean estaOcupado(String nombre, int anio, int mes, int dia, int hora){
		int min = 0;
		Agenda agenda = this.getAgenda(nombre);
		GregorianCalendar calendario = new GregorianCalendar(anio,mes-1,dia,hora,min);
		Date fecha = calendario.getTime();
		return agenda.estaOcupadoLaFecha(fecha);
		
	}
	public void agregarEvento(String nombreEvento, List<String> invitados, int anio, int mes, int dia, int hora){
		int cantSemanas = 1;
		agregarEventoSemanal(nombreEvento,cantSemanas,invitados,anio,mes,dia,hora);

	}
	public void agregarEventoSemanal(String nombreEvento,int cantSemanas, List<String> invitados, int anio, int mes, int dia, int hora){
		int min = 0;
		boolean flagDeError = false;
		this.comprobarExistenciaDeAgendas(invitados);
		int cantInvitados = invitados.size();
		for(int i = 0; i <= cantInvitados-1; i++){
			Agenda agenda = this.getAgenda(invitados.get(i));
			Evento evento = new EventoSemanal(nombreEvento,cantSemanas,anio,mes,dia,hora,min);
			try{
				agenda.agregarEvento(evento);
			}
			catch(RecursoOcupadoException e){
				flagDeError = true;
				continue;
			}
		}
		if(flagDeError)
			throw new RecursoOcupadoException();
	}
}
