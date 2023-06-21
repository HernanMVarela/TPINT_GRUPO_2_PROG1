package frgp.utn.edu.ar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommonController {

	// "/common/header"
    @RequestMapping("/common/header.html")
    public String showHeader() {

        return "common/Header.jspf";
    }
	
    // "cssStyles/StyleSheet"
    @RequestMapping("/cssStyles/StyleSheet.html")
	public String getStyleSheet() {
 
        return "cssStyles/StyleSheet.Css";
    }
    
	//NAVBARS
    @RequestMapping("/common/NavigatorCommon.jspf")
    public String getNavigatorCommon() {
   
        return "common/NavigatorCommon";
    }
	
	// Logout | "Logout.html"
    @RequestMapping("Logout.html")
    public ModelAndView getLogout() {
    	ModelAndView MV = new ModelAndView();
		MV.setViewName("Home"); 
		return MV;
    }
}
