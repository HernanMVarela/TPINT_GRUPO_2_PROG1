package frgp.utn.edu.ar.servicioImpl;

import java.util.ArrayList;

import frgp.utn.edu.ar.dao.ClienteDao;
import frgp.utn.edu.ar.dominio.Cliente;
import frgp.utn.edu.ar.servicio.ClienteServicio;

public class ClienteServicioImpl implements ClienteServicio{

	private ClienteDao dataAccess = null;

	public void setDataAccess(ClienteDao dataAccess) {
		this.dataAccess = dataAccess;
	}
	
	@Override
	public ArrayList<Cliente> obtenerClientes() {
		return dataAccess.obtenerClientes();
	}
	
	@Override
	public String ingresarCliente(Cliente nuevo) 
	{
		if (dataAccess.insertarCliente(nuevo)) 
		{
			return "AGREGADO";
		} 
		else 
		{
			return "NO AGREGADO";
		}
	}

	@Override
	public void eliminarCliente(int ID) {
		dataAccess.eliminarCliente(ID);
	}

	@Override
	public boolean actualizarCliente(Cliente modificar) {
		return dataAccess.actualizarCliente(modificar);
	}

	@Override
	public Cliente obtenerUnRegistro(int ID) {
		return dataAccess.obtenerClientePorID(ID);
	}

}
