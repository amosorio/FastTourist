package fabricas.presentacion.controladores;

import java.io.IOException;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fabricas.entidades.Servicio;

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
	 * @throws IOException 
	 * @throws RestClientException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@RequestMapping(value = "/get/{id}/", method = RequestMethod.GET)
	public String getProducto(@PathVariable("id")int id, ModelMap model){

		/*
		model.addAttribute("counter", id);
		model.addAttribute("nombre", "Nombre del producto");
		model.addAttribute("proveedor", "nombre del proveedor");
		model.addAttribute("categoria", "nombre de la categoria");
		model.addAttribute("fecha_creacion", "00/00/00");
		model.addAttribute("precio", "0.0");
		model.addAttribute("cantidad_comprados", 2);
		model.addAttribute("descuento", "20%");   
		*/
		ObjectMapper mapper = new ObjectMapper();
		RestTemplate restTemplate = new RestTemplate();
		
		String result = restTemplate.getForObject("http://localhost:8080/logica/producto/1/", String.class);
		
        model.addAttribute("nombre", result.toString());
        
		return PRODUCTO;

	}

}
