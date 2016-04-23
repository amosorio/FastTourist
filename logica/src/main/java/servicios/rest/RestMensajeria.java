package servicios.rest;


import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/mensajes")
public class RestMensajeria {
	private static final String DECODE="; charset=UTF-8";

	/*Lista todos los mensajes*/
	@RequestMapping(value = "/", 
			method = RequestMethod.GET, 
			produces={MediaType.APPLICATION_JSON_VALUE +DECODE})
	public ResponseEntity<String> mensajes() {
		System.out.println("Mensajes");
		return new ResponseEntity<String>("sii", HttpStatus.OK);
	}
	
	/*Crear nuevo mensaje*/
	@RequestMapping(value = "/", 
			method = RequestMethod.POST, 
			produces={MediaType.APPLICATION_JSON_VALUE +DECODE})
	public ResponseEntity<String> mensajes(@RequestBody  Object servicioVO) {
		System.out.println("Mensajes");
		return new ResponseEntity<String>("sii", HttpStatus.OK);
	}

	/*Obtener el detalle de un mensaje*/
	@RequestMapping(value = "/{id}", 
			method = RequestMethod.GET, 
			produces={MediaType.APPLICATION_JSON_VALUE +DECODE})
	public ResponseEntity<String> mensajes(@PathVariable int id) {
		System.out.println("Mensajes");
		return new ResponseEntity<String>("sii", HttpStatus.OK);
	}
	
	/*Actualizar mensaje*/
	@RequestMapping(value = "/{id}", 
			method = RequestMethod.PUT, 
			produces={MediaType.APPLICATION_JSON_VALUE +DECODE})
	public ResponseEntity<String> mensajes(@PathVariable int id,@RequestBody  Object servicioVO) {
		System.out.println("Mensajes");
		return new ResponseEntity<String>("sii", HttpStatus.OK);
	}
	
	/*Lista todos los mensajes del usuario*/
	@RequestMapping(value = "/{id}/usuario", 
			method = RequestMethod.GET, 
			produces={MediaType.APPLICATION_JSON_VALUE +DECODE})
	public ResponseEntity<String> mensajesPorUsuario(@PathVariable int id) {
		System.out.println("Mensajes");
		return new ResponseEntity<String>("sii", HttpStatus.OK);
	}
}
