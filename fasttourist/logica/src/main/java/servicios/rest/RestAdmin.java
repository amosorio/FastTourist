package servicios.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import VOs.ServicioVO;
import VOs.UsuarioVO;
import fabricas.entidades.Perfiles;
import fabricas.entidades.Servicio;
import fabricas.entidades.Transacciones;
import fabricas.entidades.Usuario;

@RestController
@RequestMapping("/admin")
public class RestAdmin {

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <List<Usuario>> getProveedores() {

		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();

		List<Usuario> proveedores = (List<Usuario>) em.createNamedQuery("Usuario.findProveedores").getResultList();

		return new ResponseEntity <List<Usuario>> (proveedores, HttpStatus.OK);
		
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/eliminar/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> eliminarProveedor(@PathVariable("id") int id) {
		
		String resultado = "";
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		
		try {
			Usuario usuario = (Usuario) em.createNamedQuery("Usuario.findById").setParameter("id", id).getSingleResult();
			List<Servicio> servicios = (List<Servicio>) em.createNamedQuery("Servicio.findByProveedor")
					.setParameter("idProveedor", id).getResultList();
			
			em.remove(usuario);
			em.getTransaction().commit();
			RestCrudServicios restServicios = new RestCrudServicios();
			for(Servicio serv: servicios){
				restServicios.deleteAlojamiento(serv.getIdservicios());
			}
			resultado = "Se ha eliminado el proveedor con todos sus servicios.";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			resultado="Ha ocurrido un problema. Por favor contacta soporte t�cnico";
			e.printStackTrace();
		}
		
		return new ResponseEntity<String>(resultado,HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/getProveedor/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> getProveedor(@PathVariable("id") int id) {
		
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		Usuario usuario = null;
		try {
			usuario = (Usuario) em.createNamedQuery("Usuario.findById").setParameter("id", id).getSingleResult();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<Usuario>(usuario,HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value = "/update", method = RequestMethod.POST,produces={MediaType.APPLICATION_JSON_VALUE +"; charset=UTF-8"})
	public ResponseEntity<Usuario> updateProveedor(@RequestBody  UsuarioVO usuarioVO){

		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();

		Usuario usuario = em.find(Usuario.class, usuarioVO.getIdusuario());

		em.getTransaction().begin();

		usuario.setNombre(usuarioVO.getNombre());
		usuario.setApellido(usuario.getApellido());
		usuario.setDireccion(usuarioVO.getDireccion());
		usuario.setEmail(usuarioVO.getEmail());
		usuario.setTelefono(usuarioVO.getTelefono());
		usuario.setActivo(usuarioVO.isActivo());		
	
		em.getTransaction().commit();
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}

	@RequestMapping(value = "/crear/", method = RequestMethod.POST,produces={MediaType.APPLICATION_JSON_VALUE +"; charset=UTF-8"})
	public ResponseEntity<String> createProveedor(@RequestBody  UsuarioVO usuarioVO){
		
		String resultado = "";
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		
		try{
			Usuario usuario = (Usuario) em.createNamedQuery("Usuario.findByEmail").setParameter("email", usuarioVO.getEmail())
					.getSingleResult();
			
			resultado = "Ya existe un proveedor con este correo.";
			return new ResponseEntity<String>(resultado, HttpStatus.OK);
			
		}catch(Exception e){
			e.printStackTrace();

				em.getTransaction().begin();

				Usuario nuevo = new Usuario();

				nuevo.setNombre(usuarioVO.getNombre());
				nuevo.setApellido(usuarioVO.getApellido());
				nuevo.setDireccion(usuarioVO.getDireccion());
				nuevo.setEmail(usuarioVO.getEmail());
				nuevo.setTelefono(usuarioVO.getTelefono());
				nuevo.setActivo(true);
				nuevo.setPassword(usuarioVO.getPassword());
				nuevo.setLogin("1");
				nuevo.setFechaCreacion(new Date());
				Perfiles perfil = new Perfiles();
				perfil.setIdperfil(1);
				nuevo.setPerfil(perfil);

				em.persist(nuevo);
				em.getTransaction().commit();
				resultado = "Se ha agregado un nuevo Proveedor";
				return new ResponseEntity<String>(resultado, HttpStatus.OK);
			}
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/solicitudes-baja/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Usuario>> darSolicitudesBaja() {
		
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();

		List<Usuario> proveedores = new ArrayList<Usuario>();
		proveedores = em.createNamedQuery("Usuario.findSolicitudesBaja").getResultList();

		return new ResponseEntity <List<Usuario>> (proveedores, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/transacciones/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Transacciones>> darTransacciones() {
		
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
	
		List<Transacciones> transacciones= em.createNamedQuery("Transacciones.findAll").getResultList();
		
		return new ResponseEntity <List<Transacciones>> (transacciones, HttpStatus.OK);
		
	}
	

}
