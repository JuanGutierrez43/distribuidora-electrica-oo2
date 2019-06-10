package datos;

import java.time.LocalDate;

public class Lectura implements Comparable<Lectura> {
	private long idLectura;
	private LocalDate fecha;
	private Inspector inspector;
	private Medidor medidor;
	
	public Lectura() {
	}
	
	public Lectura(LocalDate fecha, Inspector inspector,Medidor medidor) {
		super();
		this.fecha = fecha;
		this.inspector = inspector;
		this.medidor= medidor;
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

	public Medidor getMedidor() {
		return medidor;
	}

	public void setMedidor(Medidor medidor) {
		this.medidor = medidor;
	}

	@Override
	public String toString() {
		return "Lectura [idLectura=" + idLectura + ", fecha=" + fecha + ", "
				+ "\n inspector=" + inspector + ", "
				+ "\n medidor="	+ medidor + "]";
	}

	@Override
	public int compareTo(Lectura lectura) {
		int resultado = 0;
		if (this.fecha.isBefore(lectura.getFecha())) {
			resultado = -1;
		} else if (this.fecha.isAfter(lectura.getFecha())) {
			resultado = 1;
		} else {
			resultado = 0;
		}
		return resultado;
	}
	
	
}