package utilidades;


public enum EnumCategorias {
		ALOJAMIENTO(1), ALIMENTACION(2), TRANSPORTE(3), 
		PASEOS(4);
		private int value;

	    EnumCategorias(int value) {
	        this.value = value;
	    }

	    public int getValue() {
	        return value;
	    }
	
}
