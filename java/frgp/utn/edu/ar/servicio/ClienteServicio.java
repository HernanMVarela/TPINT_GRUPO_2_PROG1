package frgp.utn.edu.ar.servicio;

import java.util.ArrayList;

import frgp.utn.edu.ar.dominio.Cliente;

public interface ClienteServicio {

	public ArrayList<Cliente> obtenerClientes();

	public String ingresarCliente(Cliente nuevo);
	
	public void eliminarCliente(int ID) ;
	
	public Cliente obtenerUnRegistro(int ID);

	public boolean actualizarCliente(Cliente modificar);
}
