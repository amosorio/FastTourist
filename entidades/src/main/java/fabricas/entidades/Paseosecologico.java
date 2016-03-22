package fabricas.entidades;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;


/**
 * The persistent class for the paseosecologicos database table.
 * 
 */
@Entity
@Table(name="paseosecologicos")
@NamedQuery(name="Paseosecologico.findAll", query="SELECT p FROM Paseosecologico p")
public class Paseosecologico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idPaseosEcologicos;

	private String lugar;

	private String nombre;

	//bi-directional many-to-one association to Servicio
	@OneToMany(mappedBy="paseosecologico")
	@JsonBackReference
	private List<Servicio> servicios;

	public Paseosecologico() {
	}

	public int getIdPaseosEcologicos() {
		return this.idPaseosEcologicos;
	}

	public void setIdPaseosEcologicos(int idPaseosEcologicos) {
		this.idPaseosEcologicos = idPaseosEcologicos;
	}

	public String getLugar() {
		return this.lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
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

	public Servicio addServicio(Servicio servicio) {
		getServicios().add(servicio);
		servicio.setPaseosecologico(this);

		return servicio;
	}

	public Servicio removeServicio(Servicio servicio) {
		getServicios().remove(servicio);
		servicio.setPaseosecologico(null);

		return servicio;
	}

}