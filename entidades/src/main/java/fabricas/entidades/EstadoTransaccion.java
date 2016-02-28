package fabricas.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estado_transaccion database table.
 * 
 */
@Entity
@Table(name="estado_transaccion")
@NamedQuery(name="EstadoTransaccion.findAll", query="SELECT e FROM EstadoTransaccion e")
public class EstadoTransaccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idestado_transaccion")
	private int idestadoTransaccion;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to Transaccione
	@OneToMany(mappedBy="estadoTransaccion")
	private List<Transacciones> transacciones;

	public EstadoTransaccion() {
	}

	public int getIdestadoTransaccion() {
		return this.idestadoTransaccion;
	}

	public void setIdestadoTransaccion(int idestadoTransaccion) {
		this.idestadoTransaccion = idestadoTransaccion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Transacciones> getTransacciones() {
		return this.transacciones;
	}

	public void setTransacciones(List<Transacciones> transacciones) {
		this.transacciones = transacciones;
	}

	public Transacciones addTransaccione(Transacciones transaccione) {
		getTransacciones().add(transaccione);
		transaccione.setEstadoTransaccion(this);

		return transaccione;
	}

	public Transacciones removeTransaccione(Transacciones transaccione) {
		getTransacciones().remove(transaccione);
		transaccione.setEstadoTransaccion(null);

		return transaccione;
	}

}