package fabricas.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * The persistent class for the paquetes database table.
 * 
 */
@Entity
@Table(name="paquetes")
@NamedQueries({
	@NamedQuery(name="Paquete.findById", query="SELECT p FROM Paquete p where p.idpaquetes = :id"),
	@NamedQuery(name="Paquete.findAll", query="SELECT p FROM Paquete p"),
	@NamedQuery(name="Paquete.findByProvider", query="SELECT p FROM Paquete p WHERE p.usuario.idusuario = :idProveedor ORDER BY p.fechaCreacion desc"),
}) 
//@NamedQuery(name="Paquete.findServicios",query="SELECT p FROM Paquete p WHERE p.categoria=4")
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
	@ManyToMany
	@JoinTable(
			name="servicios_por_paquete"
			, joinColumns={
				@JoinColumn(name="paquete")
				}
			, inverseJoinColumns={
				@JoinColumn(name="servicio")
				}
			)
	@JsonManagedReference
	private List<Servicio> servicios;
	
	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="proveedor")
	@JsonManagedReference
	private Usuario usuario;

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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}