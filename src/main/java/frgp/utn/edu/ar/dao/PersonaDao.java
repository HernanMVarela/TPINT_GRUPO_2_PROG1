package frgp.utn.edu.ar.dao;

import frgp.utn.edu.ar.dominio.Persona;


public interface PersonaDao {

	//Alta de un articulo
	public boolean insertarPersona(Persona nuevo);

	//Obtiene una articulo por nombre
	public Persona obtenerPersonaPorDNI(String DNI);
	
	//Verifica si existe el articulo
	public boolean existePersona(String DNI);

	//Elimina un articulo a aprtir del nombre
	public void eliminarPersona(String DNI);

	//Actualiza los datos de unaarticulo
	public boolean actualizarPersona(Persona modificar);
	

}
