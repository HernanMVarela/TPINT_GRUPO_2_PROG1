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
import frgp.utn.edu.ar.servicio.PersonaServicio;
import frgp.utn.edu.ar.servicio.LocalidadServicio;
import frgp.utn.edu.ar.dominio.Cliente;
import frgp.utn.edu.ar.dominio.Persona;
import frgp.utn.edu.ar.servicio.ClienteServicio;
import frgp.utn.edu.ar.servicio.EstadoClienteServicio;
import frgp.utn.edu.ar.servicio.ProvinciaServicio;

@Controller
public class ClientesController {

	@Autowired
	public  PersonaServicio servicePersona;
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
	public  Persona persona;
	
	// NO TOCAR - Servlets
	public void init(ServletConfig config) {
		ApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());
		
		this.servicePersona = (PersonaServicio) ctx.getBean("PersonaServiceBean");
		this.serviceProvincia = (ProvinciaServicio) ctx.getBean("ProvinciaServiceBean");
		this.serviceLocalidad = (LocalidadServicio) ctx.getBean("LocalidadServiceBean");
		this.serviceCliente = (ClienteServicio) ctx.getBean("ClienteServiceBean");
		this.serviceEstadoCliente = (EstadoClienteServicio) ctx.getBean("EstadoClienteServiceBean");
		this.cliente = (Cliente) ctx.getBean("ClienteEstandar");
		this.persona = (Persona) ctx.getBean("PersonaEstandar");
	}	
		
	/// AMBL CLIENTES | "Clientes.html"
	@RequestMapping("Clientes.html")
	public ModelAndView eventoRedireccionarArticulos()
	{
		ModelAndView MV = new ModelAndView();
		MV = cargadorDeListasClientes(MV);
		MV.setViewName("Clientes");
		return MV;
	}
	
	// ALTA DE NUEVO CLIENTE | "/alta_cliente.html"
	@RequestMapping(value ="/alta_cliente.html" , method= { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView validarCliente(String DNI, String nombre, String apellido, String correo, Date fecha_nac, String telefono, 
										String nacionalidad, int localidad, String direccion, String codpostal){
		
		ModelAndView MV = new ModelAndView();
		
		persona.setDNI(DNI);
		persona.setNombre(nombre);
		persona.setApellido(apellido);
		persona.setCorreo(correo);
		persona.setFecha_nac(fecha_nac);
		persona.setTelefono(telefono);
		
		cliente.setPersona(persona);
		cliente.setNacionalidad(nacionalidad);
		cliente.setLocalidad(serviceLocalidad.obtenerUnRegistro(localidad));
		cliente.setDireccion(direccion);
		cliente.setCodpostal(codpostal);
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
	public ModelAndView modificarCliente(int ID, String correo, String telefono, int localidad, String direccion, String codpostal, int id_estado){
		
		ModelAndView MV = new ModelAndView();
		
		persona.setCorreo(correo);
		persona.setTelefono(telefono);
		
		cliente.setID(ID);
		cliente.setPersona(persona);
		cliente.setLocalidad(serviceLocalidad.obtenerUnRegistro(localidad));
		cliente.setDireccion(direccion);
		cliente.setCodpostal(codpostal);
		cliente.setEstado(serviceEstadoCliente.obtenerUnRegistro(id_estado));
	
		String Message="";
		
		try{
			if( serviceCliente.actualizarCliente(cliente)) {
				Message = "Modificado";
			}else {
				Message = "No Modificado";
			}
			MV.addObject("Mensaje", Message);
			MV = cargadorDeListasClientes(MV);
			MV.setViewName("vendedor/Articulos"); 
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
		ModelAndView MV = new ModelAndView();
		
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
			MV.setViewName("vendedor/Articulos"); 
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
		return MV;
	}
	
}
