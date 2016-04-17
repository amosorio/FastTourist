package derivador;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {

	private static Properties properties;
	private static PropertiesLoader instance;


	public static PropertiesLoader getInstance() {
		if(instance == null){
			instance = new PropertiesLoader();
			properties = new Properties();
			 try {
					FileInputStream in = new FileInputStream(Constantes.RUTA_REPO_LOCAL+
							Constantes.PROYECTO_LOGICA+"/properties/default.properties");
					properties.load(in);
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

		}
		return instance;
	}

	public String getProperty(String key){
		return properties.getProperty(key);
	}

}
