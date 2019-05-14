package datos;

import java.util.Set;

public class Inspector {
		
	private int idInspector;
	private Set<Zona> lstZona;
	private String nombre;
	private String apellido;
	private long dni;
	private long telefonoMovil;
	
	public Inspector(Set<Zona> lstZona, String nombre, String apellido, long dni, long telefonoMovil) {
		super();
		this.lstZona = lstZona;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.telefonoMovil = telefonoMovil;
	}

	public int getIdInspector() {
		return idInspector;
	}

	protected void setIdInspector(int idInspector) {
		this.idInspector = idInspector;
	}

	public Set<Zona> getLstZona() {
		return lstZona;
	}

	public void setLstZona(Set<Zona> lstZona) {
		this.lstZona = lstZona;
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

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public long getTelefonoMovil() {
		return telefonoMovil;
	}

	public void setTelefonoMovil(long telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}

	@Override
	public String toString() {
		return "Inspector [idInspector=" + idInspector + ", nombre=" + nombre + ", apellido=" + apellido + ", dni="
				+ dni + ", telefonoMovil=" + telefonoMovil + "]";
	}
	
	
	
}
