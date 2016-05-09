package fabricas.presentacion.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import utilidades.utilidades;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fabricas.presentacion.VOs.CalificacionesVO;
import fabricas.presentacion.VOs.ServicioVO;
import fabricas.presentacion.VOs.UsuarioVO;

@Controller
@RequestMapping("/")
public class AlojamientoControlador {

	private static final String VIEW_BUSCAR_ALOJAMIENTO = "indexAlojamiento";
	private static final String VIEW_VER_ALOJAMIENTO = "verAlojamiento";

	/**
	 * Controlador de la pantalla de busqueda de alojamiento
	 * Metodo GET
	 * @param model
	 * @return
	 */

	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView buscarAlojamiento(ModelMap model) {
		List<ServicioVO> servicios=null;
		List<UsuarioVO> proveedores = null;
		ObjectMapper mapper = new ObjectMapper();
		RestTemplate restTemplate = new RestTemplate();

		//Se obtiene la lista de proveedores que tengan publicados servicios de alojamiento
		//Para poner en el select de la pantalla

		String result = restTemplate.getForObject("http://localhost:8080/logica/alojamiento/getproveedores/", String.class);
		try {
			proveedores = mapper.readValue(result, new TypeReference<List<UsuarioVO>>(){});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		//Se obtienen los servicos de alojamiento activos, ordenados por fecha de entrada
		result = restTemplate.getForObject("http://localhost:8080/logica/alojamiento/", String.class);
		try {
			servicios = mapper.readValue(result, new TypeReference<List<ServicioVO>>(){});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		ModelAndView modelAndView = new ModelAndView(VIEW_BUSCAR_ALOJAMIENTO);
		modelAndView.addObject("servicios", servicios);
		modelAndView.addObject("proveedores", proveedores);
		//Pasar a pantalla el usuario autenticado		
		modelAndView.addObject("usuarioAutenticado",utilidades.getSessionUser());
		return modelAndView;
	}

	/**
	 * Controlador de la pantalla de busqueda de alojamiento
	 * Se buscan servicios por criterios de busqueda
	 * Metodo POST
	 * @param ciudad
	 * @param proveedor
	 * @param fechaEntrada
	 * @param fechaSalida
	 * @param habitaciones
	 * @param personas
	 * @return
	 */
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
		List<UsuarioVO> proveedores = null;
		ObjectMapper mapper = new ObjectMapper();
		RestTemplate restTemplate = new RestTemplate();

		//Se obtiene la lista de proveedores que tengan publicados servicios de alojamiento
		//Para poner en el select de la pantalla

		String result = restTemplate.getForObject("http://localhost:8080/logica/alojamiento/getproveedores/", String.class);
		try {
			proveedores = mapper.readValue(result, new TypeReference<List<UsuarioVO>>(){});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		//Se obtienen los servicios de alojamineto que coincidan con los criterios de busqueda
		String url="ciudad="+ciudad+",proveedor="+proveedor+",fechaEntrada="+fechaEntrada;
		url = url+",fechaSalida="+fechaSalida+",habitaciones="+habitaciones+",personas="+personas;


		result = restTemplate.getForObject("http://localhost:8080/logica/alojamiento/"+url, String.class);

		try {
			servicios = mapper.readValue(result, new TypeReference<List<ServicioVO>>(){});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		ModelAndView modelAndView = new ModelAndView(VIEW_BUSCAR_ALOJAMIENTO);
		modelAndView.addObject("servicios", servicios);
		modelAndView.addObject("proveedores", proveedores);
		modelAndView.addObject("usuarioAutenticado",utilidades.getSessionUser());
		return modelAndView;
	}


	/**
	 * Controlador de la pantalla de ver informacion detallada de servicio de alojamiento
	 * @param id
	 * @param model
	 * @return
	 * @throws IOException 
	 * @throws RestClientException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@RequestMapping(value = "/getAlojamiento/{id}/", method = RequestMethod.GET)
	public ModelAndView getAlojamiento(@PathVariable("id")int id, ModelMap model){

		ServicioVO servicio=null;
		ObjectMapper mapper = new ObjectMapper();
		RestTemplate restTemplate = new RestTemplate();

		String result = restTemplate.getForObject("http://localhost:8080/logica/alojamiento/get/" + id, String.class);
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
		ModelAndView modelAndView = new ModelAndView(VIEW_VER_ALOJAMIENTO);
		modelAndView.addObject("servicio", servicio);
		
		if(cont >0){
			promCalificacion = (int) Math.ceil(promCalificacion/cont);
			modelAndView.addObject("promCalificacion", promCalificacion);
		}

		//Se verrifica si se debe habilitar el boton para calificar
		modelAndView.addObject("permisos", utilidades.getPermisos(id));
		modelAndView.addObject("usuarioAutenticado",utilidades.getSessionUser());
		return modelAndView;

	}
	
	@RequestMapping(value = "/getAlojamiento/{id}/", method = RequestMethod.POST)
	public ModelAndView getAlojamiento(@PathVariable("id")int id,
													@RequestParam(value="inputPregunta", required=false) String pregunta,
													@RequestParam(value="inputComentario", required=false) String inputComentario,
													@RequestParam(value="valor", required=false) String valor,
													@RequestParam(value="carrito", required=false) Integer carrito){

		RestTemplate restTemplate = new RestTemplate();
		String result = "";
		
		//Se recupera el id del usuario autenticado
		Integer idUsuario = null;
		if(utilidades.isUserAutenticado()){
			idUsuario = utilidades.getSessionIdUser();
		}
		

		//Si se envi� a almacenar una pregunta
		if(pregunta != null && !pregunta.isEmpty()){
			pregunta = pregunta.replace("?", "");
			result = restTemplate.getForObject("http://localhost:8080/logica/preguntas/set/" + pregunta + "/" + id, String.class);
		//Si se envi� a almacenar una calificacion
		}else if(valor != null && !valor.isEmpty()){
			String comentario = (inputComentario.isEmpty() ? "Sin comentarios":inputComentario);
			result = restTemplate.getForObject("http://localhost:8080/logica/calificaciones/set/"+ valor +"/" +comentario +"/" +id +"/" +idUsuario, String.class); 
		//Si se envi� a agregar al carrito
		}else if(carrito !=null){
			result = restTemplate.getForObject("http://localhost:8080/logica/pagos/addCarrito/"+id+"/"+idUsuario, String.class);
		}
		
		
		
		ModelAndView view=new ModelAndView("redirect:/getAlojamiento/"+id+"/");
		return view;

	}
	
	@RequestMapping(value="/index")
	public ModelAndView cerrarSesion(){
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession(true);
		session.invalidate();
		ModelAndView view=new ModelAndView("redirect:/");
		return view;
	}
}
