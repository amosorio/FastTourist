package fabricas.presentacion.controladores;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import fabricas.presentacion.VOs.ServicioVO;
import fabricas.presentacion.VOs.UsuarioVO;

@Controller
@RequestMapping("/")
public class AlojamientoControlador {

	private static final String VIEW_BUSCAR_ALOJAMIENTO = "indexAlojamiento";

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
		return modelAndView;

	}
}
