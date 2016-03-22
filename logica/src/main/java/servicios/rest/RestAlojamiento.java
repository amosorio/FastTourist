package servicios.rest;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import fabricas.entidades.Servicio;


@RestController
@RequestMapping("/alojamiento")
public class RestAlojamiento {

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <List<Servicio>> getAlojamiento() {

		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();

		List<Servicio> alojamientos;

		alojamientos = (List<Servicio>) em.createNamedQuery("Servicio.findAlojamiento").getResultList();

		return new ResponseEntity <List<Servicio>> (alojamientos, HttpStatus.OK);

	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/{filtros}", 
	method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <List<Servicio>> getAlojamientoByFilter(@PathVariable String filtros) {

		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();

		//Se recuperan los filtros de busqueda
		String ciudad="";
		String proveedor="";
		String habitaciones="";
		String personas="";
		String fechaEntrada="";
		String fechaSalida="";

		for (String filtro : filtros.split(",")) {
			String[]values = filtro.split("=");
			if(values.length==2){
				if (values[0].equals("ciudad")){
					ciudad=values[1];
				}else if(values[0].equals("proveedor")){
					proveedor=values[1];
				}else if(values[0].equals("habitaciones")){
					habitaciones=values[1];
				}else if(values[0].equals("personas")){
					personas=values[1];
				}else if(values[0].equals("fechaEntrada")){
					fechaEntrada=values[1];//format.parse(values[1]);
				}else if(values[0].equals("fechaSalida")){
					fechaSalida=values[1];//format.parse(values[1]);
				}
			}
		}


		List<Servicio> alojamientos = null;
		
		String query = "SELECT s FROM Servicio s WHERE s.activo=1 AND s.categoria=1 ";
		if (!ciudad.isEmpty()){
			query = query + "AND UPPER(s.alojamiento.ciudad) like UPPER('" + ciudad +"') ";
		}
		if(!proveedor.isEmpty()){
			query = query + "AND s.usuario="+proveedor+" ";
		}
		
		if(!habitaciones.isEmpty()){
			query = query + "AND s.alojamiento.habitaciones > "+habitaciones+" ";
		}
		
		if(!personas.isEmpty()){
			query = query + "AND s.alojamiento.cantPersonas > "+personas+" ";
		}
		
		if(!fechaEntrada.isEmpty()){
			query = query + "AND s.alojamiento.fechaEntrada <= '"+fechaEntrada+"' ";
		}
		
		if(!fechaSalida.isEmpty()){
			query = query +" AND s.alojamiento.fechaSalida >= '"+fechaSalida+"' ";
		}
		
		//Se agrega ordenamiento
		query = query + "ORDER BY s.alojamiento.fechaEntrada desc";
		
		alojamientos = em.createQuery(query).getResultList();


		return new ResponseEntity <List<Servicio>> (alojamientos, HttpStatus.OK);

	}
}