package utilidades;


public enum EnumPerfiles {
		PROVEEDOR(1), CLIENTE(2), ADMINISTRADOR(3);
		private int value;

	    EnumPerfiles(int value) {
	        this.value = value;
	    }

	    public int getValue() {
	        return value;
	    }
	
}
