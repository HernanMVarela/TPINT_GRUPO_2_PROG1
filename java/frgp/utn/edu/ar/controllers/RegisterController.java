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
import frgp.utn.edu.ar.dominio.Usuario;
import frgp.utn.edu.ar.servicio.ClienteServicio;
import frgp.utn.edu.ar.servicio.EstadoClienteServicio;
import frgp.utn.edu.ar.servicio.EstadoUsuarioServicio;
import frgp.utn.edu.ar.servicio.ProvinciaServicio;
import frgp.utn.edu.ar.servicio.TipoUsuarioServicio;
import frgp.utn.edu.ar.servicio.UsuarioServicio;

@Controller
public class RegisterController {
	
	@Autowired
	private TipoUsuarioServicio serviceTipoUsuario;
	@Autowired
	private EstadoUsuarioServicio serviceEstadoUsuario;
	@Autowired
	private UsuarioServicio serviceUsuario;
	
	@Autowired
	private Usuario usuario;
	
	@Autowired
	private ModelAndView MV;

	// NO TOCAR - Servlets
	public void init(ServletConfig config) {
		ApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());
		
		this.serviceUsuario = (UsuarioServicio) ctx.getBean("UsuarioServiceBean");
		this.serviceTipoUsuario = (TipoUsuarioServicio) ctx.getBean("TipoUsuarioServiceBean");
		this.serviceEstadoUsuario = (EstadoUsuarioServicio) ctx.getBean("EstadoUsuarioServiceBean");
		
		this.usuario = (Usuario) ctx.getBean("UsuarioEstandar");
		this.MV = (ModelAndView) ctx.getBean("ModelAndViewBean");
	}	

	// ALTA USER | "Register.html"
	@RequestMapping("Register.html")
	public ModelAndView eventoRedireccionarAltaUsuario()
	{
		MV.setViewName("RegistroUsuario");
		return MV;
	}
	
	//Ingreso de Usuario | "/alta_usuario.html"
	@RequestMapping(value ="/alta_usuario.html" , method= { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView validarUsuario(String nombre, 
									   String apellido, 
									   String dni, 
									   Date fechaNacimiento,
									   String correo, 
									   String telefono, 
									   String user,
									   String pass,
									   String pass2,
									   int rol){
		String Message = "";
		
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setDNI(dni);
		usuario.setCorreo(correo);
		usuario.setTelefono(telefono);
		usuario.setFecha_nac(fechaNacimiento);
		usuario.setNombreU(user);
		usuario.setPassU(pass);	
		usuario.setTipo(serviceTipoUsuario.obtenerUnRegistro(rol));
		usuario.setEstado(serviceEstadoUsuario.obtenerUnRegistro(1));
		
		
		try{
			if(!validar_datos(user, pass, pass2)) {
				Message = "El usuario ya existe o las contraseñas no coinciden";
				MV.addObject("Mensaje", Message);
				MV.setViewName("Home"); 
				return MV;
			} else {
				Message = asignarMensajeUsuario(serviceUsuario.insertarUsuario(usuario));
				MV.addObject("Mensaje", Message);
				MV.setViewName("Home"); 
				return MV;
			}
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
	
	private String asignarMensajeUsuario(String error) {
		if (error.equals("AGREGADO")) {
			return "Usuario agregado";
		}
		if (error.equals("NO AGREGADO")) {
			return "Usuario no agregado";
		}
		if (error.equals("ERROR")) {
			return "ERROR";
		}
		return "ERROR";
	}
	
	private boolean validar_datos(String user, String pass, String pass2) {

		if(!pass.equals(pass2)) {
			return false;
		}
		
		if (serviceUsuario.existeUsuario(user)) {
			return false;
		}
		
		return true;
	}
	
}
