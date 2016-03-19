package fabricas.presentacion.VOs;

import java.io.Serializable;
import java.util.List;


public class PaseosecologicoVO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int idPaseosEcologicos;

	private String lugar;

	private String nombre;

	
	private List<ServicioVO> servicioVO;

	public PaseosecologicoVO() {
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

	public List<ServicioVO> getServicioVO() {
		return this.servicioVO;
	}

	public void setServicioVO(List<ServicioVO> servicioVO) {
		this.servicioVO = servicioVO;
	}
}