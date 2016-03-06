package fabricas.entidades;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the paquetes database table.
 * 
 */
@Entity
@Table(name="paquetes")
@NamedQueries({
	@NamedQuery(name="Paquete.findAll", query="SELECT p FROM Paquete p"),
	@NamedQuery(name="Paquete.findById", query="SELECT p FROM Paquete p where p.idpaquetes = :id"),
}) 

public class Paquete implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idpaquetes;

	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_creacion")
	
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_expiracion")
	
	private Date fechaExpiracion;

	private String nombre;

	//bi-directional many-to-many association to Servicio
	@ManyToMany(mappedBy="paquetes")
	@JsonBackReference
	private List<Servicio> servicios;

	//bi-directional many-to-one association to Transaccione
	@OneToMany(mappedBy="paqueteBean")
	
	private List<Transacciones> transacciones;

	public Paquete() {
	}

	public int getIdpaquetes() {
		return this.idpaquetes;
	}

	public void setIdpaquetes(int idpaquetes) {
		this.idpaquetes = idpaquetes;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaExpiracion() {
		return this.fechaExpiracion;
	}

	public void setFechaExpiracion(Date fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Servicio> getServicios() {
		return this.servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public List<Transacciones> getTransacciones() {
		return this.transacciones;
	}

	public void setTransacciones(List<Transacciones> transacciones) {
		this.transacciones = transacciones;
	}

	public Transacciones addTransaccione(Transacciones transaccione) {
		getTransacciones().add(transaccione);
		transaccione.setPaqueteBean(this);

		return transaccione;
	}

	public Transacciones removeTransaccione(Transacciones transaccione) {
		getTransacciones().remove(transaccione);
		transaccione.setPaqueteBean(null);

		return transaccione;
	}

}