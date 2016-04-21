package derivador;

public class Derivador {
	
	public static void main (String args []){
		//Generar archivo de propiedades a partir de configuracion seleccionada
		PropertiesWriter propertiesWriter = new PropertiesWriter();
		propertiesWriter.generateProperties();
		
		//Leer el archivo de propiedades para posterior procesamiento
		PropertiesLoader propsLoader = PropertiesLoader.getInstance();
		
			
	}

}
