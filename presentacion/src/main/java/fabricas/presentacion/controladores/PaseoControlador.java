package fabricas.presentacion.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import fabricas.presentacion.VOs.CalificacionesVO;
import fabricas.presentacion.VOs.ServicioVO;

@Controller
@RequestMapping("/paseo")
public class PaseoControlador {

	private static final String VIEW_BUSCAR_PASEO = "indexPaseo";
	private static final String VIEW_VER_PASEO = "verPaseo";

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView buscarPaseo(ModelMap model) {
		ModelAndView modelAndView = new ModelAndView(VIEW_BUSCAR_PASEO);
		return modelAndView;
	}

	/**
	 * Controlador de la pantalla de ver informacion detallada de servicio de
	 * paseo ecologico *
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getPaseo/{id}/", method = RequestMethod.GET)
	public ModelAndView getPaseo(@PathVariable("id") int id, ModelMap model) {

		ServicioVO servicio = null;
		ObjectMapper mapper = new ObjectMapper();
		RestTemplate restTemplate = new RestTemplate();

		String result = restTemplate.getForObject(
				"http://localhost:8080/logica/paseo/get/" + id, String.class);
		try {
			servicio = mapper.readValue(result, ServicioVO.class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Calculan las estrellas de calificacion
		int promCalificacion = 0;
		int cont = 0;
		for (CalificacionesVO calificacion : servicio.getCalificaciones()) {
			cont++;
			promCalificacion = promCalificacion + calificacion.getValor();
		}

		// Se envian los objetos a la pantalla
		ModelAndView modelAndView = new ModelAndView(VIEW_VER_PASEO);
		modelAndView.addObject("servicio", servicio);
		if (cont > 0) {
			promCalificacion = (int) Math.ceil(promCalificacion / cont);
			modelAndView.addObject("promCalificacion", promCalificacion);
		}
		
		//Se debe revisar si hay usuario autenticado y tiene ha comprado el producto para habilitar el boton calificar
		//Por ahora se quema que si
		//TODO
		String permisos = "ok";
		modelAndView.addObject("permisos", permisos);

		return modelAndView;

	}

	/**
	 * Controlador de la pantalla de ver informacion detallada de servicio de
	 * paseo ecologico *
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getPaseo/{id}/", method = RequestMethod.POST)
	public ModelAndView getPaseo(
			@PathVariable("id")int id,
			@RequestParam(value="inputPregunta", required=false) String pregunta,
			@RequestParam(value="inputComentario", required=false) String inputComentario,
			@RequestParam(value="valor", required=false) String valor){
		
		RestTemplate restTemplate = new RestTemplate();
		String result = "";
		
		//TODO:Recuperar el id del usuario autenticado
				//Temporal se carga por defecto Pedro Perez
		int idUsuario =4;
		
		//Se almacena la pregunta relacionada al servicio
		if(pregunta != null && !pregunta.isEmpty()){
			pregunta = pregunta.replace("?", "");
			result = restTemplate.getForObject("http://localhost:8080/logica/preguntas/set/" + pregunta + "/" + id, String.class);
		}else if(valor != null && !valor.isEmpty()){
			String comentario = (inputComentario.isEmpty() ? "Sin comentarios":inputComentario);
			result = restTemplate.getForObject("http://localhost:8080/logica/calificaciones/set/"+ valor +"/" +comentario +"/" +id +"/" +idUsuario, String.class); 
		}
		
		
		
		ModelAndView view=new ModelAndView("redirect:/paseo/getPaseo/"+id+"/");
		return view;

	}
}
