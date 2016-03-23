package servicios.rest;


import javax.persistence.EntityManager;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fabricas.entidades.Servicio;


@RestController
@RequestMapping("/transporte")
public class RestTransporte {

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE +"; charset=UTF-8"})
	public ResponseEntity<Servicio> getProducto(@PathVariable int id) {

		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();

		Servicio transporte = (Servicio) em.createNamedQuery("Servicio.findById")
				.setParameter("id", id)
				.getSingleResult();

		return new ResponseEntity<Servicio>(transporte, HttpStatus.OK);
	}

}