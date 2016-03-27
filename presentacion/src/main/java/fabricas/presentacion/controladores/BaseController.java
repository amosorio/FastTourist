package fabricas.presentacion.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BaseController {


	private static final String CONTACTENOS = "contactenos";
	private static final String REGISTRO = "registro";

	
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
	
	@RequestMapping(value = "/registro", method = RequestMethod.POST)
	public ModelAndView registro(
		@RequestParam(value="nombre", required=true) String nombre, 
		@RequestParam(value="apellido", required=true) String apellido,
		@RequestParam(value="email", required=true) String email, 
		@RequestParam(value="password", required=true) String password,
		@RequestParam(value="direccion", required=true) String direccion,
		@RequestParam(value="telefono", required=true) String telefono,
		@RequestParam(value="tipoUsuario", required=true) String tipoUsuario
		){
		
		String response = null;
		RestTemplate restTemplate = new RestTemplate();
		
		String urlBasico=nombre+","+apellido+","+email;
		String urlAvanzado =password+","+direccion;
		String urlAvanzado2 =telefono+","+tipoUsuario;

		response = restTemplate.getForObject("http://localhost:8080/logica/registro/"+urlBasico+"/"+urlAvanzado+"/"+urlAvanzado2, String.class);

		ModelAndView modelAndView = new ModelAndView(REGISTRO);
		modelAndView.addObject("response", response);
		return modelAndView;
		
	}
	
}