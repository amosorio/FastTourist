package fabricas.presentacion.controladores;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fabricas.entidades.Paquete;
import fabricas.entidades.Servicio;

@Controller
public class PaqueteControlador {
	
	@RequestMapping(value = "/paquete", method = RequestMethod.GET)
	public ModelAndView getPackages(){
		ModelAndView model = new ModelAndView();
		Paquete paq = new Paquete();
		paq.setDescripcion("Desc paquete1");
		paq.setFechaCreacion(new Date("2016-02-10"));
		paq.setNombre("Paquete1");
		Servicio servicio = new Servicio();
		servicio.setPrecio(new BigDecimal(1000));
		paq.setServicios(Arrays.asList(servicio));
		
		model.addObject(paq);
		return model;
	}

	@RequestMapping(value = "/categtoria", method = RequestMethod.GET)
	public ModelAndView getCategories(){
		ModelAndView model = new ModelAndView();
		
		return model;
	}
}
