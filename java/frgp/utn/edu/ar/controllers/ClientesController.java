package frgp.utn.edu.ar.controllers;

import java.sql.Date;

import javax.servlet.ServletConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import frgp.utn.edu.ar.servicio.LocalidadServicio;
import frgp.utn.edu.ar.dominio.Cliente;
import frgp.utn.edu.ar.servicio.ClienteServicio;
import frgp.utn.edu.ar.servicio.EstadoClienteServicio;
import frgp.utn.edu.ar.servicio.ProvinciaServicio;

@Controller
public class ClientesController {

	@Autowired
	public  ProvinciaServicio serviceProvincia;
	@Autowired
	public  LocalidadServicio serviceLocalidad;
	@Autowired
	public  EstadoClienteServicio serviceEstadoCliente;
	@Autowired
	public  ClienteServicio serviceCliente;
	
	@Autowired
	public  Cliente cliente;
	@Autowired
	private ModelAndView MV;

	// NO TOCAR - Servlets
	public void init(ServletConfig config) {
		ApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());
		
		this.serviceProvincia = (ProvinciaServicio) ctx.getBean("ProvinciaServiceBean");
		this.serviceLocalidad = (LocalidadServicio) ctx.getBean("LocalidadServiceBean");
		this.serviceCliente = (ClienteServicio) ctx.getBean("ClienteServiceBean");
		this.serviceEstadoCliente = (EstadoClienteServicio) ctx.getBean("EstadoClienteServiceBean");
		this.cliente = (Cliente) ctx.getBean("ClienteEstandar");
		this.MV = (ModelAndView) ctx.getBean("ModelAndViewBean");
	}	
		
	/// AMBL CLIENTES | "Clientes.html"
	@RequestMapping("Clientes.html")
	public ModelAndView eventoRedireccionarArticulos()
	{
		MV = cargadorDeListasClientes(MV);
		MV.setViewName("Clientes");
		return MV;
	}
	
	// ALTA DE NUEVO CLIENTE | "/alta_cliente.html"
	@RequestMapping(value ="/alta_cliente.html" , method= { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView validarCliente(String DNINuevo, String nomNuevo, String apeNuevo, String corNuevo, Date fechaNuevo, 
									   String telNuevo, String nacioNuevo, int localidadNuevo, String direcNuevo, String codPostalNuevo){
				
		cliente.setDNI(DNINuevo);
		cliente.setNombre(nomNuevo);
		cliente.setApellido(apeNuevo);
		cliente.setCorreo(corNuevo);
		cliente.setFecha_nac(fechaNuevo);
		cliente.setTelefono(telNuevo);
		
		cliente.setNacionalidad(nacioNuevo);
		cliente.setLocalidad(serviceLocalidad.obtenerUnRegistro(localidadNuevo));
		cliente.setDireccion(direcNuevo);
		cliente.setCodpostal(codPostalNuevo);
		cliente.setEstado(serviceEstadoCliente.obtenerUnRegistro(1));

		String Message = "";
		try{
			Message = asignarMensajeClientes(serviceCliente.ingresarCliente(cliente));
			
			MV.addObject("Mensaje", Message);
			MV = cargadorDeListasClientes(MV);
			MV.setViewName("Clientes"); 
			return MV;
		}
		catch(Exception e)
		{
			/// REEMPLAZAR POR DIRECCIONAMIENTO A PAGINA DE ERROR
			Message = e.toString();
			System.out.println(e.toString());
			MV.addObject("Mensaje", Message);
			MV.setViewName("Error"); 
			return MV;
		}

	}
	
	// MODIFICAR CLIENTE | "/modificar_cliente.html"
	@RequestMapping(value ="/modificar_cliente.html" , method= { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView modificarCliente(int ID, String correoModif, String telefonoModif, int LocalidadModif, String direcModif, String codpostalModif){
		
		cliente.setCorreo(correoModif);
		cliente.setTelefono(telefonoModif);
		
		cliente.setID(ID);
		cliente.setLocalidad(serviceLocalidad.obtenerUnRegistro(LocalidadModif));
		cliente.setDireccion(direcModif);
		cliente.setCodpostal(codpostalModif);
		cliente.setEstado(serviceEstadoCliente.obtenerUnRegistro(1));
	
		String Message="";
		
		try{
			if( serviceCliente.actualizarCliente(cliente)) {
				Message = "Modificado";
			}else {
				Message = "No Modificado";
			}
			MV.addObject("Mensaje", Message);
			MV = cargadorDeListasClientes(MV);
			MV.setViewName("Clientes"); 
			return MV;
		}
		catch(Exception e)
		{
			Message = e.toString();
			System.out.println(e.toString());
			MV.addObject("Mensaje", Message);
			MV.setViewName("Error"); 
			return MV;
		}	
	}
	
	// ELIMINAR CLIENTE | "/eliminar_cliente.html"
	@RequestMapping(value ="/eliminar_cliente.html" , method= { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView eliminarCliente(int ID){
		
		Cliente x = serviceCliente.obtenerUnRegistro(ID);
	
		String Message="";
		
		try{
			
			if( serviceCliente.actualizarCliente(x)) {
				Message = "Eliminado";
			}else {
				Message = "No Eliminado";
			}
			MV.addObject("Mensaje", Message);
			MV = cargadorDeListasClientes(MV);
			MV.setViewName("Clientes"); 
			return MV;
		}
		catch(Exception e)
		{
			Message = e.toString();
			System.out.println(e.toString());
			MV.addObject("Mensaje", Message);
			MV.setViewName("Error"); 
			return MV;
		}	
	}
	
	/// METODOS COMUNES
	private String asignarMensajeClientes(String error) {
		if (error.equals("AGREGADO")) {
			return "Cliente agregado";
		}
		if (error.equals("MODIFICADO")) {
			return "El Cliente fue modificado";
		}
		if (error.equals("NO MODIFICADO")) {
			return "El Cliente no fue modificado";
		}
		if (error.equals("ACTIVADO")) {
			return "Cliente re-activado";
		}
		if (error.equals("NO AGREGADO")) {
			return "Cliente no agregado";
		}
		if (error.equals("ELIMINADO")) {
			return "Cliente eliminado";
		}
		if (error.equals("NO ELIMINADO")) {
			return "Cliente no fue eliminado";
		}
		if (error.equals("EXISTE")) {
			return "El Cliente ya existe";
		}
		if (error.equals("ERROR")) {
			return "REDIRECCIONAR A ERROR";
		}
		return "ERROR";
	}
	
	private ModelAndView cargadorDeListasClientes(ModelAndView MV) 
	{
		MV.addObject("listaClientes",this.serviceCliente.obtenerClientes());
		MV.addObject("listaLocalidades",this.serviceLocalidad.obtenerLocalidades());
		MV.addObject("listaProvincias",this.serviceProvincia.obtenerProvincias());
		return MV;
	}
	
}
