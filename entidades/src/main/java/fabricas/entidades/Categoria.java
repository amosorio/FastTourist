package fabricas.entidades;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the categorias database table.
 * 
 */
@Entity
@Table(name="categorias")
@NamedQuery(name="Categoria.findAll", query="SELECT c FROM Categoria c")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idcategorias;

	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	private String nombre;

	//bi-directional many-to-one association to Servicio
	@OneToMany(mappedBy="categoriaBean")
	@JsonBackReference
	private List<Servicio> servicios;
	
	public Categoria() {
	}

	public int getIdcategorias() {
		return this.idcategorias;
	}

	public void setIdcategorias(int idcategorias) {
		this.idcategorias = idcategorias;
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/*public List<Servicio> getServicios() {
		return this.servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}*/

	/*public Servicio addServicio(Servicio servicio) {
		getServicios().add(servicio);
		servicio.setCategoriaBean(this);

		return servicio;
	}

	public Servicio removeServicio(Servicio servicio) {
		getServicios().remove(servicio);
		servicio.setCategoriaBean(null);

		return servicio;
	}*/

}