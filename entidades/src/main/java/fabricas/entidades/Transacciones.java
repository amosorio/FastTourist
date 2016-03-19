package fabricas.entidades;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the transacciones database table.
 * 
 */
@Entity
@Table(name="transacciones")
@NamedQuery(name="Transacciones.findAll", query="SELECT t FROM Transacciones t")
public class Transacciones implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idtransacciones;

	private String descripcion;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="cliente")
	
	private Usuario usuario;

	//bi-directional many-to-one association to EstadoTransaccion
	@ManyToOne
	@JoinColumn(name="estado")
	
	private EstadoTransaccion estadoTransaccion;

	//bi-directional many-to-one association to Paquete
	@ManyToOne
	@JoinColumn(name="paquete")
	
	private Paquete paquete;

	public Transacciones() {
	}

	public int getIdtransacciones() {
		return this.idtransacciones;
	}

	public void setIdtransacciones(int idtransacciones) {
		this.idtransacciones = idtransacciones;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public EstadoTransaccion getEstadoTransaccion() {
		return this.estadoTransaccion;
	}

	public void setEstadoTransaccion(EstadoTransaccion estadoTransaccion) {
		this.estadoTransaccion = estadoTransaccion;
	}

	public Paquete getPaquete() {
		return this.paquete;
	}

	public void setPaquete(Paquete paquete) {
		this.paquete = paquete;
	}

}