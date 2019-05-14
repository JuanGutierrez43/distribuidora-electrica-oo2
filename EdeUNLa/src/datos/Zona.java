package datos;

public class Zona {
	
	private int idZona;
	private String descripcion;
	
	public Zona(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public int getIdZona() {
		return idZona;
	}

	protected void setIdZona(int idZona) {
		this.idZona = idZona;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Zona [idZona=" + idZona + ", descripcion=" + descripcion + "]";
	}
	
	
	
}
