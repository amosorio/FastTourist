package fabricas.presentacion.controladores;
 
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class BaseController {


	private static final String CONTACTENOS = "contactenos";
	private static final String REGISTRO = "registro";
	private static final String INDEX = "indexAlojamiento";

	
	/**
	 * Controlador de la pantalla Contactenos
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/contactenos", method = RequestMethod.GET)
	public ModelAndView contactenos(ModelMap model) {
		ModelAndView modelAndView = new ModelAndView(CONTACTENOS);
		modelAndView.addObject("usuarioAutenticado",utilidades.getSessionUser());
		return modelAndView;
	}
	
	/**
	 * Controlador de la pantalla de Registro
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/registro", method = RequestMethod.GET)
	public ModelAndView registrarse(ModelMap model) {
		ModelAndView modelAndView = new ModelAndView(REGISTRO);
		modelAndView.addObject("usuarioAutenticado",utilidades.getSessionUser());
		return modelAndView;
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

		if(response.startsWith("Se ha registrado"))
		{
			String response2 = restTemplate.getForObject("http://localhost:8080/logica/registro/darUsuario/"+email+"/", String.class);
			String msj[] = response2.split(":");
			
			ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
			HttpSession session = attr.getRequest().getSession(true);
			session.setAttribute("user", msj[0]+" "+msj[1]);
			session.setAttribute("userId", msj[2].toString());
			session.setAttribute("userCorreo", msj[3]);
			session.setAttribute("perfil", msj[4]);
		}
		
		ModelAndView modelAndView = new ModelAndView(REGISTRO);
		modelAndView.addObject("response", response);
		modelAndView.addObject("usuarioAutenticado",utilidades.getSessionUser());
		return modelAndView;
		
	}
	
	
	@RequestMapping(value="/registro/auth", method = RequestMethod.POST)
	public ModelAndView autenticacion(
		@RequestParam(value="correo", required=true) String correo, 
		@RequestParam(value="password", required=true) String password){
		
		String response = null;
		ObjectMapper mapper = new ObjectMapper();
		RestTemplate restTemplate = new RestTemplate();
		
		String url = correo+","+password;
		
		response = restTemplate.getForObject("http://localhost:8080/logica/registro/auth/"+url+"/", String.class);
		
		if(response.startsWith("Te has autenticado"))
		{
			String response2 = restTemplate.getForObject("http://localhost:8080/logica/registro/darUsuario/"+correo+"/", String.class);
			String msj[] = response2.split(":");
			
			ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
			HttpSession session = attr.getRequest().getSession(true);
			session.setAttribute("user", msj[0]+" "+msj[1]);
			session.setAttribute("userId", msj[2].toString());
			session.setAttribute("userCorreo", msj[3]);
			session.setAttribute("perfil", msj[4]);
			System.out.println(msj[4]);
		}
		
		ModelAndView modelAndView = new ModelAndView(REGISTRO);
		modelAndView.addObject("response", response);
		modelAndView.addObject("usuarioAutenticado",utilidades.getSessionUser());
		return modelAndView;
	}
	
}