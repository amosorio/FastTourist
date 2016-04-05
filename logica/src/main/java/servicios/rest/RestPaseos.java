package servicios.rest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fabricas.entidades.Categoria;
import fabricas.entidades.Paseosecologico;
import fabricas.entidades.Servicio;

@RestController
@RequestMapping("/paseos")
public class RestPaseos {

	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getServiciosPaseos", method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE +"; charset=UTF-8"})
	public ResponseEntity<List<Servicio>> getAllServicios() {
		
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		
		List<Servicio> array = (List<Servicio>) em.createNamedQuery("Servicio.findServicioPaseos")		
				.getResultList();
		
		return new ResponseEntity<List<Servicio>>(array, HttpStatus.OK);
	}	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/filtrarPaseos/{filtros}", 
	method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE +"; charset=UTF-8"})
	public ResponseEntity <List<Servicio>> getServicioByFilter(@PathVariable String filtros) {
		
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		
		String query= queryServicioByFilter(filtros);
		
		List<Servicio> servicios = em.createQuery(query).getResultList();
		
		return new ResponseEntity <List<Servicio>> (servicios, HttpStatus.OK);
		
	}
	
	private String queryServicioByFilter(String filtros) {
		
		//Se recuperan los filtros de busqueda
		String nombre="";
		String lugar="";
		String servicio="";
		
		for (String filtro : filtros.split(",")) {
			String[]values = filtro.split("=");
			if(values.length==2){
				if (values[0].equals("nombre")){
					nombre=values[1];
				}else if(values[0].equals("lugar")){
					lugar=values[1];
				}else if(values[0].equals("servicio")){
					servicio=values[1];
				}
			}
		}
		
		String query = "SELECT s FROM Servicio s WHERE s.activo=1 AND s.categoria=4 ";
		
		if (!nombre.isEmpty()){
			query = query + "AND UPPER(s.paseosecologico.nombre) like UPPER('%"+nombre+"%') ";
		}
		if(!lugar.isEmpty()){
			query = query + "AND UPPER(s.paseosecologico.lugar) like UPPER('%"+lugar+"%') ";
		}
		if(!servicio.isEmpty()){
			query = query + "AND UPPER(s.nombre) like UPPER('%"+servicio+"%') ";
		}
		
		return query;
		
	}
	
	
	//---------CRUD---------------
	
	@RequestMapping(value="/crear/{condiciones}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> crearPaseo(@PathVariable String condiciones){
		
		String descripcion = "";
		int duracion = -1;
		String fotos = "";
		String lugar = "";
		String nombre = "";
		int precio = -1;
		String requerimientos = "";
		
		String[]values = condiciones.split(",");
		descripcion = values[0];
		duracion = Integer.parseInt(values[1]);
		fotos = values[2];
		lugar = values[3];
		nombre = values[4];
		precio = Integer.parseInt(values[5]);
		requerimientos = values[6];
		
		Paseosecologico paseo = new Paseosecologico();
		paseo.setDescripcion(descripcion);
		paseo.setDuracion(duracion);
		paseo.setFotos(fotos);
		paseo.setLugar(lugar);
		paseo.setNombre(nombre);
		paseo.setPrecio(precio);
		paseo.setRequerimientos(requerimientos);
		
		Servicio serv = new Servicio();
		serv.setActivo(true);
		serv.setDescripcion(descripcion);
		serv.setFechaCreacion(new Date());
		serv.setNombre(nombre);
		BigDecimal big = new BigDecimal(precio);
		serv.setPrecio(big);
		serv.setDescuento(new BigDecimal(0));
		serv.setRutaGaleria(fotos);
		
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		
		
		try {
			em.persist(paseo);
			em.persist(serv);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity <String> ("Ha ocurrido un error. ¡No se ha podido crear el paseo!", HttpStatus.OK);		
		}
		
		return new ResponseEntity <String> ("Creación de paseo satisfactoria", HttpStatus.OK);		
	}
	
	
	@RequestMapping(value = "/eliminar/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getById(@PathVariable int id) {
		
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		
		Servicio servicio = (Servicio) em.createNamedQuery("Servicio.findById")
				.setParameter("id", id)
				.getSingleResult();
		
		Paseosecologico producto = servicio.getPaseosecologico();
		
		try {
			em.remove(servicio);
			em.remove(producto);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>("No se ha podido eliminar el paseo.", HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("Se ha eliminado el evento", HttpStatus.OK);
	}
	
	
	
	//--------------No usados hasta el momento -----------------//
	
	
//	@SuppressWarnings("unchecked")
//	@RequestMapping(value = "/getPaseos", consumes = "application/json", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<Paseosecologico>> getAllPaseos() {
//		
//		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
//		em.getTransaction().begin();
//		
//		List<Paseosecologico> array = (List<Paseosecologico>) em.createNamedQuery("Paseosecologico.findAll")		
//				.getResultList();
//		
//		return new ResponseEntity<List<Paseosecologico>>(array, HttpStatus.OK);
//	}	
	
		
//		
//		@RequestMapping(value = "/filtrar-nombre", consumes = "application/json", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//		public ResponseEntity<ArrayList<Paseosecologico>> getByNombre(@PathVariable String nombre) {
//			
//			EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
//			em.getTransaction().begin();
//
//			@SuppressWarnings("unchecked")
//			ArrayList<Paseosecologico> array = (ArrayList<Paseosecologico>) em.createNamedQuery("Paseosecologico.findByName")
//					.setParameter("nombre", nombre)
//					.getResultList();
//			
//			return new ResponseEntity<ArrayList<Paseosecologico>>(array, HttpStatus.OK);
//		
//		}		
//		
//		@RequestMapping(value = "/filtrar-lugar", consumes = "application/json", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//		public ResponseEntity<ArrayList<Paseosecologico>> getByLugar(@PathVariable String lugar) {
//			
//			EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
//			em.getTransaction().begin();
//
//			@SuppressWarnings("unchecked")
//			ArrayList<Paseosecologico> array = (ArrayList<Paseosecologico>) em.createNamedQuery("Paseosecologico.findByPlace")
//				.setParameter("lugar", lugar)
//				.getResultList();
//
//			return new ResponseEntity<ArrayList<Paseosecologico>>(array, HttpStatus.OK);
//		}		
//
//		
//		public static void main(String[] args) {
//			
//			RestPaseos p = new RestPaseos();
//			p.getAllServicios();
//			
//		}
}
