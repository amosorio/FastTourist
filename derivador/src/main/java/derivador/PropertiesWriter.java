package derivador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesWriter {

	private static Properties properties;
	//Se debe poner la ruta del repositorio local de git



	public PropertiesWriter() {
	}

	public void generateProperties(){	
		String line = null;
		properties = new Properties();
		ArrayList<String> opcionales = cargarOpcionales();

		try{
			// Carga el archivo que contiene la configuración seleccionada
			FileReader fileReader = 
					new FileReader(Constantes.RUTA_REPO_LOCAL+
							Constantes.PROYECTO_VARIABILIDAD+"/configs/default.config");

			BufferedReader bufferedReader = 
					new BufferedReader(fileReader);

			//Se leen cada uno de los features de la configuracion y se pasan al archivo de propiedades
			while((line = bufferedReader.readLine()) != null) {
				properties.setProperty(line, "True");
			}

			//Los features opcionales que no fueron seleccionados en la configuracion
			//Se cargan en el archivo de propiedades con valor False
			for (String key : opcionales) {
				if(!properties.containsKey(key)){
					properties.setProperty(key, "False");
				}
			}

			//Se guarda el archivo de propiedades en la capa de presentacion del market place
			File file = new File(Constantes.RUTA_REPO_LOCAL 
					+ Constantes.PROYECTO_PRESENTACION +"/properties/default.properties");
			FileOutputStream fileOut;
			fileOut = new FileOutputStream(file);
			properties.store(fileOut, "Se genera el properties apartir del archivo config de productos");

			//Se guarda el archivo de propiedades en la capa de servicios del market place
			file = new File(Constantes.RUTA_REPO_LOCAL + 
					Constantes.PROYECTO_LOGICA +"/properties/default.properties");
			fileOut = new FileOutputStream(file);
			properties.store(fileOut, "Se genera el properties apartir del archivo config de productos");

			fileOut.close();
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
		}
	}

	private ArrayList<String> cargarOpcionales(){
		Map<String, String> mapaOpcionales = new HashMap<String, String>();

		ArrayList<String> vector = new ArrayList<String>();
		vector.add("PublicarEnRedes");
		vector.add("PublicarFacebook");
		vector.add("PublicarTwitter");
		vector.add("CalificarServivio");
		vector.add("ComentarServicio");
		vector.add("Mensajeria");
		vector.add("RegistroFacebook");
		vector.add("RegistroTwitter");
		vector.add("AutenticacionFacebook");
		vector.add("AutenticacionTwitter");
		vector.add("ModuloReportes");
		vector.add("ReporteBusquedas");
		vector.add("ReporteVentas");
		vector.add("ReporteConsultas");
		vector.add("ModuloBusquedaPersonalizada");
		vector.add("CargarBusquedasRecientes");
		vector.add("AlmacenarBusquedasRecientes");

		return vector;


	}
}
