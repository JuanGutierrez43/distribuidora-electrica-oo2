package datos;

public class Tarifa {

	private int idTarifa;
	private String servicio;

	public Tarifa() {
	}

	public Tarifa(String servicio) {
		super();
		this.servicio = servicio;
	}

	public int getIdTarifa() {
		return idTarifa;
	}

	protected void setIdTarifa(int idTarifa) {
		this.idTarifa = idTarifa;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	@Override
	public String toString() {
		return "Tarifa [idTarifa=" + idTarifa + ", servicio=" + servicio + "]";
	}

}
