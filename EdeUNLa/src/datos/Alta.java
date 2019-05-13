package datos;

import java.time.LocalDate;

public class Alta extends Lectura{
	private int consumoHorasValle;
	private int consumoHorasPico;
	private int consumoHorasResto;
	
	public Alta(LocalDate fecha, Inspector inspector, int consumoHorasValle, int consumoHorasPico,
			int consumoHorasResto) {
		super(fecha, inspector);
		this.consumoHorasValle = consumoHorasValle;
		this.consumoHorasPico = consumoHorasPico;
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
		return "Alta [consumoHorasValle=" + consumoHorasValle + ", consumoHorasPico=" + consumoHorasPico
				+ ", consumoHorasResto=" + consumoHorasResto + "]";
	}
}