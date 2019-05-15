package datos;

import java.time.LocalDate;

public class AltaDemanda extends Lectura {

	private int consumoHorasValle;
	private int consumoHoraPico;
	private int consumoHorasResto;

	public AltaDemanda() {
	}

	public AltaDemanda(LocalDate fecha, Inspector inspector, Medidor medidor, int consumoHorasValle,
			int consumoHoraPico, int consumoHorasResto) {
		super(fecha, inspector, medidor);
		this.consumoHorasValle = consumoHorasValle;
		this.consumoHoraPico = consumoHoraPico;
		this.consumoHorasResto = consumoHorasResto;
	}

	public int getConsumoHorasValle() {
		return consumoHorasValle;
	}

	public void setConsumoHorasValle(int consumoHorasValle) {
		this.consumoHorasValle = consumoHorasValle;
	}

	public int getConsumoHoraPico() {
		return consumoHoraPico;
	}

	public void setConsumoHoraPico(int consumoHoraPico) {
		this.consumoHoraPico = consumoHoraPico;
	}

	public int getConsumoHorasResto() {
		return consumoHorasResto;
	}

	public void setConsumoHorasResto(int consumoHorasResto) {
		this.consumoHorasResto = consumoHorasResto;
	}

	@Override
	public String toString() {
		return "AltaDemanda [consumoHorasValle=" + consumoHorasValle + ", consumoHoraPico=" + consumoHoraPico
				+ ", consumoHorasResto=" + consumoHorasResto + ", getIdLectura()=" + getIdLectura() + ", getFecha()="
				+ getFecha() + ", getInspector()=" + getInspector() + ", getMedidor()=" + getMedidor() + "]";
	}

}
