package fabricas.entidades;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idusuario;

	private boolean activo;

	private String apellido;

	private String direccion;

	private String email;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	private String login;

	private String nombre;

	private String password;

	private String telefono;
	
	//bi-directional many-to-one association to Calificaciones
	@OneToMany(mappedBy="usuario")
	@JsonManagedReference
	private List<Calificaciones> Calificacioness;
	

	//bi-directional many-to-one association to Pregunta
	@OneToMany(mappedBy="usuario")
	@JsonBackReference
	private List<Preguntas> preguntas;

	//bi-directional many-to-one association to Carrito
	@OneToMany(mappedBy="usuario")
	@JsonBackReference
	private List<Carrito> carrito;
	
	//bi-directional many-to-one association to Transacciones
	@OneToMany(mappedBy="usuario")
	@JsonBackReference
	private List<Transacciones> transacciones;
	
	//bi-directional many-to-one association to Log
	@OneToMany(mappedBy="usuarioBean")
	
	private List<Log> logs;

	//bi-directional many-to-one association to Servicio
	@OneToMany(mappedBy="usuario")
	
	private List<Servicio> servicios;

	//bi-directional many-to-one association to Perfile
	@ManyToOne
	@JoinColumn(name="perfil")
	@JsonManagedReference
	private Perfiles perfil;

	public Usuario() {
	}

	public int getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public boolean getActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Calificaciones> getCalificacioness() {
		return this.Calificacioness;
	}

	public void setCalificacioness(List<Calificaciones> Calificacioness) {
		this.Calificacioness = Calificacioness;
	}

	public Calificaciones addCalificaciones(Calificaciones Calificaciones) {
		getCalificacioness().add(Calificaciones);
		Calificaciones.setUsuario(this);

		return Calificaciones;
	}

	public Calificaciones removeCalificaciones(Calificaciones Calificaciones) {
		getCalificacioness().remove(Calificaciones);
		Calificaciones.setUsuario(null);

		return Calificaciones;
	}

	public List<Carrito> getCarrito() {
		return carrito;
	}

	public void setCarrito(List<Carrito> carrito) {
		this.carrito = carrito;
	}

	public List<Log> getLogs() {
		return this.logs;
	}

	public void setLogs(List<Log> logs) {
		this.logs = logs;
	}

	public Log addLog(Log log) {
		getLogs().add(log);
		log.setUsuarioBean(this);

		return log;
	}

	public Log removeLog(Log log) {
		getLogs().remove(log);
		log.setUsuarioBean(null);

		return log;
	}

	/*public List<Servicio> getServicios() {
		return this.servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}*/

	/*public Servicio addServicio(Servicio servicio) {
		getServicios().add(servicio);
		servicio.setUsuario(this);

		return servicio;
	}

	public Servicio removeServicio(Servicio servicio) {
		getServicios().remove(servicio);
		servicio.setUsuario(null);

		return servicio;
	}*/

	public List<Transacciones> getTransacciones() {
		return this.transacciones;
	}

	public void setTransacciones(List<Transacciones> transacciones) {
		this.transacciones = transacciones;
	}

	public Transacciones addTransaccione(Transacciones transacciones) {
		getTransacciones().add(transacciones);
		transacciones.setUsuario(this);

		return transacciones;
	}

	public Transacciones removeTransaccione(Transacciones transacciones) {
		getTransacciones().remove(transacciones);
		transacciones.setUsuario(null);

		return transacciones;
	}

	public List<Preguntas> getPreguntas() {
		return this.preguntas;
	}

	public void setPreguntas(List<Preguntas> preguntas) {
		this.preguntas = preguntas;
	}

	public Preguntas addPreguntas(Preguntas preguntas) {
		getPreguntas().add(preguntas);
		preguntas.setUsuario(this);

		return preguntas;
	}

	public Preguntas removePreguntas(Preguntas preguntas) {
		getPreguntas().remove(preguntas);
		preguntas.setUsuario(null);

		return preguntas;
	}
	public Perfiles getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfiles perfil) {
		this.perfil = perfil;
	}

}