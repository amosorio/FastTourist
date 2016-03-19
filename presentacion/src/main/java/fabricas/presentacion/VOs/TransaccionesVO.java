package fabricas.presentacion.VOs;

import java.io.Serializable;

public class TransaccionesVO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int idtransacciones;

	private String descripcion;

	
	private UsuarioVO usuario;

	private EstadoTransaccionVO estadoTransaccion;

	
	private PaqueteVO paqueteBean;

	public TransaccionesVO() {
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

	public UsuarioVO getUsuario() {
		return this.usuario;
	}

	public void setUsuario(UsuarioVO usuario) {
		this.usuario = usuario;
	}

	public EstadoTransaccionVO getEstadoTransaccion() {
		return this.estadoTransaccion;
	}

	public void setEstadoTransaccion(EstadoTransaccionVO estadoTransaccion) {
		this.estadoTransaccion = estadoTransaccion;
	}

	public PaqueteVO getPaqueteBean() {
		return this.paqueteBean;
	}

	public void setPaqueteBean(PaqueteVO paqueteBean) {
		this.paqueteBean = paqueteBean;
	}

}