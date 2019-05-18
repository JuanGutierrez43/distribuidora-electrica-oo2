package datos;

import java.util.Set;

public class Zona {
	
	private int idZona;
	private String descripcion;
	private Set<Inspector> inspectores;
	
	public Zona() {
		
	}
	
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

	public Set<Inspector> getInspectores() {
		return inspectores;
	}

	public void setInspectores(Set<Inspector> inspectores) {
		this.inspectores = inspectores;
	}

	@Override
	public String toString() {
		return "Zona [idZona=" + idZona + ", descripcion=" + descripcion + ", inspectores=" + inspectores + "]";
	}
	
	
	
	
}
