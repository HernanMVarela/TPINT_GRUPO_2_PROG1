package frgp.utn.edu.ar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	//Home | "Home.html"
	@RequestMapping("Home.html")
	public ModelAndView redireccion(){
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Home"); 
		return MV;
	}	
}
