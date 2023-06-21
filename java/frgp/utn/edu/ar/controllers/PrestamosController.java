package frgp.utn.edu.ar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PrestamosController {

	// ALTA USER | "Prestamos.html"
	@RequestMapping("Prestamos.html")
	public ModelAndView eventoRedireccionarAltaUsuario()
	{
		ModelAndView MV = new ModelAndView();
		
		MV.setViewName("Prestamos");
		return MV;
	}	
}
