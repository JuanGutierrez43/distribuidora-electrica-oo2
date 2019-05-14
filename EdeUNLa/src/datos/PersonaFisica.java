package datos;

public class PersonaFisica extends Cliente{

	private long dni;
	private String nombre;
	private String apellido;

	
	public PersonaFisica(String direccion, String email, long telefonoFijo, long telefonoMovil, long dni, String nombre, String apellido) {
		super(direccion, email, telefonoFijo, telefonoMovil);
		this.dni=dni;
		this.nombre=nombre;
		this.apellido=apellido;
	}


	public long getDni() {
		return dni;
	}


	public void setDni(long dni) {
		this.dni = dni;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	@Override
	public String toString() {
		return "PersonaFisica [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	
	
}
