package fabricas.mensajeria;

import java.util.List;

import fabricas.entidades.Mensajeria;
import fabricas.persistencia.MensajeriaDao;

public class ServiciosMensajeria {
	private MensajeriaDao dao;

	public ServiciosMensajeria() {
		dao = new MensajeriaDao();
	}

	public Mensajeria enviarMensaje(Mensajeria mensaje) {
		return dao.crearMensaje(mensaje);
	}

	public List<Mensajeria> cargarMensajesRecibidos(int id) {
		return dao.getMensajesRecibidosUsuario(id);
	}

	public List<Mensajeria> cargarMensajesEnviados(int id) {
		return dao.getMensajesEnviadosUsuario(id);
	}

	public Mensajeria getMensaje(int id) {
		return dao.findById(id);
	}

}
