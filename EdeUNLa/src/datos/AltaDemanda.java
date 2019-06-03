package datos;

import java.time.LocalDate;

public class AltaDemanda extends Lectura {

	private int consumoHorasValle;
	private int consumoHorasPico;
	private int consumoHorasResto;

	public AltaDemanda() {
	}

	public AltaDemanda(LocalDate fecha, Inspector inspector, Medidor medidor, int consumoHorasValle,
			int consumoHoraPico, int consumoHorasResto) {
		super(fecha, inspector, medidor);
		this.consumoHorasValle = consumoHorasValle;
		this.consumoHorasPico = consumoHoraPico;
		this.consumoHorasResto = consumoHorasResto;
	}

	public int getConsumoHorasValle() {
		return consumoHorasValle;
	}

	public void setConsumoHorasValle(int consumoHorasValle) {
		this.consumoHorasValle = consumoHorasValle;
	}

	public int getConsumoHorasPico() {
		return consumoHorasPico;
	}

	public void setConsumoHorasPico(int consumoHorasPico) {
		this.consumoHorasPico = consumoHorasPico;
	}

	public int getConsumoHorasResto() {
		return consumoHorasResto;
	}

	public void setConsumoHorasResto(int consumoHorasResto) {
		this.consumoHorasResto = consumoHorasResto;
	}

	@Override
	public String toString() {
		return "AltaDemanda [consumoHorasValle=" + consumoHorasValle + ", consumoHorasPico=" + consumoHorasPico
				+ ", consumoHorasResto=" + consumoHorasResto + ", IdLectura()=" + getIdLectura() + ", Fecha()="
				+ getFecha() + ", Inspector()=" + getInspector() + ", Medidor()=" + getMedidor() + "]\n";
	}

}
