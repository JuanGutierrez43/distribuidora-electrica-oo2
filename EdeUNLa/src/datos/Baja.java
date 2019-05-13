package datos;

import java.time.LocalDate;

public class Baja extends Lectura{
	private int consumo;

	public Baja(LocalDate fecha, Inspector inspector, int consumo) {
		super(fecha, inspector);
		this.consumo = consumo;
	}

	public int getConsumo() {
		return consumo;
	}

	public void setConsumo(int consumo) {
		this.consumo = consumo;
	}

	@Override
	public String toString() {
		return "Baja [consumo=" + consumo + "]";
	}
}