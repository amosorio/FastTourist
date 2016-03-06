package fabricas.entidades;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the servicios database table.
 * 
 */
@Entity
@Table(name="servicios")
@NamedQueries({
	@NamedQuery(name="Servicio.findAll", query="SELECT s FROM Servicio s"),
	@NamedQuery(name="Servicio.findById", query="SELECT s FROM Servicio s where s.idservicios = :id"),
}) 


public class Servicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idservicios;

	private boolean activo;

	private String descripcion;

	private BigDecimal descuento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	private String nombre;

	private BigDecimal precio;

	@Column(name="ruta_galeria")
	private String rutaGaleria;

	//bi-directional many-to-one association to Calificaciones
	@OneToMany(mappedBy="servicioBean")
	@JsonManagedReference
	private List<Calificaciones> calificaciones;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="categoria")
	@JsonManagedReference
	private Categoria categoriaBean;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="proveedor")
	
	private Usuario usuario;

	//bi-directional many-to-many association to Paquete
	@ManyToMany
	@JoinTable(
		name="servicios_por_paquete"
		, joinColumns={
			@JoinColumn(name="servicio")
			}
		, inverseJoinColumns={
			@JoinColumn(name="paquete")
			}
		)
	@JsonManagedReference
	private List<Paquete> paquetes;

	public Servicio() {
	}

	public int getIdservicios() {
		return this.idservicios;
	}

	public void setIdservicios(int idservicios) {
		this.idservicios = idservicios;
	}

	public boolean getActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getDescuento() {
		return this.descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
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

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public String getRutaGaleria() {
		return this.rutaGaleria;
	}

	public void setRutaGaleria(String rutaGaleria) {
		this.rutaGaleria = rutaGaleria;
	}

	public List<Calificaciones> getCalificaciones() {
		return this.calificaciones;
	}

	public void setCalificaciones(List<Calificaciones> calificaciones) {
		this.calificaciones = calificaciones;
	}

	public Calificaciones addCalificacione(Calificaciones calificacione) {
		getCalificaciones().add(calificacione);
		calificacione.setServicioBean(this);

		return calificacione;
	}

	public Calificaciones removeCalificacione(Calificaciones calificacione) {
		getCalificaciones().remove(calificacione);
		calificacione.setServicioBean(null);

		return calificacione;
	}

	public Categoria getCategoriaBean() {
		return this.categoriaBean;
	}

	public void setCategoriaBean(Categoria categoriaBean) {
		this.categoriaBean = categoriaBean;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Paquete> getPaquetes() {
		return this.paquetes;
	}

	public void setPaquetes(List<Paquete> paquetes) {
		this.paquetes = paquetes;
	}

}