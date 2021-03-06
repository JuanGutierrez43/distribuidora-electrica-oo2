package datos;

import java.time.LocalDate;

public class BajaDemanda extends Lectura {

	private int consumo;

	public BajaDemanda() {
	}

	public BajaDemanda(LocalDate fecha, Inspector inspector, Medidor medidor, int consumo) {
		super(fecha, inspector, medidor);
		this.consumo = consumo;
	}

	public int getConsumo() {
		return consumo;
	}

	public int calcularConsumo(BajaDemanda bajaDemanda) {
		return consumo-bajaDemanda.getConsumo();
	}
	
	public void setConsumo(int consumo) {
		this.consumo = consumo;
	}

	@Override
	public String toString() {
		return "BajaDemanda [consumo=" + consumo + ", IdLectura=" + getIdLectura() + ", Fecha=" + getFecha()
				+ "]\n";
	}

}
