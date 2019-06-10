package datos;

import java.util.Set;

public class TarifaAlta extends Tarifa implements Comparable<Tarifa> {

	private String tensionContratada;
	private int limite;
	private Set<DetalleAlta> lstDetalle;

	public TarifaAlta() {
	}

	public TarifaAlta(String servicio, String tensionContratada, int limite) {
		super(servicio);
		this.tensionContratada = tensionContratada;
		this.limite = limite;
	}

	public String getTensionContratada() {
		return tensionContratada;
	}

	public void setTensionContratada(String tensionContratada) {
		this.tensionContratada = tensionContratada;
	}

	public int getLimite() {
		return limite;
	}

	public void setLimite(int limite) {
		this.limite = limite;
	}

	public Set<DetalleAlta> getLstDetalle() {
		return lstDetalle;
	}

	public void setLstDetalle(Set<DetalleAlta> lstDetalle) {
		this.lstDetalle = lstDetalle;
	}

	@Override
	public String toString() {
		return "TarifaAlta [tensionContratada=" + tensionContratada + ", limite=" + limite + ", lstDetalle="
				+ "]\n";
	}

	@Override
	public int compareTo(Tarifa tarifa) {
		int resultado = 0;
		if (this.getLimite() < ((TarifaAlta)tarifa).getLimite()) {
			resultado = -1;
		} else if (this.getLimite() >  ((TarifaAlta)tarifa).getLimite()) {
			resultado = 1;
		} else {
			resultado = 0;
		}
		return resultado;
	}
	
}
