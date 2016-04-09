package fabricas.presentacion.controladores;

import java.util.List;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import utilidades.EnumPerfiles;
import utilidades.utilidades;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import fabricas.presentacion.VOs.PaqueteVO;
import fabricas.presentacion.VOs.ServicioVO;

@Controller
@RequestMapping(value = "/adminProveedor/paquetes")
public class CrudPaquetesControlador {

	private static final String VIEW_PROVEEDOR_PAQUETES = "proveedorPaquetes";
	private static final String VIEW_PROVEEDOR_EDITAR_PAQUETES = "editarPaquete";
	private static final String VIEW_PROVEEDOR_ARMAR_PAQUETES = "armarPaquete";


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView indexProveedorPaquetes(ModelMap model) {

		//Validar si hay usuario autenticado y si es proveedor
		if(!utilidades.isUserAutenticado() || 
				utilidades.getPerfil()!=EnumPerfiles.PROVEEDOR.getValue()){
			ModelAndView view=new ModelAndView("redirect:/registro");
			return view;
		}

		List<PaqueteVO> paquetes=null;
		List<ServicioVO> servicios=null;
		ObjectMapper mapper = new ObjectMapper();
		RestTemplate restTemplate = new RestTemplate();


		//Se obtienen los paquetes del proveedor ordenados por fecha de creacion
		String result = restTemplate.getForObject("http://localhost:8080/logica/paquetes/getByProvider/"+utilidades.getSessionIdUser()+"/", String.class);
		try {
			paquetes = mapper.readValue(result, new TypeReference<List<PaqueteVO>>(){});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//Lista de servicios para el componente random
		result = restTemplate.getForObject("http://localhost:8080/logica/servicios/getByProvider/"+utilidades.getSessionIdUser()+"/", String.class);
		try {
			servicios = mapper.readValue(result, new TypeReference<List<ServicioVO>>(){});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		ModelAndView modelAndView = new ModelAndView(VIEW_PROVEEDOR_PAQUETES);
		modelAndView.addObject("servicios", servicios);
		modelAndView.addObject("paquetes", paquetes);
		modelAndView.addObject("usuarioAutenticado",utilidades.getSessionUser());
		return modelAndView;
	}

	@RequestMapping(value = "/edit/{id}/", method = RequestMethod.GET)
	public ModelAndView editPaquete(@PathVariable("id")int id, ModelMap model) {

		List<ServicioVO> servicios=null;
		PaqueteVO paquete=null;
		ObjectMapper mapper = new ObjectMapper();
		RestTemplate restTemplate = new RestTemplate();

		//Validar si hay usuario autenticado y si es proveedor
		if(!utilidades.isUserAutenticado() || 
				utilidades.getPerfil()!=EnumPerfiles.PROVEEDOR.getValue()){
			ModelAndView view=new ModelAndView("redirect:/registro");
			return view;
		}

		String result = restTemplate.getForObject("http://localhost:8080/logica/paquetes/get/" + id+"/", String.class);
		try {
			paquete = mapper.readValue(result, PaqueteVO.class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		result = restTemplate.getForObject("http://localhost:8080/logica/servicios/getByProvider/"+utilidades.getSessionIdUser()+"/", String.class);
		try {
			servicios = mapper.readValue(result, new TypeReference<List<ServicioVO>>(){});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		for (ServicioVO servicioVO : paquete.getServicios()) {
			servicios.remove(servicioVO);
		}


		ModelAndView modelAndView= new ModelAndView(VIEW_PROVEEDOR_EDITAR_PAQUETES);
		modelAndView.addObject("paquete", paquete);
		modelAndView.addObject("servicios", servicios);
		modelAndView.addObject("usuarioAutenticado",utilidades.getSessionUser());
		return modelAndView;
	}

	@RequestMapping(value = "/edit/{id}/", method = RequestMethod.POST)
	public ModelAndView editPaquete(@PathVariable("id")int id,@ModelAttribute("paquete") PaqueteVO paquete) {
		List<ServicioVO> servicios=null;
		ObjectMapper mapper = new ObjectMapper();
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(new StringHttpMessageConverter());


		paquete.setIdpaquetes(id);
		
		String uri = "http://localhost:8080/logica/paquetes/edit/";
		String result = (String) restTemplate.postForObject(uri,paquete, String.class);
		try {
			paquete = mapper.readValue(result, PaqueteVO.class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		result = restTemplate.getForObject("http://localhost:8080/logica/servicios/getByProvider/"+utilidades.getSessionIdUser()+"/", String.class);
		try {
			servicios = mapper.readValue(result, new TypeReference<List<ServicioVO>>(){});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		ModelAndView modelAndView= new ModelAndView(VIEW_PROVEEDOR_EDITAR_PAQUETES);
		modelAndView.addObject("paquete", paquete);
		modelAndView.addObject("servicios", servicios);
		modelAndView.addObject("editExitoso",true);
		modelAndView.addObject("usuarioAutenticado",utilidades.getSessionUser());
		return modelAndView;
	}
/*
	@RequestMapping(value = "/crear/", method = RequestMethod.GET)
	public ModelAndView crearAlojamiento(ModelMap model) {
		ServicioVO servicio = new ServicioVO();
		List<ServicioVO> servicios=null;
		ObjectMapper mapper = new ObjectMapper();
		RestTemplate restTemplate = new RestTemplate();

		//Validar si hay usuario autenticado y si es proveedor
		if(!utilidades.isUserAutenticado() || 
				utilidades.getPerfil()!=EnumPerfiles.PROVEEDOR.getValue()){
			ModelAndView view=new ModelAndView("redirect:/registro");
			return view;
		}

		String result = restTemplate.getForObject("http://localhost:8080/logica/servicios/getByProvider/"+utilidades.getSessionIdUser()+"/", String.class);
		try {
			servicios = mapper.readValue(result, new TypeReference<List<ServicioVO>>(){});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		ModelAndView modelAndView = new ModelAndView(VIEW_PROVEEDOR_CREAR_SERVICIOS);
		modelAndView.addObject("servicio", servicio);
		modelAndView.addObject("servicios", servicios);
		modelAndView.addObject("usuarioAutenticado",utilidades.getSessionUser());
		return modelAndView;
	}

	@RequestMapping(value = "/crear/", method = RequestMethod.POST)
	public ModelAndView crearAlojamiento(@ModelAttribute("servicio") ServicioVO servicio) {

		List<ServicioVO> servicios=null;
		ObjectMapper mapper = new ObjectMapper();
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(new StringHttpMessageConverter());


		UsuarioVO usuarioVO = new UsuarioVO();
		usuarioVO.setIdusuario(utilidades.getSessionIdUser());
		servicio.setUsuario(usuarioVO);


		String uri = "http://localhost:8080/logica/servicios/create/";
		String result = (String) restTemplate.postForObject(uri,servicio,String.class);
		try {
			servicio = mapper.readValue(result, ServicioVO.class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		result = restTemplate.getForObject("http://localhost:8080/logica/servicios/getByProvider/"+utilidades.getSessionIdUser()+"/", String.class);
		try {
			servicios = mapper.readValue(result, new TypeReference<List<ServicioVO>>(){});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		ModelAndView modelAndView = new ModelAndView(VIEW_PROVEEDOR_CREAR_SERVICIOS);
		modelAndView.addObject("servicio", servicio);
		modelAndView.addObject("servicios", servicios);
		modelAndView.addObject("crearExitoso",true);
		modelAndView.addObject("usuarioAutenticado",utilidades.getSessionUser());
		return modelAndView;
	}

	@RequestMapping(value = "/delete/{id}/", method = RequestMethod.GET)
	public ModelAndView eliminarAlojamiento(@PathVariable("id")int id) {


		RestTemplate restTemplate = new RestTemplate();

		String url = "http://localhost:8080/logica/servicios/delete/"+id +"/";

		try {
			restTemplate.delete(url);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		ModelAndView view=new ModelAndView("redirect:/adminProveedor/");
		return view;

	}	*/
}