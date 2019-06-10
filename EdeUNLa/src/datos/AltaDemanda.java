package datos;

import java.time.LocalDate;

public class AltaDemanda extends Lectura {

	private int consumoHorasValle;
	private int consumoHorasPico;
	private int consumoHorasResto;

	public AltaDemanda() {
	}

	public AltaDemanda(LocalDate fecha, Inspector inspector, Medidor medidor, int consumoHorasValle, int consumoHoraPico, int consumoHorasResto) {
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

	public int calcularConsumoHorasValle(AltaDemanda altaDemanda) {
		return this.getConsumoHorasValle()-altaDemanda.getConsumoHorasValle();
	}
	
	public int calcularConsumoHorasPico(AltaDemanda altaDemanda) {
		return this.getConsumoHorasPico()-altaDemanda.getConsumoHorasPico();
	}
	
	public int calcularConsumoHorasResto(AltaDemanda altaDemanda) {
		return this.getConsumoHorasResto()-altaDemanda.getConsumoHorasResto();
	}
	
	@Override
	public String toString() {
		return "AltaDemanda [consumoHorasValle=" + consumoHorasValle + ", consumoHorasPico=" + consumoHorasPico
				+ ", consumoHorasResto=" + consumoHorasResto + ", IdLectura()=" + getIdLectura() + ", Fecha()="
				+ getFecha() + "]\n";
	}

}
