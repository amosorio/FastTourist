package derivador;

import java.util.List;

public class Derivador {
	
	static List<String> features = null;
	
	public static void main (String args []){
		
		LoaderConfig propertiesWriter = new LoaderConfig();
		
		try{
			//Se obtienen los features de la configuracion
			features = propertiesWriter.cargarConfiguracion();
	
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	
	public static void procesadorProductos(){
		
		//Metodo: BinaryReplacement
		if(features.contains(Constantes.MODULO_BUSQUEDA_PERSONALIZADA)){
			
		}
		//Metodo: Aspectos
		if(features.contains(Constantes.MODULO_MENSAJERIA)){
			
		}
		//Metodo: Patron
		if(features.contains(Constantes.MODULO_CALIFICACIONES)){
			
		}
		//Metodo:Patron
		if(features.contains(Constantes.MODULO_REPORTES)){
			
		}
	}

}
