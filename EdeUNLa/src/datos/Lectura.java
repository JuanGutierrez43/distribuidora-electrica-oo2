package datos;

import java.time.LocalDate;

public class Lectura {
	private long idLectura;
	private LocalDate fecha;
	private Inspector inspector;
	
	public Lectura(LocalDate fecha, Inspector inspector) {
		super();
		this.fecha = fecha;
		this.inspector = inspector;
	}

	public long getIdLectura() {
		return idLectura;
	}

	protected void setIdLectura(long idLectura) {
		this.idLectura = idLectura;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Inspector getInspector() {
		return inspector;
	}

	public void setInspector(Inspector inspector) {
		this.inspector = inspector;
	}

	@Override
	public String toString() {
		return "Lectura [idLectura=" + idLectura + ", fecha=" + fecha + ", inspector=" + inspector + "]";
	}
}