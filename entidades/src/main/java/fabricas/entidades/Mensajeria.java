package fabricas.entidades;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Date;


/**
 * The persistent class for the mensajeria database table.
 * 
 */
@Entity
@NamedQuery(name="Mensajeria.findAll", query="SELECT m FROM Mensajeria m")
public class Mensajeria implements Serializable {
	private static final long serialVersionUID = 1L;
	@GeneratedValue
	@Id
	private int id;

	private String asunto;

	private Boolean estado;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	private String mensaje;

	//bi-directional many-to-one association to Usuario
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="destinatario")
	private Usuario destinatario;

	//bi-directional many-to-one association to Usuario
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="remitente")
	private Usuario remitente;

	public Mensajeria() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAsunto() {
		return this.asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public Boolean getEstado() {
		return this.estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getMensaje() {
		return this.mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Usuario getDestinatario() {
		return this.destinatario;
	}

	public void setDestinatario(Usuario destinatario) {
		this.destinatario = destinatario;
	}

	public Usuario getRemitente() {
		return this.remitente;
	}

	public void setRemitente(Usuario remitente) {
		this.remitente = remitente;
	}

}