package fabricas.presentacion.controladores;

import java.io.IOException;
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

import fabricas.presentacion.VOs.CalificacionesVO;
import fabricas.presentacion.VOs.ServicioVO;

@Controller
@RequestMapping("/transporte")
public class TransporteControlador {

	private static final String VIEW_BUSCAR_TRANSPORTE = "indexTransporte";
	private static final String VIEW_VER_TRANSPORTE= "verTransporte";


	/**
	 * Controlador de la pantalla de busqueda de transporte
	 * Metodo GET
	 * @param model
	 * @return
	 */

	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView buscarTransporte(ModelMap model) {
		ModelAndView modelAndView = new ModelAndView(VIEW_BUSCAR_TRANSPORTE);
		return modelAndView;
	}
	/**
	 * Controlador de la pantalla de ver informacion detallada de servicio de transporte
	 * @param id
	 * @param model
	 * @return
	 * @throws IOException 
	 * @throws RestClientException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@RequestMapping(value = "/getTransporte/{id}/", method = RequestMethod.GET)
	public ModelAndView getTransporte(@PathVariable("id")int id, ModelMap model){

		ServicioVO servicio=null;
		ObjectMapper mapper = new ObjectMapper();
		RestTemplate restTemplate = new RestTemplate();

		String result = restTemplate.getForObject("http://localhost:8080/logica/transporte/get/" + id, String.class);
		try {
			servicio = mapper.readValue(result, ServicioVO.class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		//Calculan las estrellas de calificacion
		int promCalificacion = 0;
		int cont = 0;
		for (CalificacionesVO calificacion : servicio.getCalificaciones()) {
			cont++;
			promCalificacion = promCalificacion + calificacion.getValor();
		}


		//Se envian los objetos a la pantalla
		ModelAndView modelAndView = new ModelAndView(VIEW_VER_TRANSPORTE);
		modelAndView.addObject("servicio", servicio);
		if(cont >0){
			promCalificacion = (int) Math.ceil(promCalificacion/cont);
			modelAndView.addObject("promCalificacion", promCalificacion);
		}

		return modelAndView;

	}
}
