package derivador;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiesWritter {


	public static void cargarConfiguracion(Properties properties){	
		
		try{
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
}
