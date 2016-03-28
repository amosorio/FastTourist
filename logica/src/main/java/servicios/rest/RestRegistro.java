package servicios.rest;
 
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.hibernate.metamodel.source.hbm.Helper.ValueSourcesAdapter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fabricas.entidades.Perfiles;
import fabricas.entidades.Servicio;
import fabricas.entidades.Usuario;

@RestController
@RequestMapping("/registro")
public class RestRegistro {


	@RequestMapping(value = "/{filtrosBasicos}/{filtrosAvanzados}/{filtrosAvanzados2}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <String> getAlojamientoByFilter(@PathVariable String filtrosBasicos,@PathVariable String filtrosAvanzados,@PathVariable String filtrosAvanzados2) {

		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		String nombre="";
		String apellido="";
		String email="";
		String direccion="";
		String telefono="";
		Date fecha= new Date();
		String password="";
		String perfil="";

		String[]values = filtrosBasicos.split(",");
		nombre=values[0];
		apellido=values[1];
		email=values[2];
		
		values = filtrosAvanzados.split(",");
		password = values[0];
		direccion=values[1];
		
		values = filtrosAvanzados2.split(",");
		telefono=values[0];
		perfil=values[1];
	

		try{
			Usuario usuario = (Usuario) em.createNamedQuery("Usuario.findByEmail").setParameter("email", email).getSingleResult();
		}catch(NoResultException e){
			Usuario usuario = new Usuario();
			usuario.setNombre(nombre);
			usuario.setApellido(apellido);
			usuario.setEmail(email);
			usuario.setPassword(password);
			usuario.setDireccion(direccion);
			usuario.setTelefono(telefono);
			usuario.setFechaCreacion(fecha);
			usuario.setLogin("1");
			usuario.setActivo(true);
			Perfiles perfiles = new Perfiles();
			perfiles.setIdperfil(new Integer(perfil));
			usuario.setPerfil(perfiles);
			em.persist(usuario);
			em.getTransaction().commit();
			return new ResponseEntity <String> ("Se ha registrado con éxito", HttpStatus.OK);
		}

		return new ResponseEntity <String> ("Ya hay un usuario registrado con ese correo!", HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/auth/{filtros}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <String> checkAuth(@PathVariable String filtros) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();

		String correo="";
		String password="";
		String[]values = filtros.split(",");
		correo=values[0];
		password=values[1];

		try{
			Usuario usuario = (Usuario) em.createNamedQuery("Usuario.authenticate")
					.setParameter("email", correo)
					.setParameter("password",password)
					.getSingleResult();
			}catch(NoResultException e){
			return new ResponseEntity <String> ("Error de autenticación. Revisa correo y/o contraseña", HttpStatus.OK);
		}	

		return new ResponseEntity <String> ("Te has autenticado correctamente", HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/darUsuario/{email}")
	public ResponseEntity <String> darUsuario(@PathVariable String email){
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();

		
		try{Usuario usr = (Usuario) em.createNamedQuery("Usuario.findByEmail")
			.setParameter("email", email)
			.getSingleResult();
		
		String resp = usr.getNombre()+":"+usr.getApellido()+":"+usr.getIdusuario()+":"+usr.getEmail();
		return new ResponseEntity <String> (resp,HttpStatus.OK);
		}
		catch(NoResultException e){			
			return new ResponseEntity <String> ("No encontrado",HttpStatus.OK);
		}
	}

}
