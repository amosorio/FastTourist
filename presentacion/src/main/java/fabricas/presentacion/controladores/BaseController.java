package fabricas.presentacion.controladores;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BaseController {

	private static int counter = 0;
	private static final String VIEW_INDEX = "index";
	private static final String VER_PAQUETE = "verPaquete";
	private static final String CONTACTENOS = "contactenos";
	private static final String REGISTRO = "registro";
	private static final String CARRITO = "carrito";	
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		return VIEW_INDEX;

	}
	/**
	 * Controlador de la pantalla Contactenos
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/contactenos", method = RequestMethod.GET)
	public String contactenos(ModelMap model) {
		return CONTACTENOS;
	}
	
	/**
	 * Controlador de la pantalla de Registro
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/registro", method = RequestMethod.GET)
	public String registrarse(ModelMap model) {
		return REGISTRO;

	}
	
	/**
	 * Controlador de la pantalla de el carrito de compras
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/carrito", method = RequestMethod.GET)
	public String verCarrito(ModelMap model) {
		return CARRITO;

	}
	/**
	 * Controlador de la pantalla de ver informacion detallada del servicio o paquete
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/verPaquete/{id}/", method = RequestMethod.GET)
	public String getPaquete(@PathVariable("id")int id, ModelMap model) {

		model.addAttribute("counter", id);
		model.addAttribute("nombre", "nombre del producto");
		model.addAttribute("proveedor", "nombre del proveedor");
		model.addAttribute("categoria", "nombre de la categoria");
		model.addAttribute("fecha_creacion", "00/00/00");
		model.addAttribute("precio", "0.0");
		model.addAttribute("cantidad_comprados", 2);
		model.addAttribute("descuento", "20%");
		logger.debug("[welcomeName] counter : {}", counter);
        
		return VER_PAQUETE;

	}

}