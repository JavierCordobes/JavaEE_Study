package ejercicio5;

public class Linea {
	
	private int codigo;
	private String nombre;
	private int cantidad; 
	
	public Linea() {
		this.codigo= 0;
		this.nombre = "";
		this.cantidad=0;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	

}
