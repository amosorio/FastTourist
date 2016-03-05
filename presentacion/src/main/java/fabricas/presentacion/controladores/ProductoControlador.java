package fabricas.presentacion.controladores;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/producto")
public class ProductoControlador {
	
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);
	private static final String PRODUCTO = "producto";
	
	/**
	 * Controlador de la pantalla de ver informacion detallada del producto o servicio
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/get/{id}/", method = RequestMethod.GET)
	public String getProducto(@PathVariable("id")int id, ModelMap model) {

		model.addAttribute("counter", id);
		model.addAttribute("nombre", "Nombre del producto");
		model.addAttribute("proveedor", "nombre del proveedor");
		model.addAttribute("categoria", "nombre de la categoria");
		model.addAttribute("fecha_creacion", "00/00/00");
		model.addAttribute("precio", "0.0");
		model.addAttribute("cantidad_comprados", 2);
		model.addAttribute("descuento", "20%");        
		return PRODUCTO;

	}

}
