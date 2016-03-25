package servicios.rest;


import java.util.Date;

import javax.persistence.EntityManager;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import fabricas.entidades.Preguntas;
import fabricas.entidades.Servicio;


@RestController
@RequestMapping("/preguntas")
public class RestPreguntas {

	@RequestMapping(value = "/set/{pregunta}/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String setPregunta(@PathVariable int id,@PathVariable String pregunta) {

		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		
		Servicio servicio = (Servicio) em.createNamedQuery("Servicio.findById")
				.setParameter("id", id)
				.getSingleResult();
		
		Preguntas p = new Preguntas();
		p.setFechaCreacion(new Date());
		p.setPregunta(pregunta+"?");
		p.setServicio(servicio);
		
		em.persist(p);
		em.getTransaction().commit();
		
		return "ok";
	}
}