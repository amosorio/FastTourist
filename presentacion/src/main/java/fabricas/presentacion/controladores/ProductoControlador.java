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
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fabricas.presentacion.VOs.ServicioVO;

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
	public ModelAndView getProducto(@PathVariable("id")int id, ModelMap model){

		ServicioVO servicio=null;
		ObjectMapper mapper = new ObjectMapper();
		RestTemplate restTemplate = new RestTemplate();
		
		String result = restTemplate.getForObject("http://localhost:8080/logica/producto/1/", String.class);
		try {
			servicio = mapper.readValue(result, ServicioVO.class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		ModelAndView modelAndView = new ModelAndView(PRODUCTO);
		modelAndView.addObject("servicio", servicio);
        
		return modelAndView;

	}

}
