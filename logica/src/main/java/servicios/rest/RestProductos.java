package servicios.rest;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping("/producto")
public class RestProductos {

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody String getGreeting(@PathVariable int id) {
		String result="Hello "+id;
		return result;
	}
}