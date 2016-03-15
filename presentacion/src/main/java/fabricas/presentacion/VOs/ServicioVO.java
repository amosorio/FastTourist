package fabricas.presentacion.VOs;

import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the servicios database table.
 * 
 */

public class ServicioVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idservicios;
	private boolean activo;
	private String descripcion;
	private BigDecimal descuento;
	private Date fechaCreacion;
	private String nombre;
	private BigDecimal precio;
	private String rutaGaleria;
	private List<CalificacionesVO> calificaciones;
	private CategoriaVO categoria;	
	private UsuarioVO usuario;
	private List<PaqueteVO> paquetes;

	public ServicioVO() {
	}

	/**
	 * @return the idservicios
	 */
	public int getIdservicios() {
		return idservicios;
	}

	/**
	 * @param idservicios the idservicios to set
	 */
	public void setIdservicios(int idservicios) {
		this.idservicios = idservicios;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getDescuento() {
		return descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public String getRutaGaleria() {
		return rutaGaleria;
	}

	public void setRutaGaleria(String rutaGaleria) {
		this.rutaGaleria = rutaGaleria;
	}

	public List<CalificacionesVO> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(List<CalificacionesVO> calificaciones) {
		this.calificaciones = calificaciones;
	}

	public CategoriaVO getCategoria() {
		return categoria;
	}

	public void setCategoriaBean(CategoriaVO categoria) {
		this.categoria = categoria;
	}

	public UsuarioVO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioVO usuario) {
		this.usuario = usuario;
	}

	public List<PaqueteVO> getPaquetes() {
		return paquetes;
	}

	public void setPaquetes(List<PaqueteVO> paquetes) {
		this.paquetes = paquetes;
	}

	
}