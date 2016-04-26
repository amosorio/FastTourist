package derivador;

import java.util.List;
import java.util.Properties;

public class Derivador {

	static List<String> features = null;
	static Properties properties = null;

	public static void main(String args[]) {

		ConfigLoader propertiesWriter = new ConfigLoader();

		try {
			// Se obtienen los features de la configuracion
			features = propertiesWriter.cargarConfiguracion();
			// Se genera el Producto
			productGenerator();
			// Se escribe el archivo de propiedades
			PropertiesWritter.cargarConfiguracion(properties);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void productGenerator() {

		properties = new Properties();

		// Metodo: BinaryReplacement
		if (features.contains(Constantes.MODULO_BUSQUEDA_PERSONALIZADA)) {
			properties.setProperty(Constantes.MODULO_BUSQUEDA_PERSONALIZADA,
					"True");

			/**
			 * Incluir dependencia en pom.xml
			 */

		} else {
			properties.setProperty(Constantes.MODULO_BUSQUEDA_PERSONALIZADA,
					"False");
		}
		
		
		// Metodo: Aspectos
		if (features.contains(Constantes.MODULO_MENSAJERIA)) {
			properties.setProperty(Constantes.MODULO_MENSAJERIA, "True");
			/**
			 * Tejer Aspecto
			 */
		} else {
			properties.setProperty(Constantes.MODULO_MENSAJERIA, "False");
		}

		
		// Metodo: Patron
		if (features.contains(Constantes.MODULO_CALIFICACIONES)) {
			properties.setProperty(Constantes.MODULO_CALIFICACIONES, "True");
		} else {
			properties.setProperty(Constantes.MODULO_CALIFICACIONES, "False");
		}
		
		
		// Metodo:Patron
		if (features.contains(Constantes.MODULO_REPORTES)) {
			properties.setProperty(Constantes.MODULO_REPORTES, "True");
		} else {
			properties.setProperty(Constantes.MODULO_REPORTES, "False");
		}
	}

}
