package servicios.rest;


import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import fabricas.entidades.Servicio;


@RestController
@RequestMapping("/paseo")
public class RestPaseo {



	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE +"; charset=UTF-8"})
	public ResponseEntity<Servicio> getPaseo(@PathVariable int id) {

		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();

		Servicio paseo = (Servicio) em.createNamedQuery("Servicio.findById")
				.setParameter("id", id)
				.getSingleResult();

		return new ResponseEntity<Servicio>(paseo, HttpStatus.OK);
	}


}