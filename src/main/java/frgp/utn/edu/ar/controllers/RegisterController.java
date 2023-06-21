package frgp.utn.edu.ar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {

	// ALTA USER | "registro-usuario.html"
	@RequestMapping("registro-usuario.html")
	public ModelAndView eventoRedireccionarAltaUsuario()
	{
		ModelAndView MV = new ModelAndView();
		
		MV.setViewName("RegistroUsuario");
		return MV;
	}	
}
