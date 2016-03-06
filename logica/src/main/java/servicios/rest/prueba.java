package servicios.rest;

import javax.persistence.EntityManager;
import fabricas.entidades.Servicio;

public class prueba {

	public static void main(String[] args) {
		
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		
		/*Calificaciones c = new Calificaciones();
		c.setIdcalificaciones(1);
		c.setFecha(new Date());
		c.setValor(1);
		
		em.persist(c);
	    em.getTransaction().commit();*/
		
		
		Object producto =  em.createNamedQuery("Servicio.findById")
				.setParameter("id", 1)
				.getResultList();

		Servicio s = (Servicio)producto;
		em.close();
		PersistenceManager.INSTANCE.close();

	}
}