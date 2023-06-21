package frgp.utn.edu.ar.servicio;

import frgp.utn.edu.ar.dominio.Persona;

public interface PersonaServicio {

	public Persona obtenerUnRegistro(long DNI);

	public boolean insertarPersona(Persona nuevo);

	public void eliminarPersona(long DNI) ;

	public boolean actualizarPersona(Persona modificar);
	
}
