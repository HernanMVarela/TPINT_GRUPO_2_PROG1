package frgp.utn.edu.ar.dao;

import java.util.ArrayList;

import frgp.utn.edu.ar.dominio.Cliente;

public interface ClienteDao {
	
	//Obtiene todos los elementos en Stock
	public ArrayList<Cliente> obtenerClientes();
	
	//Agrega Stock
	public boolean insertarCliente(Cliente nuevo);
	
	//Obtiene una articulo por nombre
	public Cliente obtenerClientePorID(int ID);
	
	//Verifica si existe el articulo
	public boolean existeCliente(int ID);

	//Elimina un articulo a aprtir del nombre
	public void eliminarCliente(int ID);

	//Actualiza los datos de unaarticulo
	public boolean actualizarCliente(Cliente modificar);

}
