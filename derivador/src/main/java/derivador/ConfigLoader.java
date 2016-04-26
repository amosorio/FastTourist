package derivador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ConfigLoader {

	public List<String> cargarConfiguracion() {
		String line = null;
		List<String> features = new ArrayList<String>();

		try {
			// Carga el archivo que contiene la configuración seleccionada
			FileReader fileReader = new FileReader(
					"configuracion/default.config");

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			// Se leen cada uno de los features de la configuracion
			while ((line = bufferedReader.readLine()) != null) {
				features.add(line);
			}

			bufferedReader.close();
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
		}
		return features;
	}

}
