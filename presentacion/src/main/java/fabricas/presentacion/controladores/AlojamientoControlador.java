package fabricas.presentacion.controladores;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import fabricas.presentacion.VOs.AlojamientoVO;
import fabricas.presentacion.VOs.ServicioVO;

@Controller
@RequestMapping("/")
public class AlojamientoControlador {

	private static final String VIEW_BUSCAR_ALOJAMIENTO = "indexAlojamiento";
	//private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);

	/**
	 * Controlador de la pantalla de busqueda de alojamiento
	 * @param model
	 * @return
	 */

	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView buscarAlojamiento(ModelMap model) {
		List<ServicioVO> servicios=null;
		ObjectMapper mapper = new ObjectMapper();
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject("http://localhost:8080/logica/alojamiento/", String.class);

		try {
			servicios = mapper.readValue(result, new TypeReference<List<ServicioVO>>(){});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		ModelAndView modelAndView = new ModelAndView(VIEW_BUSCAR_ALOJAMIENTO);
		modelAndView.addObject("servicios", servicios);
        
		
		return modelAndView;
	}

	@RequestMapping(value = "/", method =RequestMethod.POST)
	public ModelAndView buscarAlojamiento(
	        @RequestParam(value="ciudad", required=false) String ciudad, 
	        @RequestParam(value="proveedor", required=false) String proveedor, 
	        @RequestParam(value="fechaEntrada", required=false) String fechaEntrada,
	        @RequestParam(value="fechaSalida", required=false) String fechaSalida,
	        @RequestParam(value="habitaciones", required=false) String habitaciones,
	        @RequestParam(value="personas", required=false) String personas
			) {

		List<ServicioVO> servicios = null;
		ObjectMapper mapper = new ObjectMapper();
		RestTemplate restTemplate = new RestTemplate();
		
		String url="ciudad="+ciudad+",proveedor="+proveedor+",fechaEntrada="+fechaEntrada;
		url = url+",fechaSalida="+fechaSalida+",habitaciones="+habitaciones+",personas="+personas;
		
	
		String result = restTemplate.getForObject("http://localhost:8080/logica/alojamiento/"+url, String.class);

		try {
			servicios = mapper.readValue(result, new TypeReference<List<ServicioVO>>(){});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		ModelAndView modelAndView = new ModelAndView(VIEW_BUSCAR_ALOJAMIENTO);
		modelAndView.addObject("servicios", servicios);
		return modelAndView;

	}
}
