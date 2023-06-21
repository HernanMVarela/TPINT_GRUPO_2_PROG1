package frgp.utn.edu.ar.servicioImpl;

import frgp.utn.edu.ar.dao.PersonaDao;
import frgp.utn.edu.ar.dominio.Persona;
import frgp.utn.edu.ar.servicio.PersonaServicio;

public class PersonaServicioImpl implements PersonaServicio{

	private PersonaDao dataAccess = null;

	public void setDataAccess(PersonaDao dataAccess) {
		this.dataAccess = dataAccess;
	}

	public Persona obtenerUnRegistro(String DNI) {
		return dataAccess.obtenerPersonaPorDNI(DNI);
	}

	@Override
	public boolean insertarPersona(Persona nuevo) {
		return dataAccess.insertarPersona(nuevo);
	}

	@Override
	public void eliminarPersona(String DNI) {
		dataAccess.eliminarPersona(DNI);
	}

	@Override
	public boolean actualizarPersona(Persona modificar) {
		return dataAccess.actualizarPersona(modificar);
	}

}
