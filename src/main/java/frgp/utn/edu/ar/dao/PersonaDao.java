package frgp.utn.edu.ar.dao;

import frgp.utn.edu.ar.dominio.Persona;


public interface PersonaDao {

	//Alta de un articulo
	public boolean insertarPersona(Persona nuevo);

	//Obtiene una articulo por nombre
	public Persona obtenerPersonaPorDNI(long DNI);
	
	//Verifica si existe el articulo
	public boolean existePersona(long DNI);

	//Elimina un articulo a aprtir del nombre
	public void eliminarPersona(long DNI);

	//Actualiza los datos de unaarticulo
	public boolean actualizarPersona(Persona modificar);
	

}
